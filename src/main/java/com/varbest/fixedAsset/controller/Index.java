package com.varbest.fixedAsset.controller;

import java.util.List;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varbest.fixedAsset.dao.IFixedAssetItemDao;
import com.varbest.fixedAsset.dao.IUserDao;
import com.varbest.fixedAsset.dao.UserDao;
import com.varbest.fixedAsset.model.FixedAssetItem;
import com.varbest.fixedAsset.model.User;

@Controller
// @ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class Index {

	private static final Log log = LogFactory.getLog(Index.class);
	@Autowired
	private IUserDao userDao;

	@RequestMapping("/")
	public String index(String param, HttpServletRequest req, HttpServletResponse resp, ModelMap model) {
//		FixedAssetItem fixedAssetItem = fixedAssetItemDao.findOneByCode("GL123");
		User user=userDao.findOneByUserName("zdp");
		log.info(user); 
		return "index";
	}

}
