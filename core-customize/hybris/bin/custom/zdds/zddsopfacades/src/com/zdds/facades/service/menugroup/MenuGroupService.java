package com.zdds.facades.service.menugroup;


import com.zdds.facades.model.MenuGroupModel;
import com.zdds.facades.model.OperationMenuModel;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;

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
public interface MenuGroupService {
    /**
     * 分页查询权限组
     * @param params
     * @param pageableData
     * @return
     */
    SearchPageData<MenuGroupModel> getMenuGroupByPage(Map<String, Object> params, PageableData pageableData);

    /**
     * 查询一条权限组信息
     * @param uid
     * @return
     */
    MenuGroupModel getMenuGroupByID(String uid);

    /**
     * 获取所有menu
     * @return
     */
    List<OperationMenuModel> getAllMenu();

    /**
     * 获取一条menu
     * @param muid
     * @return
     */
    OperationMenuModel getMenuByUID(String muid);


    /**
     * 获取子按钮
     * @param muid
     * @return
     */
    List<OperationMenuModel> getMenuByPID(String muid);

    /**
     * 获取所有权限组
     * @return
     */
    List<MenuGroupModel> getAllMenuGroup();
}
