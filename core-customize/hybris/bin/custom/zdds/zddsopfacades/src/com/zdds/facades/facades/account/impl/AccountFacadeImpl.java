package com.zdds.facades.facades.account.impl;


import com.zdds.core.model.SupplierModel;
import com.zdds.facades.facades.account.AccountFacade;
import com.zdds.facades.model.MenuGroupModel;
import com.zdds.facades.model.OperationMenuModel;
import com.zdds.facades.service.account.AccountService;
import com.zdds.facades.service.menugroup.MenuGroupService;
import com.zddsop.data.AccountData;
import com.zddsop.data.MenuData;
import com.zddsop.data.MenuGroupData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.keygenerator.KeyGenerator;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 12:39 2020/1/18
 * @since JDK 11
 */
public class AccountFacadeImpl implements AccountFacade {
    private static final Logger LOG = Logger.getLogger(AccountFacadeImpl.class);

    @Autowired
    AccountService accountService;

    @Resource(name = "accountConverter")
    private Converter<EmployeeModel, AccountData> accountConverter;

    @Autowired
    private ModelService modelService;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "employeeGenerator")
    private KeyGenerator employeeGenerator;

    @Autowired
    MenuGroupService menuGroupService;

    @Resource(name = "menuConverter")
    private Converter<OperationMenuModel, MenuData> menuConverter;


    @Resource(name = "menuGroupConverter")
    private Converter<MenuGroupModel, MenuGroupData> menuGroupConverter;


    /**
     * 分页查询账号
     * @param params
     * @param pageableData
     * @return
     */
    @Override
    public SearchPageData<AccountData> searchAccount(Map<String, Object> params, PageableData pageableData) {
        SearchPageData searchPageData = accountService.searchAccount(params,pageableData);
        List<AccountData> accountDataList=accountConverter.convertAll(searchPageData.getResults());
        searchPageData.setResults(accountDataList);
        return searchPageData;
    }

    /**
     * 新建账号
     * @param accountData
     * @return
     */
    @Override
    public Map<String, Object> saveAccount(AccountData accountData) {
        Map<String,Object> resultMap  = new HashedMap();
        resultMap.put("status", "success");
        resultMap.put("msg", "保存成功！");
        try {
            //保存用户信息
            EmployeeModel employee=modelService.create(EmployeeModel.class);
            employee.setUid(employeeGenerator.generate().toString());
            employee.setName(accountData.getName());
            Set<PrincipalGroupModel> groupModels=new HashSet<PrincipalGroupModel>();
            UserGroupModel userGroupModel= userService.getUserGroupForUID("employeegroup");
            groupModels.add(userGroupModel);
            //促销管理员用户组
//            UserGroupModel workflowModel= userService.getUserGroupForUID("workflow");
//            groupModels.add(workflowModel);
            employee.setGroups(groupModels);
            modelService.save(employee);
            //设置密码
            modelService.refresh(employee);
            userService.setPasswordWithDefaultEncoding(employee,accountData.getPassword());
            modelService.save(employee);
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            resultMap.put("status","fail");
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 查询一条账号信息
     * @param uid
     * @return
     */
    @Override
    public AccountData getAccount(String uid) {
        EmployeeModel employeeModel=(EmployeeModel)userService.getUserForUID(uid);
        AccountData accountData=accountConverter.convert(employeeModel);
        return accountData;
    }

    /**
     * 更新一条账号信息
     * @param accountData
     * @return
     */
    @Override
    public Map<String, Object> updateAccount(AccountData accountData) {
        Map<String,Object> resultMap  = new HashedMap();
        resultMap.put("status", "success");
        resultMap.put("msg", "保存成功！");
        try {
            //保存用户信息
            UserModel userModel=userService.getUserForUID(accountData.getUid());
            userModel.setName(accountData.getName());
            if(StringUtils.isNotEmpty(accountData.getPassword())){
                userService.setPasswordWithDefaultEncoding(userModel,accountData.getPassword());
            }
            modelService.save(userModel);
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            resultMap.put("status","fail");
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 获取权限编辑树
     * @param uid
     * @return
     */
    @Override
    public List<MenuData> authorityTree(String uid) {
        List<OperationMenuModel> allMenu=menuGroupService.getAllMenu();
        LOG.info("----allMenu----"+allMenu.size());
        SupplierModel currentUser=(SupplierModel)userService.getUserForUID(uid);
        List<OperationMenuModel> currentMenus=(List<OperationMenuModel>)currentUser.getMenus();
        LOG.info("----currentMenus----"+currentMenus.size());
        List<MenuData> allMenuData=new ArrayList<MenuData>();
        for(OperationMenuModel menu:allMenu){
            MenuData menuData=menuConverter.convert(menu);
            if(currentMenus.contains(menu))
            {//拥有该权限设置为1，不拥有设置为0
                menuData.setChecked("1");
            }else{
                menuData.setChecked("0");
            }
            allMenuData.add(menuData);
        }
        LOG.info("----currentMenus----"+currentMenus.size());
        //创建级别关系
        List<MenuData> menuFirsts=getChildMenu("0",allMenuData);
        //获取一级菜单

        List<MenuData> menuSeconds=new ArrayList<MenuData>();
        //获取二级别菜单
        for(MenuData menuFirst: menuFirsts)
        {
            List<MenuData> menuSecond=getChildMenu(menuFirst.getUid(),allMenuData);
            menuFirst.setChild(menuSecond);
            menuSeconds.addAll(menuSecond);
        }
        List<MenuData> menuThirds=new ArrayList<MenuData>();
        //获取三级别菜单
        for(MenuData menuSecond: menuSeconds)
        {
            List<MenuData> menuThird=getChildMenu(menuSecond.getUid(),allMenuData);
            menuSecond.setChild(menuThird);
            menuThirds.addAll(menuThird);
        }
        //获取四级别菜单
        for(MenuData menuThird: menuThirds)
        {
            List<MenuData> menuForth=getChildMenu(menuThird.getUid(),allMenuData);
            menuThird.setChild(menuForth);
        }
        LOG.info("----menuFirsts----"+menuFirsts.size());
        return menuFirsts;
    }

    /**
     * 获取子菜单
     * @param pid
     * @param allMenuData
     * @return
     */
    public List<MenuData> getChildMenu(String pid,List<MenuData> allMenuData){
        List<MenuData> childMenus=new ArrayList<MenuData>();
        for(MenuData menu: allMenuData){
            if(pid.equals(menu.getPid()))
            {//获取一级菜单
                childMenus.add(menu);
            }
        }
        return childMenus;
    }

    /**
     * 设置账号权限
     * @param uid
     * @param muids
     * @return
     */
    @Override
    public Map<String, Object> updateAccountAuthority(String uid, List<String> muids) {
        Map<String,Object> resultMap  = new HashedMap();
        resultMap.put("status", "success");
        resultMap.put("msg", "保存成功！");

        try {
            Set<OperationMenuModel> curentMenu = new HashSet<OperationMenuModel>();
            for (String muid : muids) {
                OperationMenuModel menuModel =menuGroupService.getMenuByUID(muid);
                //当前菜单
                if (null != menuModel) {
                    curentMenu.add(menuModel);
                    if(!"0".equals(menuModel.getPId())){
                        OperationMenuModel pMenuModel = menuGroupService.getMenuByUID(menuModel.getPId());
                        //父菜单
                        if (null != pMenuModel) {
                            curentMenu.add(pMenuModel);
                            if(!"0".equals(pMenuModel.getPId())){
                                OperationMenuModel ppMenuModel = menuGroupService.getMenuByUID(pMenuModel.getPId());
                                //父父菜单
                                if (null != ppMenuModel) {
                                    curentMenu.add(ppMenuModel);
                                    if(!"0".equals(ppMenuModel.getPId())){
                                        OperationMenuModel pppMenuModel = menuGroupService.getMenuByUID(ppMenuModel.getPId());
                                        //父父菜单
                                        if (null != pppMenuModel) {
                                            curentMenu.add(ppMenuModel);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            LOG.info("+++++curentMenu.size()+++++"+curentMenu.size());
            SupplierModel employeeModel =(SupplierModel)userService.getUserForUID(uid);
            employeeModel.setMenus(curentMenu);
            modelService.save(employeeModel);

        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            resultMap.put("status","fail");
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 修改账号状态
     * @param accountDatas
     * @return
     */
    @Override
    public Map<String, Object> updateStatus(List<AccountData> accountDatas) {
        UserModel currentUser=userService.getCurrentUser();
        Map<String,Object> resultMap  = new HashedMap();
        for(AccountData vud:accountDatas){
            if(currentUser.getUid().equals(vud.getUid())){
                resultMap.put("status","fail");
                resultMap.put("msg", "禁止启/停主账户");
                return resultMap;
            }
        }

        try {
            for(AccountData accountData:accountDatas){
                UserModel user=userService.getUserForUID(accountData.getUid());
                if(null!=user){
                    if("已停用".equals(accountData.getStatus())){
                        user.setLoginDisabled(false);
                    }else{
                        user.setLoginDisabled(true);
                    }
                    modelService.save(user);
                }
            }
            resultMap.put("status", "success");
            resultMap.put("msg", "修改成功！");
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            resultMap.put("status","fail");
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 获取权限树
     * @param uid
     * @return
     */
    @Override
    public List<MenuGroupData> accountGroupTree(String uid) {
        List<MenuGroupModel> allMenuGroup=menuGroupService.getAllMenuGroup();
        LOG.info("----allMenuGroup----"+allMenuGroup.size());
        UserModel user=userService.getUserForUID(uid);
        Set<PrincipalGroupModel> currentGroup=user.getGroups();
        List<MenuGroupModel> currentMenuGroups=new ArrayList<MenuGroupModel>();
        for(PrincipalGroupModel principalGroupModel:currentGroup){
            if(principalGroupModel instanceof MenuGroupModel){
                MenuGroupModel menuGroupModel=(MenuGroupModel)principalGroupModel;
                currentMenuGroups.add(menuGroupModel);
            }
        }
        LOG.info("----currentMenuGroups----"+currentMenuGroups.size());
        List<MenuGroupData> allMenuGroupData=new ArrayList<MenuGroupData>();
        for(MenuGroupModel menuGroup:allMenuGroup){
            MenuGroupData  menuGroupData=menuGroupConverter.convert(menuGroup);
            if(currentMenuGroups.contains(menuGroup))
            {
                //拥有该权限设置为1，不拥有设置为0
                menuGroupData.setChecked("1");
            }else{
                menuGroupData.setChecked("0");
            }
            allMenuGroupData.add(menuGroupData);
        }
        return allMenuGroupData;
    }

    /**
     * 修改用户的权限组
     * @param uid
     * @param muids
     * @return
     */
    @Override
    public Map<String, Object> updateAccountGroup(String uid, List<String> muids) {
        Map<String,Object> resultMap  = new HashedMap();
        resultMap.put("status", "success");
        resultMap.put("msg", "保存成功！");

        try {
            Set<PrincipalGroupModel> curentMenuGroup = new HashSet<PrincipalGroupModel>();
            Collection<OperationMenuModel> menuModels = new ArrayList<OperationMenuModel>();
            for (String muid : muids) {
                LOG.info("======muid=====" + muid);
                MenuGroupModel menuGroupModel=menuGroupService.getMenuGroupByID(muid);
                curentMenuGroup.add(menuGroupModel);
                for(PrincipalGroupModel m:menuGroupModel.getGroups()){
                    menuModels.add((OperationMenuModel) m);
                }
            }
            LOG.info("+++++curentMenuGroup.size()+++++"+curentMenuGroup.size());

            SupplierModel employee = (SupplierModel)userService.getUserForUID(uid);
            Set<PrincipalGroupModel> employeeGroups=employee.getGroups();
            for(PrincipalGroupModel principalGroupModel:employeeGroups){
                if(principalGroupModel instanceof  MenuGroupModel){
                    //去所有权限组
                }else{
                    curentMenuGroup.add(principalGroupModel);
                }
            }
            LOG.info("+++++curentMenuGroup.size()+++++"+curentMenuGroup.size());
            employee.setGroups(curentMenuGroup);
            employee.setMenus(menuModels);
            modelService.save(employee);

        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            resultMap.put("status","fail");
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

}
