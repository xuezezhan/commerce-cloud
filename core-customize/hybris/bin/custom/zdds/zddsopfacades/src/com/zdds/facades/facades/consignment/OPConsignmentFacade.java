package com.zdds.facades.facades.consignment;


import com.zddsop.data.OPConsignmentData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;

import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 16:34 2020/2/25
 * @since JDK 11
 */
public interface OPConsignmentFacade {

    /**
     * 分页查询发货单
     * @param params
     * @param pageableData
     * @return
     */
    SearchPageData searchConsignment(Map<String, Object> params, PageableData pageableData);

    /**
     * 发货单详情
     * @param pk
     * @return
     */
    OPConsignmentData searchConsignmentInfoForPk(String pk);

}