package com.zdds.core.common.flexible.daos.impl;



import com.zdds.core.common.flexible.daos.ZddsCommonDao;
import com.zdds.core.util.LogUtil;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.servicelayer.data.SearchPageData;
import de.hybris.platform.core.servicelayer.data.SortData;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.paginated.PaginatedFlexibleSearchParameter;
import de.hybris.platform.servicelayer.search.paginated.PaginatedFlexibleSearchService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/7/28
 *@since  JDK 1.8
 */
@Repository(value = "zddsCommonDao")
public class ZddsCommonDaoImpl implements ZddsCommonDao {

   @Autowired
   private ModelService modelService;

   @Autowired
   private FlexibleSearchService flexibleSearchService;

    @Autowired
    private PaginatedFlexibleSearchService paginatedFlexibleSearchService;


   @Override
   public <T extends ItemModel> T findByPK(long pk, Class<T> tClass) {
       return tClass.cast(modelService.get(PK.fromLong(pk)));
   }

   @Override
   public <T extends ItemModel> T findByCode(String code, Class<T> tClass) {

       String sql = "SELECT {i.pk} FROM {" + tClass.getSimpleName().replaceAll("Model","") + " AS i } WHERE {i.code}=?code ";
       HashMap<String, Object> params = new HashMap<String, Object>() {{
           put("code", code);
       }};
       List<Object> result = flexibleSearchService.search(sql, params).getResult();
       if (CollectionUtils.isNotEmpty(result)) {
           return tClass.cast(result.get(0));
       }
       return null;
   }

   @Override
   public <T extends ItemModel> List<T> findByParams(Map<String, Object> params, Class<T> tClass) {
       StringBuilder sql = new StringBuilder("SELECT {i.pk} FROM {" + tClass.getSimpleName().replaceAll("Model","") + " AS i } WHERE  1=1 ");

       params.keySet().forEach(key -> sql.append(" and ").append("{i.").append(key).append("}").append("=?").append(key));


       List<T> result = flexibleSearchService.<T>search(sql.toString(), params).getResult();
       LogUtil.info("SQL======="+sql.toString());
       StringBuilder p=new StringBuilder();
       p.append("\nParam\n:");
       for (String s : params.keySet()) {
          p.append("\tKey:").append(s).append("            ").append("Value:").append(params.get(s)).append("\n");
       }

       if (CollectionUtils.isNotEmpty(result)) {
           return result;
       }
       return Collections.emptyList();
   }

   @Override
   public <T extends ItemModel> boolean save(T t) {

       try {
           modelService.save(t);
           return true;
       } catch (ModelSavingException e) {
           LogUtil.error(e.getMessage(), e);
           return false;
       }
   }

   @Override
   public <T extends ItemModel> List<T> findBySqlAndParams(String sql, Map<String, Object> params, Class<T> tClass) {
       List<T> result = flexibleSearchService.<T>search(sql, params).getResult();
       if (CollectionUtils.isNotEmpty(result)) {
           return result;
       }
       return Collections.emptyList();
   }

    @Override
    public <T extends ItemModel> SearchPageData<T> findBySqlAndParamsPageableData(String sql,
                                                                                  Map<String, ?> params, SearchPageData<?> searchPageData, String tableAlia) {
        final PaginatedFlexibleSearchParameter paginatedflexiblesearchparameter = new PaginatedFlexibleSearchParameter();
        paginatedflexiblesearchparameter.setFlexibleSearchQuery(new FlexibleSearchQuery(sql, params));
        paginatedflexiblesearchparameter.setSearchPageData(searchPageData);

        final Map<String, String> sortCodeToQueryAlias = new HashMap<String, String>();
        if (CollectionUtils.isNotEmpty(searchPageData.getSorts())) {
            for (SortData sortData : searchPageData.getSorts()) {
                if (StringUtils.isNotBlank(sortData.getCode())) {
                    sortCodeToQueryAlias.put(sortData.getCode().toLowerCase(), tableAlia);
                }
            }
        }
        paginatedflexiblesearchparameter.setSortCodeToQueryAlias(sortCodeToQueryAlias);
        return paginatedFlexibleSearchService.<T> search(paginatedflexiblesearchparameter);
    }
}
