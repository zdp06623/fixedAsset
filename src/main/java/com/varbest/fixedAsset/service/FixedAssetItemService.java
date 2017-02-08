package com.varbest.fixedAsset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varbest.fixedAsset.dao.IFixedAssetItemDao;
import com.varbest.fixedAsset.model.FixedAssetItem;

/** 
* @author zhangdp
* @version 创建时间：2017年2月8日 下午3:00:19 
* 类说明 
*/
@Service
public class FixedAssetItemService implements IFixedAssetItemService {

	@Autowired
	private IFixedAssetItemDao<FixedAssetItem> fixedAssetItemDao;
	
	public List<FixedAssetItem> getList() {
		return fixedAssetItemDao.getList();
	}

}
