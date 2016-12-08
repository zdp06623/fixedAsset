package com.varbest.fixedAsset.dao;

import com.varbest.fixedAsset.model.FixedAssetItem;

/** 
* @author zhangdp
* @version 创建时间：2016年12月7日 下午3:04:20 
* 类说明 
*/
public interface IFixedAssetItemDao extends IBaseDao<FixedAssetItem> {
	public FixedAssetItem findOneByCode(String code);
}
