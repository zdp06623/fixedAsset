package com.varbest.fixedAsset.dao;

import java.util.List;

import com.varbest.fixedAsset.model.FixedAssetItem;

/** 
* @author zhangdp
* @version 创建时间：2016年12月7日 下午3:04:20 
* 类说明 
*/
public interface IFixedAssetItemDao extends IBaseDao<FixedAssetItem> {
	/**
	 * 通过code获取单个资产条目
	 * @param code 编码
	 * @return
	 */
	public FixedAssetItem findOneByCode(String code);
	
	/**
	 * 通过分类Id获取指定资产条目
	 * @param categoryId 分类Id
	 * @return
	 */
	public List<FixedAssetItem> findByCategoryId(String categoryId);
	
}
