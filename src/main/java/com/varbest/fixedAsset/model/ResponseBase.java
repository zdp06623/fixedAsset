package com.varbest.fixedAsset.model;

/**
 * @author zhangdp
 * @version 创建时间：2016年12月16日 下午1:40:31 类说明
 */
public class ResponseBase {
	private NtspHeader ntspHeader;

	public NtspHeader getNtspHeader() {		
		return ntspHeader;
	}

	public void setNtspHeader(NtspHeader ntspHeader) {
		this.ntspHeader = ntspHeader;
	}
}
