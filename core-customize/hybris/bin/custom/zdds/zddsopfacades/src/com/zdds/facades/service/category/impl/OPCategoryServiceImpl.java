package com.zdds.facades.service.category.impl;

import com.zdds.core.util.LogUtil;
import com.zdds.facades.service.category.OPCategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.search.restriction.SearchRestrictionService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 14:51 2020/3/4
 * @since JDK 11
 */
@Service(value = "opCategoryService")
public class OPCategoryServiceImpl implements OPCategoryService {

    @Resource
    private FlexibleSearchService flexibleSearchService;
    @Resource(name = "searchRestrictionService")
    SearchRestrictionService searchRestrictionService;
    @Override
    public List<CategoryModel> getCategoryLevel(String level) {
        List<CategoryModel> categoryModels = Collections.emptyList();
        StringBuilder queryStr=new StringBuilder("select {c.pk} from {Category as c join level as l on {l.pk}={c.level}}");

        queryStr.append(" where 1=1 and {l.code} =?level");
        final Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("level", level);

        try {
            searchRestrictionService.disableSearchRestrictions();
            final SearchResult<CategoryModel> searchResult = flexibleSearchService.search(queryStr.toString(),queryParams);
            categoryModels=searchResult.getResult();
        }catch (Exception e){
            LogUtil.error("searchCategoryLevel happen error" +e);
        }finally {
            searchRestrictionService.enableSearchRestrictions();
        }
        return categoryModels;
    }
}
