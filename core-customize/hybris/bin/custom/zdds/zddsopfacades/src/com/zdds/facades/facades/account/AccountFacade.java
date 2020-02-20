package com.zdds.facades.facades.account;


import com.zddsop.data.AccountData;
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
 * @Date 13:07 2020/1/18
 * @since JDK 11
 */
public interface AccountFacade {
    /**
     * 分页查询账号
     * @param params
     * @param pageableData
     * @return
     */
    SearchPageData<AccountData> searchAccount(Map<String, Object> params, PageableData pageableData);

    /**
     * 新建账号
     * @param accountData
     * @return
     */
    Map<String,Object> saveAccount(AccountData accountData);

    /**
     * 查询一条账号信息
     * @param uid
     * @return
     */
    AccountData getAccount(String uid);

    /**
     * 更新一条账号信息
     * @param accountData
     * @return
     */
    Map<String,Object> updateAccount(AccountData accountData);

    /**
     * 获取权限编辑树
     * @param uid
     * @return
     */
    List<MenuData> authorityTree(String uid);

    /**
     * 设置账号权限
     * @param uid
     * @param muids
     * @return
     */
    Map<String,Object> updateAccountAuthority(String uid, List<String> muids);

    /**
     * 修改账号状态
     * @param accountDatas
     * @return
     */
    Map<String,Object> updateStatus(List<AccountData> accountDatas);

    /**
     * 获取权限树
     * @param uid
     * @return
     */
    List<MenuGroupData> accountGroupTree(String uid);

    /**
     * 修改用户的权限组
     * @param uid
     * @param muids
     * @return
     */
    Map<String,Object> updateAccountGroup(String uid, List<String> muids);
}
