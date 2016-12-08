package com.varbest.fixedAsset.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.varbest.fixedAsset.controller.Index;
import com.varbest.fixedAsset.util.MongoFactory;

/**
 * @author zhangdp
 * @version 创建时间：2016年12月7日 下午3:01:32 类说明
 */
public class BaseDao<T> implements IBaseDao<T> {
	private static final Log log = LogFactory.getLog(BaseDao.class);
	private Class<T> clazz;

	public BaseDao() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private MongoFactory mongoFactory;

	public List<T> find(Query query) {
		return mongoTemplate.find(query, clazz);
	}

	public List<T> findList(int skip, int limit) {
		Query query = new Query();
		query.with(new Sort(new Order(Direction.ASC, "_id")));
		query.skip(skip).limit(limit);
		return find(query);
	}

	public T findOne(String id) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(id));
		return mongoTemplate.findOne(query, clazz);
	}

	public void insert(T entity) {
		mongoTemplate.insert(entity);
	}

	public void update(T entity) throws Exception {
		Map<String, Object> map = mongoFactory.converObjectToParams(entity);

		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(map.get("id")));
		Update update = (Update) map.get("update");

		this.update(query, update);
	}

	public void update(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, clazz);
	}

	public Long findCount(Query query) {
		return mongoTemplate.count(query, clazz);
	}

	public void remove(T entity) {
		mongoTemplate.remove(entity);
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
}
