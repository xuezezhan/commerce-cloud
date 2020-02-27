package com.zdds.core.common.flexible.services;

import de.hybris.platform.core.model.ItemModel;

import java.util.List;
import java.util.Map;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/7/28
 *@since  JDK 1.8
 */
public interface ZddsCommonService {

   <T extends ItemModel> T findByPK(long pk, Class<T> tClass);
   <T extends ItemModel> T findByCode(String code, Class<T> tClass);
   <T extends ItemModel>  List<T> findByParams(Map<String, Object> params, Class<T> tClass);
   <T extends ItemModel> boolean save(T t);
   <T extends ItemModel>  List<T> findBySqlAndParams(String sql, Map<String, Object> params, Class<T> tClass);
}
