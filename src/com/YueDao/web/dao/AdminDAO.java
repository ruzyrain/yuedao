package com.YueDao.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.YueDao.web.entity.Admin;

@Repository("adminDAO")
public class AdminDAO {
	@Autowired
	@Qualifier("hibernateTemplate")
	HibernateTemplate hibernateTemplate;

	// 验证账号和密码
	@SuppressWarnings("unchecked")
	public Admin VerifyPassword(Admin admin) {
		String queryString = "from Admin where username=? and password=?";
		List<Admin> userList = hibernateTemplate.find(queryString,
				admin.getUsername(), admin.getPassword());
		if (userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}

	@SuppressWarnings("unchecked")
	public boolean VerifyPassword(String userName, String password) {
		// TODO Auto-generated method stub
		String queryString = "from Admin where username=? and password=?";
		List<Admin> userList = hibernateTemplate.find(queryString, userName,
				password);
		if (userList.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean resetPassword(String userName, String passWord) {
		// TODO Auto-generated method stub
		try {
			String hql = "update Admin set password=? where username=?";
			int num = hibernateTemplate.bulkUpdate(hql, passWord, userName);
			return num > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Admin> listAdmin = hibernateTemplate.find("from Admin");
		return listAdmin;
	}

	public boolean add(Admin admin) {
		// TODO Auto-generated method stub
		try {
			List<Admin> listAdmin = hibernateTemplate.find(
					"from Admin where username=?", admin.getUsername());
			if (listAdmin.isEmpty()) {
				hibernateTemplate.save(admin);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean change(Admin admin) {
		// TODO Auto-generated method stub
		try {
			String hql = "update Admin set truename=? where id=? ";
			int num = hibernateTemplate.bulkUpdate(hql, admin.getTruename(), admin.getId());
			return num > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			String hql = "delete Admin where id=?";
			int num = hibernateTemplate.bulkUpdate(hql, id);
			return num > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public Admin getById(int id) {
		// TODO Auto-generated method stub
		List<Admin> listAdmin = hibernateTemplate.find("from Admin where id=?",
				id);
		if (listAdmin.isEmpty())
			return null;
		return listAdmin.get(0);
	}

}
