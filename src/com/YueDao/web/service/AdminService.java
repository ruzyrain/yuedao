package com.YueDao.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.YueDao.web.dao.AdminDAO;
import com.YueDao.web.entity.Admin;
import com.YueDao.web.util.Tools;

@Repository("adminService")
@Transactional
public class AdminService {

	@Autowired
	@Qualifier("adminDAO")
	private AdminDAO adminDAO;

	
	
	
	// 判断账号密码是否正确
	public Admin VerifyPassword(Admin admin) {
		// TODO Auto-generated method stub
		admin.setPassword(Tools.md5(admin.getPassword()));// md5
		return adminDAO.VerifyPassword(admin);

	}

	public boolean verifyPassword(String userName, String passWord) {
		// TODO Auto-generated method stub
		return adminDAO.VerifyPassword(userName, Tools.md5(passWord));
	}

	// 修改用户密码
	public boolean reSetPassword(String userName, String passWord) {
		// TODO Auto-generated method stub
		return adminDAO.resetPassword(userName, Tools.md5(passWord));
	}

	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminDAO.getAll();
	}

	public boolean AddAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.add(admin);
	}

	public boolean ChangeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDAO.change(admin);
	}

	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminDAO.getById(id);
	}

	public boolean DeleteAdmin(int id) {
		// TODO Auto-generated method stub
		return adminDAO.delete(id);
	}

}
