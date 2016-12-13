package com.varbest.fixedAsset.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.varbest.fixedAsset.dao.IFixedAssetItemDao;
import com.varbest.fixedAsset.model.FixedAssetItem;

@Controller
// @ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class Index {

	private static final Log log = LogFactory.getLog(Index.class);
	@Autowired
	private IFixedAssetItemDao fixedAssetItemDao;

	@RequestMapping("/")
	public String index(String param, HttpServletRequest req, HttpServletResponse resp, ModelMap model) {
		FixedAssetItem fixedAssetItem = fixedAssetItemDao.findOneByCode("GL123");
		// User user=userDao.findOneByUserName("zdp");
		Gson gson = new Gson();
		log.info(gson.toJson(fixedAssetItem));
		String objectId = ObjectId.get().toString();
		log.info("objectId:" + objectId);

		log.info(gson.toJson(fixedAssetItemDao.findByCategoryId("581c3169180c0802fbe8ad57")));
		return "index";
	}
	

}
