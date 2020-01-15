package com.zdds.storefront.controllers.pages;

import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import javax.annotation.Resource;
/**
 *
 *
 * 公共方法
 * @author 李亚廷
 * @Date 21:22 2020/1/9
 * @since JDK 1.8
 */
public class AbstractPageController {

    public static final String REDIRECT_PREFIX = "redirect:";

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "modelService")
    private ModelService modelService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
