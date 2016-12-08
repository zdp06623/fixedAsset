package com.varbest.fixedAsset.dao;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.varbest.fixedAsset.model.FixedAssetItem;

/** 
* @author zhangdp
* @version 创建时间：2016年12月7日 下午3:05:22 
* 类说明 
*/
@Repository
public class FixedAssetItemDao extends BaseDao<FixedAssetItem> implements IFixedAssetItemDao {
	public FixedAssetItem findOneByCode(String code) {
		Query query = new Query(Criteria.where("Code").is(code));
		return getMongoTemplate().findOne(query, FixedAssetItem.class);
	}
}
