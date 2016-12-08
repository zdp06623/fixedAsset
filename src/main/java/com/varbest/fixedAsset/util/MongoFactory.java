package com.varbest.fixedAsset.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/** 
* @author zhangdp
* @version 创建时间：2016年12月7日 下午2:52:15 
* 类说明 
*/
@Component
public class MongoFactory {
	@Autowired
    private ObjectParams objectParams;

    /**
     * 把实体对象转为MongoDB更新需要的值
     * @Title: converObjectToParams 
     * @Description: TODO
     * @param @param obj
     * @param @return
     * @param @throws Exception   
     * @return Map<String,Object>   
     * @throws
     */
    public Map<String, Object> converObjectToParams(Object obj) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        Update update = new Update();
        Map<String, String> params = objectParams.createParams(obj);
        String id = params.get("id");
        Set<Map.Entry<String, String>> set = params.entrySet();
        for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            if(!entry.getKey().equals("id")){
                update.set(entry.getKey(), entry.getValue());
            }
        }

        map.put("id", id);
        map.put("update", update);

        return map;
    }
}
