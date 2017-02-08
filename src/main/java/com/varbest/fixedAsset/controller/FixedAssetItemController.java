package com.varbest.fixedAsset.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.varbest.fixedAsset.model.api.*;
import com.varbest.fixedAsset.service.FixedAssetItemService;

/**
 * @author zhangdp
 * @version 创建时间：2016年12月13日 下午1:41:14 类说明
 */
@Controller
public class FixedAssetItemController {

	private static Logger log = Logger.getLogger(FixedAssetItemController.class);
	private static Gson gson = new Gson();
	@Autowired
	private FixedAssetItemService fixedAssetItemService;

	@RequestMapping(value = "/fixedAssetItem/getlist.do", method = { RequestMethod.POST })
	public @ResponseBody FixedAssetItemGetListResponse getList(@RequestBody FixedAssetItemGetListRequest request) {
		FixedAssetItemGetListResponse response = new FixedAssetItemGetListResponse();
		response.setFixedAssetItems(fixedAssetItemService.getList());
		return response;
	}

}
