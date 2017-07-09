package com.zbss.util;


/**
 * @author zbss
 * @date 2016年5月19日 下午9:08:01
 * @desc
 */
public class PasswordUtils {

	public static final String PWD_ENC_SEED = "@x1#2v$m9Rf1?%[4^5&6]*7";
	
	public static String encrypt(String usr, String pwd){
		return Base64Utils.encode(MD5Utils.MD5(usr.trim()+PWD_ENC_SEED+pwd.trim()));
	}
	
	public static void main(String[] args) {
		System.out.println(PasswordUtils.encrypt("admin", "123"));
	}
}
