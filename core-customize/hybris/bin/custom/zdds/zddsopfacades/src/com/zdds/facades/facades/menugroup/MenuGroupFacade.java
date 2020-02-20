package com.zdds.facades.facades.menugroup;


import com.zddsop.data.MenuData;
import com.zddsop.data.MenuGroupData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;

import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 13:10 2020/1/18
 * @since JDK 11
 */
public interface MenuGroupFacade {

    /**
     * 分页查询权限组
     * @param params
     * @param pageableData
     * @return
     */
    SearchPageData<MenuGroupData> getMenuGroupByPage(Map<String, Object> params, PageableData pageableData);

    /**
     * 新增权限组
     * @param menuGroupData
     * @return
     */
    Map<String,Object> saveMenuGroup(MenuGroupData menuGroupData);

    /**
     * 查询一条权限组信息
     * @param uid
     * @return
     */
    MenuGroupData getMenuGroup(String uid);

    /**
     *获取编辑权限树
     * @param uid
     * @return
     */
    List<MenuData> authorityGroupTree(String uid);

    /**
     * 设置权限组权限
     * @param menuGroupData
     * @return
     */
    Map<String,Object> updateMenuGroup(MenuGroupData menuGroupData);
}
