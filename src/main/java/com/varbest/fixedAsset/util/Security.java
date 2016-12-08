package com.varbest.fixedAsset.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	public static String encrypt(String strSrc, String encName) throws NoSuchAlgorithmException {
		MessageDigest md = null;
		byte[] tempBytes = null;
		try {
			tempBytes = strSrc.getBytes("utf-8");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		if (strSrc == null || strSrc.equals("")) {
			strSrc = "MD5";
		}
		md = MessageDigest.getInstance(encName);
		md.update(tempBytes);
		return byte2hex(md.digest());
	}

	// 字节转换为十六进制
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0xFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs;
	}
}
