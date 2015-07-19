package com.YueDao.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.YueDao.web.dao.GoodsDAO;
import com.YueDao.web.entity.Goods;

@Repository("goodsService")
@Transactional
public class GoodsService{

	@Autowired
	@Qualifier("goodsDAO")
	private GoodsDAO goodsDAO;

	public List<Goods> getAllGoods() {
		// TODO Auto-generated method stub
		return goodsDAO.getAll();
	}
	
	public boolean AddGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDAO.add(goods);
	}

	public boolean ChangeGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDAO.change(goods);
	}
	public Goods getGoodsById(int id) {
		// TODO Auto-generated method stub
		return goodsDAO.getById(id);
	}


	public boolean DeleteGoods(int id) {
		// TODO Auto-generated method stub
		return goodsDAO.delete(id);
	}

	public void ChangeGoodsImg(int id, int num, String url) {
		// TODO Auto-generated method stub
		goodsDAO.ChangeGoodsImg(id, num, url);
	}
	
}
