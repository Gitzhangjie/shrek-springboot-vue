package com.shrek.example.dao.mysql;

import com.alibaba.fastjson.JSONObject;
import com.shrek.example.util.CommonUtil;
import java.util.List;
/**
 * ${comments}
 * 
 * @author Wushu
 * @email 156810150@qq.com
 * @date 2019-05-07 14:49:02
 */

public interface ShrekCategoryDao {
    int update(JSONObject jsonObject);

    int insert(JSONObject jsonObject);

    List<JSONObject> listByPage(JSONObject jsonObject);

    int delete(Long id);

    int count(JSONObject jsonObject);

    List<JSONObject> selectList(JSONObject jsonObject);
}
