package com.varbest.fixedAsset.model;


/** 
* @author zhangdp
* @version 创建时间：2016年12月7日 下午4:42:34 
* 类说明 
*/
public class User {
	

	private String id;
	
	private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getid() {
		return id;
	}

	public void set_id(String id) {
		this.id = id;
	}
}
