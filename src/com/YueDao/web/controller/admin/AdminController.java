package com.YueDao.web.controller.admin;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.YueDao.web.base.BaseJsonJumpAction;
import com.YueDao.web.entity.Admin;
import com.YueDao.web.service.AdminService;
import com.YueDao.web.util.Tools;
import com.YueDao.web.util.VerifyEmptyUtils;

@Controller
@RequestMapping(value = "admin/")
public class AdminController extends BaseJsonJumpAction {

	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;

	@PostConstruct
	public void initJmodule() {

		super.setJmodule("admin/");
	}

	// 登录页面 ---首页
	@RequestMapping("")
	public String Default(ModelMap map, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			return "redirect:main";
		}
		return ModuleUrl("login");
	}

	// 登录验证，返回json
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap login(Admin admin, HttpSession session, HttpServletRequest request) {
		if (VerifyEmptyUtils.VerifyEmpty(admin)) {
			return msg("账号，密码不允许为空");
		}
		if ((admin = adminService.VerifyPassword(admin)) != null) {
			// 填空属性
			session.setAttribute("admin", admin);// 登录成功写session属性
			return jump("main");
		}

		// 填空属性
		return msg("账号，密码错误");

	}

	@RequestMapping("main")
	// 外层框架
	public String main(ModelMap map, HttpSession session) {
		if (session.getAttribute("admin") == null) {
			return "redirect:";// 没有登录就跳转到登录页面
		}

		return ModuleUrl("main");
	}

	@RequestMapping("passwordXiugai")
	// 密码修改
	public String passwordXiugai(ModelMap map, HttpSession session) {
		if (session.getAttribute("admin") == null) {
			return "redirect:";// 没有登录就跳转到登录页面
		}
		return ModuleUrl("passwordXiugai");
	}

	// 登录验证，返回json
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap logout(HttpSession session) {
		session.removeAttribute("admin");
		return jump("");
	}

	// 管理员修改自身密码请求
	@RequestMapping("/passwordXiugaiDo")
	public @ResponseBody
	ModelMap passwordXiugaiDo(String PassWord, String NewPassWord,
			String NewPassWordAgain, HttpSession session) {

		if (session.getAttribute("admin") == null) {
			return jump("login");
		}

		if (!NewPassWord.equalsIgnoreCase(NewPassWordAgain)) {
			return msg("两次输入不一致");
		}
		if (NewPassWord == null || NewPassWord.isEmpty()) {
			return msg("密码不允许为空");
		}
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin == null)// 没有登录
		{
			return jump("login");
		}
		if (!adminService.verifyPassword(admin.getUsername(), PassWord)) {
			return msg("修改密码失败，原密码错误");
		}
		if (adminService.reSetPassword(admin.getUsername(), NewPassWord)) {
			return jump("passwordXiugai", "修改密码成功");
		}
		return msg("修改密码失败");
	}

	@RequestMapping("adminList")
	public String adminList(ModelMap map, HttpSession session) {
		map.put("adminList", adminService.getAllAdmin());

		return ModuleUrl("adminList");
	}

	@RequestMapping("adminAdd")
	public String adminAdd(ModelMap map, HttpSession session) {

		return ModuleUrl("adminAdd");

	}

	@RequestMapping(value = "/adminAddDo", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap adminAddDo(Admin admin, ModelMap map, HttpSession session) {

		if (admin == null) {

			return null;

		}
		if(admin.getUsername()==null||admin.getUsername().isEmpty()||
				admin.getTruename()==null||admin.getUsername()==null)
		{
			return msg("不允许为空");
		}
	
		admin.setPassword(Tools.md5(admin.getUsername()));
		if (adminService.AddAdmin(admin)) {

			return jump("adminList", "初始密码与账号相同添加成功");
		}

		return msg("添加失败，账号相同");
	}

	@RequestMapping(value = "/adminDelete", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap adminDelete(int id, HttpServletRequest request) {
		if (adminService.DeleteAdmin(id)) {

			return jump("adminList", "删除成功");

		}

		return msg("删除失败");
	}

	@RequestMapping("adminChange")
	public String adminChange(int id, ModelMap map, HttpSession session) {
		Admin admin;
		if ((admin = adminService.getAdminById(id)) == null) {
			return ModuleUrl("adminList");
		}
		map.put("admin", admin);
		return ModuleUrl("adminChange");
	}

	@RequestMapping(value = "/adminChangeDo", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap adminChangeDo(Admin admin, ModelMap map, HttpSession session) {
		if (admin == null) {
			return null;
		}
		if(admin.getTruename()==null||admin.getTruename().isEmpty())
		{
			return msg("不允许为空");
		}
		
		if (adminService.ChangeAdmin(admin)) {
			return jump("adminList", "修改成功");
		}
		return msg("修改失败");
	}

}
