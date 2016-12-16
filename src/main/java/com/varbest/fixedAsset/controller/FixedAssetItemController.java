package com.varbest.fixedAsset.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.varbest.fixedAsset.dao.FixedAssetItemDao;
import com.varbest.fixedAsset.model.FixedAssetItem;
import com.varbest.fixedAsset.model.NtspHeader;
import com.varbest.fixedAsset.model.api.FixedAssetItemAddRequest;
import com.varbest.fixedAsset.model.api.FixedAssetItemAddResponse;

/** 
* @author zhangdp
* @version 创建时间：2016年12月13日 下午1:41:14 
* 类说明 
*/
@Controller
public class FixedAssetItemController {
	
	private static final Log log=LogFactory.getLog(FixedAssetItemController.class);
	private static Gson gson=new Gson();
	
	@Autowired
	private FixedAssetItemDao fixedAssetItemDao;
	
	@RequestMapping(value="/fixedAssetItem/addFixedAssetItem.do",method={RequestMethod.POST})
	public @ResponseBody FixedAssetItemAddResponse add(@RequestBody FixedAssetItemAddRequest request){
		FixedAssetItem fixedAssetItem=request.getFixedAssetItem();
		log.info(gson.toJson(fixedAssetItem));
		
		fixedAssetItemDao.insert(fixedAssetItem);
		FixedAssetItemAddResponse response=new FixedAssetItemAddResponse();
		NtspHeader ntspHeader=new NtspHeader();
		ntspHeader.setErrCode(1);
		ntspHeader.setErrMsg("Entity not found!");
		response.setNtspHeader(ntspHeader);
		return response;
	}
	
	
}
