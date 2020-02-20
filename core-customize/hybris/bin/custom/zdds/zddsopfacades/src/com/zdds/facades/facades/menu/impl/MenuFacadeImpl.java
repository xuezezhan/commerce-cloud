package com.zdds.facades.facades.menu.impl;

import com.zdds.facades.facades.menu.MenuFacade;
import com.zdds.facades.model.OperationMenuModel;
import com.zdds.facades.service.menugroup.MenuGroupService;
import com.zddsop.data.MenuData;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 菜单管理
 * @author 李亚廷
 * @Date 13:09 2020/1/18
 * @since JDK 11
 */
public class MenuFacadeImpl implements MenuFacade {


    @Resource(name = "menuConverter")
    private Converter<OperationMenuModel, MenuData> menuConverter;


    @Autowired
    MenuGroupService menuGroupService;

    @Override
    public List<MenuData> getMenusByUser(UserModel userModel) {
        EmployeeModel currentUser=(EmployeeModel)userModel;
        List<OperationMenuModel> menus=(List<OperationMenuModel>)currentUser.getMenus();

        List<MenuData> menuFirsts=new ArrayList<MenuData>();
        for(OperationMenuModel menu: menus){
            if("0".equals(menu.getPId()))
            {//获取一级菜单
                menuFirsts.add(menuConverter.convert(menu));
            }
        }
        for(MenuData menuFirst: menuFirsts)
        {//获取二级菜单
            List<MenuData> menuSeconds=new ArrayList<MenuData>();
            for(OperationMenuModel menu: menus){
                if(menu.getPId().equals(menuFirst.getUid())){
                    menuSeconds.add(menuConverter.convert(menu));
                }
            }
            menuFirst.setChild(menuSeconds);
        }
        return menuFirsts;
    }

    /**
     * 获取子按钮
     * @param uid
     * @return
     */
    @Override
    public List<MenuData> getMenusByPID(String uid) {
        List<OperationMenuModel> buttions=menuGroupService.getMenuByPID(uid);
        return menuConverter.convertAll(buttions);
    }
}
