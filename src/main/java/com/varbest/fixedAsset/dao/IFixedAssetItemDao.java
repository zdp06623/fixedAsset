package com.varbest.fixedAsset.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.varbest.fixedAsset.model.FixedAssetItem;

/** 
* @author zhangdp
* @version 创建时间：2016年12月7日 下午3:04:20 
* 类说明 
*/
@Repository
public interface IFixedAssetItemDao<FixedAssetItem> {
	
	List<FixedAssetItem> getList();
}
