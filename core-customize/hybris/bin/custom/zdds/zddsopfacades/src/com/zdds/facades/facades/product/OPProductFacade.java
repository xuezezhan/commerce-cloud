package com.zdds.facades.facades.product;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;

import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 23:07 2020/3/5
 * @since JDK 11
 */
public interface OPProductFacade {

    /**
     * 分页查询商品列表
     * @param params
     * @param pageableData
     * @return
     */
    SearchPageData searchProduct(Map<String, Object> params, PageableData pageableData);
}
