package com.varbest.fixedAsset.model.api;

import com.varbest.fixedAsset.model.FixedAssetItem;
import com.varbest.fixedAsset.model.ResponseBase;
import java.util.*;

/** 
* @author zhangdp
* @version 创建时间：2017年2月7日 上午11:17:22 
* 类说明 
*/
public class FixedAssetItemGetListResponse extends ResponseBase {
	private List<FixedAssetItem> fixedAssetItems;

	public List<FixedAssetItem> getFixedAssetItems() {
		return fixedAssetItems;
	}

	public void setFixedAssetItems(List<FixedAssetItem> fixedAssetItems) {
		this.fixedAssetItems = fixedAssetItems;
	}

}
