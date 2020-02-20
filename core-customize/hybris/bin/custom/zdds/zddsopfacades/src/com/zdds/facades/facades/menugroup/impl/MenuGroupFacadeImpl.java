package com.zdds.facades.facades.menugroup.impl;


import com.zdds.facades.facades.menugroup.MenuGroupFacade;
import com.zdds.facades.model.MenuGroupModel;
import com.zdds.facades.model.OperationMenuModel;
import com.zdds.facades.service.menugroup.MenuGroupService;
import com.zddsop.data.MenuData;
import com.zddsop.data.MenuGroupData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.keygenerator.KeyGenerator;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.*;
/**
 *
 *
 * 权限组管理
 * @author 李亚廷
 * @Date 13:11 2020/1/18
 * @since JDK 11
 */
public class MenuGroupFacadeImpl implements MenuGroupFacade {
    private static final Logger LOG = Logger.getLogger(MenuGroupFacadeImpl.class);

    @Autowired
    MenuGroupService menuGroupService;


    @Resource(name = "menuGroupConverter")
    private Converter<MenuGroupModel, MenuGroupData> menuGroupConverter;

    @Autowired
    private ModelService modelService;

    @Resource(name = "menuGroupGenerator")
    private KeyGenerator menuGroupGenerator;


    @Resource(name = "menuConverter")
    private Converter<OperationMenuModel, MenuData> menuConverter;


    /**
     * 分页查询权限组
     * @param params
     * @param pageableData
     * @return
     */
    @Override
    public SearchPageData<MenuGroupData> getMenuGroupByPage(Map<String, Object> params, PageableData pageableData) {
        SearchPageData searchPageData = menuGroupService.getMenuGroupByPage(params,pageableData);
        LOG.info("=============searchPageData.getResults().size()=========="+searchPageData.getResults().size());
        List<MenuGroupData> menuGroupDataList=menuGroupConverter.convertAll(searchPageData.getResults());
        searchPageData.setResults(menuGroupDataList);
        return searchPageData;
    }

