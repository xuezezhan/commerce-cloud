package com.zdds.facades.service.account;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;

import java.util.Map;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 12:41 2020/1/18
 * @since JDK 11
 */
public interface AccountService {
    /**
     * 分页查询账号
     * @param params
     * @param pageableData
     * @return
     */
    SearchPageData searchAccount(Map<String, Object> params, PageableData pageableData);
}
