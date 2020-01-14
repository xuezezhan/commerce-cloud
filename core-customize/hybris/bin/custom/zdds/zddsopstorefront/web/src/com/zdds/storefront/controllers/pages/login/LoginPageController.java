package com.zdds.storefront.controllers.pages.login;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.LoginForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdds.storefront.controllers.ControllerConstants;
import com.zdds.storefront.controllers.pages.AbstractPageController;


/**
 *
 *
 * 登录界面
 *
 * @author 李亚廷
 * @Date 11:33 2020/1/9
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "/")
public class LoginPageController extends AbstractPageController
{
	private static Logger LOG = Logger.getLogger(LoginPageController.class);

	/**
	 * 登录运营子系统
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(@RequestParam(value = "logout", defaultValue = "false")
	final boolean logout, final Model model, @RequestParam(value = "error", defaultValue = "false")
	final boolean loginError, final HttpServletRequest request)
	{
		if (logout)
		{
			GlobalMessages.addInfoMessage(model, "account.confirmation.signout.title");
			return ControllerConstants.Views.Pages.LOGIN_PAGE;
		}
		//添加login form
		final LoginForm loginForm = new LoginForm();
		model.addAttribute(loginForm);
		if (loginError)
		{
			GlobalMessages.addErrorMessage(model, "login.error.account.not.found.title");
			return ControllerConstants.Views.Pages.LOGIN_PAGE;
		}
		return ControllerConstants.Views.Pages.LOGIN_PAGE;
	}

}
