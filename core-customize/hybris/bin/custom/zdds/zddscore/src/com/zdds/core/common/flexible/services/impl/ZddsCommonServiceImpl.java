package com.zdds.core.common.flexible.services.impl;



import com.zdds.core.common.flexible.daos.ZddsCommonDao;
import com.zdds.core.common.flexible.services.ZddsCommonService;
import de.hybris.platform.core.model.ItemModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/7/28
 *@since  JDK 1.8
 */
@Service(value = "zddsCommonService")
public class ZddsCommonServiceImpl implements ZddsCommonService {

   @Resource(name = "zddsCommonDao")
   private ZddsCommonDao zddsCommonDao;

   @Override
   public <T extends ItemModel>  T findByPK(long pk, Class<T> tClass) {
       return zddsCommonDao.findByPK(pk,tClass);
   }

   @Override
   public <T extends ItemModel>  T findByCode(String code, Class<T> tClass) {
       return zddsCommonDao.findByCode(code,tClass);
   }

   @Override
   public <T extends ItemModel>  List<T> findByParams(Map<String, Object> params, Class<T> tClass) {
       return zddsCommonDao.findByParams(params,tClass);
   }

   @Override
   public <T extends ItemModel>  boolean save(T t) {
       return zddsCommonDao.save(t);
   }

   @Override
   public <T extends ItemModel> List<T> findBySqlAndParams(String sql, Map<String, Object> params, Class<T> tClass) {
       return zddsCommonDao.findBySqlAndParams(sql,params,tClass);
   }
}
