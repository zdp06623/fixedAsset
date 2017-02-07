package com.varbest.fixedAsset.controller;

import java.util.List;
import org.apache.log4j.Logger;
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
import com.varbest.fixedAsset.model.api.FixedAssetItemDeleteRequest;
import com.varbest.fixedAsset.model.api.FixedAssetItemDeleteResponse;
import com.varbest.fixedAsset.model.api.FixedAssetItemGetListRequest;
import com.varbest.fixedAsset.model.api.FixedAssetItemGetListResponse;

/**
 * @author zhangdp
 * @version 创建时间：2016年12月13日 下午1:41:14 类说明
 */
@Controller
public class FixedAssetItemController {

	private static Logger log = Logger.getLogger(FixedAssetItemController.class);
	private static Gson gson = new Gson();

	@Autowired
	private FixedAssetItemDao fixedAssetItemDao;

	/**
	 * 添加资产
	 * @param request 单个资产详情
	 * @return 操作状态
	 */
	@RequestMapping(value = "/fixedAssetItem/add.do", method = { RequestMethod.POST })
	public @ResponseBody FixedAssetItemAddResponse add(@RequestBody FixedAssetItemAddRequest request) {
		FixedAssetItemAddResponse response = new FixedAssetItemAddResponse();
		NtspHeader ntspHeader = new NtspHeader();
		try {
			FixedAssetItem fixedAssetItem = request.getFixedAssetItem();
			fixedAssetItemDao.insert(fixedAssetItem);	
		} catch (Exception e) {
			log.error("添加信息异常：参数request："+e.getMessage());
			ntspHeader.setErrCode(-1);
			ntspHeader.setErrMsg("Entity not found!");					
		}
		response.setNtspHeader(ntspHeader);	
		return response;
	}

	/**
	 * 获取资产列表
	 * @param request
	 * @return 资产列表
	 */
	@RequestMapping(value = "/fixedAssetItem/getList.do", method = { RequestMethod.POST })
	public @ResponseBody FixedAssetItemGetListResponse getList(@RequestBody FixedAssetItemGetListRequest request) {
		FixedAssetItemGetListResponse response = new FixedAssetItemGetListResponse();
		NtspHeader ntspHeader = new NtspHeader();
		try {
			List<FixedAssetItem> fixedAssetItems = fixedAssetItemDao.findList(0, 0);
			response.setFixedAssetItems(fixedAssetItems);
		} catch (Exception e) {
			log.error("获取列表信息异常：参数request："+gson.toJson(request).toString()+e.getMessage());			
			ntspHeader.setErrCode(-1);
			ntspHeader.setErrMsg("error!");		
		}		
		response.setNtspHeader(ntspHeader);	
		return response;
	}
	
	/**
	 * 删除资产信息
	 * @param request 资产Id
	 * @return 操作状态
	 */
	@RequestMapping(value="/fixedAssetItem/delete.do",method={RequestMethod.POST})
	public @ResponseBody FixedAssetItemDeleteResponse delete(@RequestBody FixedAssetItemDeleteRequest request){
		FixedAssetItemDeleteResponse response=new FixedAssetItemDeleteResponse();	
		NtspHeader ntspHeader = new NtspHeader();
		try {
			boolean result=fixedAssetItemDao.remove(request.getId());
			if (!result) {				
				ntspHeader.setErrCode(-1);
				ntspHeader.setErrMsg("Entity not delete!");	
			}
		} catch (Exception e) {
			log.error("删除信息异常：参数request："+gson.toJson(request).toString()+e.getMessage());			
			ntspHeader.setErrCode(-1);
			ntspHeader.setErrMsg("error!");			
		}
		response.setNtspHeader(ntspHeader);		
		return response;
	}
	

}
