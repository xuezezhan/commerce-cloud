package com.zdds.facades.service.menugroup.impl;


import com.zdds.facades.model.MenuGroupModel;
import com.zdds.facades.model.OperationMenuModel;
import com.zdds.facades.service.menugroup.MenuGroupService;
import de.hybris.platform.commerceservices.search.flexiblesearch.PagedFlexibleSearchService;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 13:12 2020/1/18
 * @since JDK 11
 */
public class MenuGroupServiceImpl implements MenuGroupService {
    private static final Logger LOG = Logger.getLogger(MenuGroupServiceImpl.class);

    @Autowired
    private PagedFlexibleSearchService pagedFlexibleSearchService;


    @Resource
    private FlexibleSearchService flexibleSearchService;

    /**
     * 分页查询权限组
     * @param params
     * @param pageableData
     * @return
     */
    @Override
    public SearchPageData<MenuGroupModel> getMenuGroupByPage(Map<String, Object> params, PageableData pageableData) {
        StringBuilder queryStr = new StringBuilder("select {mg.pk} from {MenuGroup as mg} where 1=1 ");
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

    /**
     * 查询一条权限组信息
     * @param uid
     * @return
     */
    @Override
    public MenuGroupModel getMenuGroupByID(String uid) {
        StringBuilder queryStr = new StringBuilder("select {mg.pk} from {MenuGroup as mg} where {mg.uid}=?uid");
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryStr.toString());
        query.addQueryParameter("uid", uid);
        try
        {
            return flexibleSearchService.searchUnique(query);
        }
        catch (final Exception e)
        {
            LOG.error("----------getMenuGroupByID hanpend error------");
            return null;
        }
    }

    /**
     * 获取所有menu
     * @return
     */
    @Override
    public List<OperationMenuModel> getAllMenu() {
        StringBuilder queryStr = new StringBuilder("select {m.pk} from {OperationMenu as m}");
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryStr.toString());
        try
        {
            return flexibleSearchService.<OperationMenuModel>search(query).getResult();
        }
        catch (final Exception e)
        {
            LOG.error("----------getAllMenu hanpend error------");
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * 获取一条menu
     * @param muid
     * @return
     */
    @Override
    public OperationMenuModel getMenuByUID(String muid) {
        String queryStr="select {m.pk} from {OperationMenu as m} where {m.uid}=?muid";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryStr);
        query.addQueryParameter("muid", muid);
        try
        {
            return flexibleSearchService.searchUnique(query);
        }
        catch (final Exception e)
        {
            LOG.error("----------getMenuByUID hanpend error------");
            return null;
        }
    }

    /**
     * 获取子按钮
     * @param uid
     * @return
     */
    @Override
    public List<OperationMenuModel> getMenuByPID(String uid) {
        StringBuilder queryStr = new StringBuilder("select {m.pk} from {OperationMenu as m} where {m.pid}=?pid");
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryStr.toString());
        query.addQueryParameter("pid", uid);
        try
        {
            return flexibleSearchService.<OperationMenuModel>search(query).getResult();
        }
        catch (final Exception e)
        {
            LOG.error("----------getMenuByPID hanpend error------");
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * 获取所有权限组
     * @return
     */
    @Override
    public List<MenuGroupModel> getAllMenuGroup() {
        StringBuilder queryStr = new StringBuilder("select {m.pk} from {MenuGroup as m}");
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryStr.toString());
        try
        {
            return flexibleSearchService.<MenuGroupModel>search(query).getResult();
        }
        catch (final Exception e)
        {
            LOG.error("----------getAllMenuGroup hanpend error------");
            return Collections.EMPTY_LIST;
        }
    }
}
