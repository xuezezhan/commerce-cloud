package com.zdds.facades.facades.category.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zdds.facades.facades.category.OPCategoryFacade;
import com.zdds.facades.service.category.OPCategoryService;
import de.hybris.platform.category.model.CategoryModel;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 14:13 2020/3/4
 * @since JDK 11
 */
@Service(value = "opCategoryFacade")
public class OPCategoryFacadeImpl implements OPCategoryFacade {

    @Resource(name = "opCategoryService")
    private OPCategoryService opCategoryService;
    @Override
    public JSONArray getCategoryLevel(String level) {
        List<CategoryModel> categoryModelList = opCategoryService.getCategoryLevel(level);
        if(CollectionUtils.isNotEmpty(categoryModelList)){
            JSONArray jsonArray = new JSONArray();
            categoryModelList.stream().forEach(category->{
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",category.getCode());
                jsonObject.put("name",category.getName(Locale.CHINESE));
                jsonArray.add(jsonObject);
            });
            return jsonArray;
        }
        return new JSONArray();
    }
}
