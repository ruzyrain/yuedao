package com.YueDao.web.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Tools {
	/**
	 * 浣跨敤md5鐨勭畻娉曡繘琛屽姞瀵�
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("MD5加密出错");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16杩涘埗鏁板瓧
		// 濡傛灉鐢熸垚鏁板瓧鏈弧32浣嶏紝闇�鍓嶉潰琛�
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}

	static private String RandomSeed = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_-+=";
	public static int RandomStringLen = 30;

	public static String RandomName()// 随机文件名字
	{
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		for (int i = 0; i < RandomStringLen; i++) {
			sb.append(RandomSeed.charAt(rnd.nextInt(RandomSeed.length())));
		}
		return sb.toString();
	}

}
