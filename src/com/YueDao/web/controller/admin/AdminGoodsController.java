package com.YueDao.web.controller.admin;



import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.YueDao.web.base.BaseJsonJumpAction;
import com.YueDao.web.entity.Goods;
import com.YueDao.web.service.GoodsService;
import com.YueDao.web.util.Tools;
import com.YueDao.web.util.VerifyEmptyUtils;

@Controller

@RequestMapping(value = "/admin")
public class AdminGoodsController extends BaseJsonJumpAction{

	@Autowired

	@Qualifier("goodsService")

	private GoodsService goodsService;


	@PostConstruct
	 
	public void initJmodule() {

		super.setJmodule("admin/");
	}

	@RequestMapping("goodsList")
	public String goodsList(ModelMap map, HttpSession session) {
		map.put("goodsList", goodsService.getAllGoods());

		return ModuleUrl("goodsList");
	}

	@RequestMapping("goodsAdd")
	public String goodsAdd(ModelMap map, HttpSession session) 
	{
			
		return ModuleUrl("goodsAdd");
	
	}



	@RequestMapping(value = "/goodsAddDo", method = RequestMethod.POST)

	public @ResponseBody
	ModelMap goodsAddDo(Goods goods,ModelMap map,HttpSession session) {

		if (goods == null) {

			return null;

		}

		if (VerifyEmptyUtils.VerifyEmpty(goods)) {

			return msg("不允许为空");

		}

		if (goodsService.AddGoods(goods)) {

			return jump("goodsList","添加成功");
		}

		return msg("添加失败，名称相同");
	}


	@RequestMapping(value="/goodsDelete",method = RequestMethod.POST)

	public @ResponseBody ModelMap goodsDelete(int id, HttpServletRequest request) {
		if (goodsService.DeleteGoods(id)) {

			return jump("goodsList","删除成功");

		}

		return msg("删除失败");
	}



	@RequestMapping("goodsChange")
	public String goodsChange(int id,ModelMap map, HttpSession session) {
		Goods goods;
		if((goods=goodsService.getGoodsById(id))==null)
		{
			return ModuleUrl("goodsList");
		}
		map.put("goods",goods);
		return ModuleUrl("goodsChange");
	}

	@RequestMapping(value = "/goodsChangeDo", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap goodsChangeDo(Goods goods,ModelMap map,HttpSession session) {
		if (goods == null) {
			return null;
		}
		if (VerifyEmptyUtils.VerifyEmpty(goods)) {
			return msg("不允许为空");
		}
		if (goodsService.ChangeGoods(goods)) {
			return jump("goodsList","修改成功");
		}
		return msg("修改失败");
	}
	
	
	@RequestMapping(value = "/GoodsImgUpload", method = RequestMethod.POST)
	public @ResponseBody
	String GoodsImgUpload(String returnFunction, String deleteUrl, int id,
			int num, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		if (num <= 0 || num > 5)// num为1,2,3,4,5
		{
			return "";
		}

		if (multipartResolver.isMultipart(request)) {
			String rootPath = request.getServletContext().getRealPath("/");
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null && !file.isEmpty()) {
					String fileName;
					File localFile;
					do {
						fileName = Tools.RandomName()
								+ "."
								+ file.getOriginalFilename().substring(
										file.getOriginalFilename().lastIndexOf(
												".") + 1);
						localFile = new File(rootPath + "\\Images\\Goods\\"
								+ fileName);
					} while (localFile.exists());

					file.transferTo(localFile);

					goodsService.ChangeGoodsImg(id, num, "/Images/Goods/"
							+ fileName);

					File srcfile = new File(rootPath + deleteUrl);// 之前的本地图片
					srcfile.delete();// 删除

					return "<script>parent." + returnFunction + "('"
							+ "/Images/Goods/" + fileName + "')" + "</script>";
				}
			}
		}
		return "<script>parent." + returnFunction + "('')" + "</script>";
	}


}
