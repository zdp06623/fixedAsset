package com.varbest.fixedAsset.dao;

import com.varbest.fixedAsset.model.User;

/** 
* @author zhangdp
* @version 创建时间：2016年12月7日 下午4:47:09 
* 类说明 
*/

public interface IUserDao extends IBaseDao<User> {
	public User findOneByUserName(String userName);
}
