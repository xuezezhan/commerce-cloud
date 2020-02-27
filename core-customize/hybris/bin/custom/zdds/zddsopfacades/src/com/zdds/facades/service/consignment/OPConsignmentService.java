package com.zdds.facades.service.consignment;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;

import java.util.Map;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 16:44 2020/2/25
 * @since JDK 11
 */
public interface OPConsignmentService {

    /**
     * 分页查询发货单
     * @param params
     * @param pageableData
     * @return
     */
    SearchPageData searchConsignment(Map<String, Object> params, PageableData pageableData);
}