    /**
     * 新增权限组
     * @param menuGroupData
     * @return
     */
    @Override
    public Map<String, Object> saveMenuGroup(MenuGroupData menuGroupData) {
        Map<String,Object> resultMap  = new HashedMap();
        resultMap.put("status", "success");
        resultMap.put("msg", "保存成功！");
        try {
            MenuGroupModel menuGroup=modelService.create(MenuGroupModel.class);
            menuGroup.setLocName(menuGroupData.getName(),Locale.CHINA);
            menuGroup.setDescription(menuGroupData.getDescription());
            menuGroup.setUid(menuGroupGenerator.generate().toString());
            modelService.save(menuGroup);
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            resultMap.put("status","fail");
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 查询一条权限组信息
     * @param uid
     * @return
     */
    @Override
    public MenuGroupData getMenuGroup(String uid) {
        MenuGroupModel menuGroupModel=menuGroupService.getMenuGroupByID(uid);
        return menuGroupConverter.convert(menuGroupModel);
    }

    /**
     * 获取编辑权限树
     * @param uid
     * @return
     */
    @Override
    public List<MenuData> authorityGroupTree(String uid) {
        List<OperationMenuModel> allMenu=menuGroupService.getAllMenu();
        LOG.info("----allMenu----"+allMenu.size());
        MenuGroupModel menuGroupModel=menuGroupService.getMenuGroupByID(uid);
        Set<PrincipalGroupModel> currentGroup=menuGroupModel.getGroups();
        List<OperationMenuModel> currentMenus=new ArrayList<OperationMenuModel>();
        for(PrincipalGroupModel principalGroupModel:currentGroup){
            OperationMenuModel menuModel=(OperationMenuModel)principalGroupModel;
            currentMenus.add(menuModel);
        }
        LOG.info("----currentMenus----"+currentMenus.size());
        List<MenuData> allMenuData=new ArrayList<MenuData>();
        for(OperationMenuModel menu:allMenu){
            MenuData  menuData=menuConverter.convert(menu);
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
     * 设置权限组权限
     * @param menuGroupData
     * @return
     */
    @Override
    public Map<String, Object> updateMenuGroup(MenuGroupData menuGroupData) {
        Map<String,Object> resultMap  = new HashedMap();
        resultMap.put("status", "success");
        resultMap.put("msg", "保存成功！");
        try {
            Set<PrincipalGroupModel> curentMenu = new HashSet<PrincipalGroupModel>();
            for (String muid : menuGroupData.getMuids()) {
                LOG.info("======muid=====" + muid);
                OperationMenuModel menuModel = menuGroupService.getMenuByUID(muid);
                //当前菜单
                if (null != menuModel) {
                    curentMenu.add(menuModel);
                    if(!"0".equals(menuModel.getPId())){
                        LOG.info("------------menuModel.getPId()--------"+menuModel.getPId());
                        OperationMenuModel pMenuModel = menuGroupService.getMenuByUID(menuModel.getPId());
                        //父菜单
                        if (null != pMenuModel) {
                            curentMenu.add(pMenuModel);
                            if(!"0".equals(pMenuModel.getPId())){
                                LOG.info("------------pMenuModel.getPId()--------"+pMenuModel.getPId());
                                OperationMenuModel ppMenuModel = menuGroupService.getMenuByUID(pMenuModel.getPId());
                                //父父菜单
                                if (null != ppMenuModel) {
                                    curentMenu.add(ppMenuModel);
                                    if(!"0".equals(ppMenuModel.getPId())){
                                        LOG.info("------------ppMenuModel.getPId()--------"+ppMenuModel.getPId());
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
            LOG.info("+++++menuGroupData.getName()+++++"+menuGroupData.getName());
            LOG.info("+++++menuGroupData.getDescription()++++"+menuGroupData.getDescription());
            MenuGroupModel menuGroupModel=menuGroupService.getMenuGroupByID(menuGroupData.getUid());
            Set<PrincipalGroupModel> vendorGroups=menuGroupModel.getGroups();
            menuGroupModel.setLocName(menuGroupData.getName(),Locale.CHINA);
            menuGroupModel.setDescription(menuGroupData.getDescription());
            menuGroupModel.setGroups(curentMenu);
            modelService.save(menuGroupModel);

            LOG.info("+++++curentMenu.size()+++++"+curentMenu.size());
            LOG.info("+++++vendorGroups.size()+++++"+vendorGroups.size());
            Collection<OperationMenuModel> addMenu=new HashSet<OperationMenuModel>();
            //权限组添加的menue
            Collection<OperationMenuModel> deleteMenu=new HashSet<OperationMenuModel>();
            //权限组删除的menu
            for(PrincipalGroupModel add:curentMenu){
                if(!vendorGroups.contains(add)){
                    addMenu.add((OperationMenuModel)add);
                }
            }
            for(PrincipalGroupModel delete:vendorGroups){
                if(!curentMenu.contains(delete)){
                    deleteMenu.add((OperationMenuModel)delete);
                }
            }

            Set<PrincipalModel> members= menuGroupModel.getMembers();
            LOG.info("=========members.size()========="+members.size());
            if(!addMenu.isEmpty()){
                for(PrincipalModel principalModel:members){
                    EmployeeModel employeeModel=(EmployeeModel)principalModel;
                    Collection<OperationMenuModel> allMenus=employeeModel.getMenus();
                    for(OperationMenuModel m:allMenus){
                        addMenu.add(m);
                    }
                    employeeModel.setMenus(addMenu);
                    modelService.save(employeeModel);
                }
            }
            if(!deleteMenu.isEmpty()){
                for(PrincipalModel principalModel:members){
                    EmployeeModel employeeModel=(EmployeeModel)principalModel;
                    Collection<OperationMenuModel> allMenus=employeeModel.getMenus();
                    Collection<OperationMenuModel> resultMenu=new HashSet<OperationMenuModel>();
                    for(OperationMenuModel m:allMenus){
                        if(!deleteMenu.contains(m)){
                            resultMenu.add(m);
                        }
                    }
                    employeeModel.setMenus(resultMenu);
                    modelService.save(employeeModel);
                }
            }


        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            resultMap.put("status","fail");
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 获取子级别菜单
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


}
