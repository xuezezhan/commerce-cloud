package com.zdds.facades.service.category;

import com.alibaba.fastjson.JSONArray;
import de.hybris.platform.category.model.CategoryModel;

import java.util.List;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 14:50 2020/3/4
 * @since JDK 11
 */
public interface OPCategoryService {
    /**
     * 获取类别
     * @param level
     * @return
     */
    public List<CategoryModel> getCategoryLevel(final String level);
}
