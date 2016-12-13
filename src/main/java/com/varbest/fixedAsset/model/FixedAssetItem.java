package com.varbest.fixedAsset.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FixedAssetItem")
public class FixedAssetItem {

	@Id
	private String id;
	
	private String code;
	
	private String categoryId;
	
	private int codeNum;
	
	private String title;
	
	private String imageUrl;
	
	private String qRUrl;
	
	private ExtendObject[] extend;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getCodeNum() {
		return codeNum;
	}

	public void setCodeNum(int codeNum) {
		this.codeNum = codeNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getqRUrl() {
		return qRUrl;
	}

	public void setqRUrl(String qRUrl) {
		this.qRUrl = qRUrl;
	}

	public ExtendObject[] getExtend() {
		return extend;
	}

	public void setExtend(ExtendObject[] extend) {
		this.extend = extend;
	}	

}
