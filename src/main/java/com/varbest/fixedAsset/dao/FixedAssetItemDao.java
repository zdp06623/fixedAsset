package com.varbest.fixedAsset.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.varbest.fixedAsset.model.FixedAssetItem;

/** 
* @author zhangdp
* @version 创建时间：2016年12月7日 下午3:05:22 
* 类说明 
*/
@Repository
public class FixedAssetItemDao extends BaseDao<FixedAssetItem> implements IFixedAssetItemDao {
	public FixedAssetItem findOneByCode(String code) {
		Query query = new Query(Criteria.where("code").is(code));
		return getMongoTemplate().findOne(query, FixedAssetItem.class);
	}

	
	public List<FixedAssetItem> findByCategoryId(String categoryId) {
		Query query=new Query(Criteria.where("categoryId").is(categoryId));
		return getMongoTemplate().find(query, FixedAssetItem.class);
	}


	public boolean remove(String id) {
		boolean result=false;
		Query query=new Query(Criteria.where("_id").is(id));
		WriteResult writeResult= getMongoTemplate().remove(query, FixedAssetItem.class);
		if (writeResult!=null && writeResult.getN()>0) {
			result=true;
		}
		return result;
	}
}
