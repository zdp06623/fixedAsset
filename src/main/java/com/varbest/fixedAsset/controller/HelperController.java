package com.varbest.fixedAsset.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varbest.fixedAsset.util.Security;

@Controller
public class HelperController {
	private static Log log = LogFactory.getLog(HelperController.class);

	@RequestMapping("getCode.do")
	public String getCode(String param, HttpServletRequest request, HttpServletResponse respone, ModelMap model) {
		String key = "1f2de79176ba9b660a963b30707b51f1";
		String sig = null;
		try {
			sig = Security.encrypt(param + "@" + key, "MD5").toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			log.error("getCode error:{}", e);
		}
		model.put("sig", sig);
		return "getCode";
	}
}
