package com.varbest.fixedAsset.model.api;

import com.varbest.fixedAsset.model.FixedAssetItem;
import com.varbest.fixedAsset.model.RequestBase;

/** 
* @author zhangdp
* @version 创建时间：2016年12月16日 下午1:48:49 
* 类说明 
*/
public class FixedAssetItemAddRequest extends RequestBase {
	private FixedAssetItem fixedAssetItem;

	public FixedAssetItem getFixedAssetItem() {
		return fixedAssetItem;
	}

	public void setFixedAssetItem(FixedAssetItem fixedAssetItem) {
		this.fixedAssetItem = fixedAssetItem;
	}
}
