package com.varbest.fixedAsset.model.api;

import com.varbest.fixedAsset.model.RequestBase;

/** 
* @author zhangdp
* @version 创建时间：2017年2月7日 上午11:16:55 
* 类说明 
*/
public class FixedAssetItemDeleteRequest extends RequestBase {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
