package com.zdds.facades.facades.category;

import com.alibaba.fastjson.JSONArray;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 14:13 2020/3/4
 * @since JDK 11
 */
public interface OPCategoryFacade {
    /**
     * 获取类别
     * @param level
     * @return
     */
    public JSONArray getCategoryLevel(final String level);
}
