package com.zdds.facades.facades.menu;

import com.zddsop.data.MenuData;
import de.hybris.platform.core.model.user.UserModel;

import java.util.List;


/**
 *
 *
 *
 * @author 李亚廷
 * @Date 13:09 2020/1/18
 * @since JDK 11
 */
public interface MenuFacade {
    List<MenuData> getMenusByUser(UserModel userModel);

    List<MenuData> getMenusByPID(String uid);
}
