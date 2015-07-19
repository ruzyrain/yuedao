package com.YueDao.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.YueDao.web.entity.Goods;

@Repository("goodsDAO")
public class GoodsDAO{
	@Autowired
	@Qualifier("hibernateTemplate")
	HibernateTemplate hibernateTemplate;

	public List<Goods> getAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Goods> listGoods=hibernateTemplate.find("from Goods");
		return listGoods;
	}

	public boolean add(Goods goods) {
		// TODO Auto-generated method stub
		try
		{
			hibernateTemplate.save(goods);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean change(Goods goods) {
		// TODO Auto-generated method stub
		try {
			String hql = "update Goods set name=?,price=?,info=?,description=?,praise=?where id=? ";
			int num = hibernateTemplate.bulkUpdate(hql,
					goods.getName(),goods.getPrice(),goods.getInfo(),goods.getDescription(),goods.getPraise(),goods.getId());
			return num > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try
		{
			String hql="delete Goods where id=?";
			int num=hibernateTemplate.bulkUpdate(hql,id);
			return num>0;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Goods getById(int id) {
		// TODO Auto-generated method stub
		List<Goods> listGoods=hibernateTemplate.find("from Goods where id=?",id);
		if(listGoods.isEmpty())
			return null;
		return listGoods.get(0);
	}

	public void ChangeGoodsImg(int id, int num, String url) {
		// TODO Auto-generated method stub
		try {
			String hql = "update Goods set imageurl"+num+"=? where Id=? ";
			hibernateTemplate.bulkUpdate(hql,url,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
