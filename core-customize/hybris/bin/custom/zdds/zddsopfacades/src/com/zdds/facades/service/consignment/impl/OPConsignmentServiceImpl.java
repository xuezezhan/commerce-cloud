package com.zdds.facades.service.consignment.impl;


import com.zdds.core.util.LogUtil;
import com.zdds.facades.service.consignment.OPConsignmentService;
import de.hybris.platform.commerceservices.search.flexiblesearch.PagedFlexibleSearchService;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 16:44 2020/2/25
 * @since JDK 11
 */
@Service(value = "opConsignmentService")
public class OPConsignmentServiceImpl implements OPConsignmentService {

    @Autowired
    private PagedFlexibleSearchService pagedFlexibleSearchService;

    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Autowired
    private UserService userService;

    /**
     * 分页查询发货单
     * @param params
     * @param pageableData
     * @return
     */
    @Override
    public SearchPageData searchConsignment(final Map<String, Object> params, final PageableData pageableData) {
        final StringBuilder sql = new StringBuilder("select {cg.pk} from { Consignment as cg ");
        final Map<String, Object> queryParams = new HashMap<>();
        final StringBuilder conditionSql = new StringBuilder("} where 1=1 and {cg.supplier}= '"+userService.getCurrentUser().getPk().getLongValueAsString()+"' ");


        sql.append(" join Order as o on {o.pk}={cg.order} join Customer as u on {u.pk}={o.user} ");

        if(params.get("name")!=null){
            conditionSql.append(" and {u.name} like ?displayName ");
            queryParams.put("displayName", "%"+params.get("name")+"%");
        }
        if(params.get("orderCode")!=null){
            conditionSql.append(" and {o.code} like ?orderCode ");
            queryParams.put("orderCode", "%"+params.get("orderCode")+"%");
        }
        if(params.get("status")!=null){
            sql.append(" join ConsignmentStatus as cs on {cs.pk}={cg.status} ");
            conditionSql.append(" and {cs.code} = ?status ");
            queryParams.put("status", params.get("status"));
        }
        if(params.get("realName")!=null){
            conditionSql.append(" and {u.realName} like ?realName ");
            queryParams.put("realName", "%"+params.get("realName")+"%");
        }
        if(params.get("startTime")!=null){
            conditionSql.append(" and {o.creationtime} between ?startTime and ?endTime ");
            queryParams.put("startTime", params.get("startTime")+" 00:00:00");
            queryParams.put("endTime", params.get("endTime")+" 23:59:59");
        }

        sql.append(conditionSql).append(" order by {cg.creationtime} desc");

        try{
            return pagedFlexibleSearchService.search(sql.toString(), queryParams, pageableData);
        }catch (Exception e){
            LogUtil.error(e.getMessage(),e);
            return null;
        }
    }
}