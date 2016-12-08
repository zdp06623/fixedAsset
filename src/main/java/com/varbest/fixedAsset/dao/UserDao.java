package com.varbest.fixedAsset.dao;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.varbest.fixedAsset.model.User;

/**
 * @author zhangdp
 * @version 创建时间：2016年12月7日 下午4:49:00 类说明
 */
@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public User findOneByUserName(String userName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		return getMongoTemplate().findOne(query, User.class);
	}

}
