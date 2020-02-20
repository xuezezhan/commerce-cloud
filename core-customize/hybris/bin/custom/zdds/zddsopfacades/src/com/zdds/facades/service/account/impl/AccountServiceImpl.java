package com.zdds.facades.service.account.impl;

import com.zdds.facades.service.account.AccountService;
import de.hybris.platform.commerceservices.search.flexiblesearch.PagedFlexibleSearchService;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 12:41 2020/1/18
 * @since JDK 11
 */
public class AccountServiceImpl implements AccountService {

    private static final Logger LOG = Logger.getLogger(AccountServiceImpl.class);

    @Autowired
    private PagedFlexibleSearchService pagedFlexibleSearchService;

    @Resource
    private FlexibleSearchService flexibleSearchService;
    /**
     * 分页查询账号
     * @param params
     * @param pageableData
     * @return
     */
    @Override
    public SearchPageData searchAccount(Map<String, Object> params, PageableData pageableData) {
        StringBuilder queryStr = new StringBuilder("select {e.pk} from {employee as e} where 1=1");

        if(params.containsKey("uid")){
            params.put("uid","%"+params.get("uid")+"%");
            queryStr.append(" AND {e.uid} like ?uid");
        }
        if(params.containsKey("name")){
            params.put("name","%"+params.get("name")+"%");
            queryStr.append(" AND {e.name} like ?name");
        }
        if(params.containsKey("status")){
            if(!"".equals(params.get("status").toString())&&null!=params.get("status").toString()){
                params.put("loginDisabled",params.get("status"));
                queryStr.append(" AND {e.loginDisabled}=?loginDisabled");
            }
        }
        queryStr.append(" order by {e.modifiedtime} desc");
        LOG.info("-----queryStr is:"+queryStr.toString()+ "\nparam :" + params.toString());
        SearchPageData searchPageData=null;
        try{
            searchPageData = pagedFlexibleSearchService.search(queryStr.toString(),params,pageableData);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(),e);
        }
        return searchPageData;
    }
}
