package com.YueDao.web.util;

import com.YueDao.web.entity.Admin;
import com.YueDao.web.entity.Goods;


public class VerifyEmptyUtils {

	public static boolean VerifyEmpty(Admin admin) {
		// TODO Auto-generated method stub
		if(admin.getUsername()==null||admin.getUsername().isEmpty()||
				admin.getPassword()==null||admin.getPassword().isEmpty())
			return true;
		return false;
	}

	public static boolean VerifyEmpty(Goods goods) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	
	
}
