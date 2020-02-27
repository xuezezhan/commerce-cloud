package com.zdds.storefront.controllers.pages.login;


import com.alibaba.fastjson.JSON;
import com.zdds.core.common.enumeration.services.ZddsEnumerationService;
import com.zdds.facades.facades.menu.MenuFacade;
import com.zddsop.data.MenuData;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.LoginForm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import de.hybris.platform.basecommerce.enums.ConsignmentStatus;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.user.PasswordEncoderService;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdds.storefront.controllers.ControllerConstants;
import com.zdds.storefront.controllers.pages.AbstractPageController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;
import java.util.Set;


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

	@Resource(name = "menuFacade")
	private MenuFacade menuFacade;

	@Resource(name = "passwordEncoderService")
	private PasswordEncoderService passwordEncoderService;

	@Resource(name = "zddsEnumerationService")
	ZddsEnumerationService zddsEnumerationService;

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

	@RequestMapping(value = "/frontendhome", method ={ RequestMethod.GET, RequestMethod.POST })
	public String frontEndHome(final Model model)
	{
		UserModel userModel = getUserService().getCurrentUser();
		model.addAttribute("user", userModel);
		Set<PrincipalGroupModel> userSet=userModel.getGroups();
		List<MenuData> menus=menuFacade.getMenusByUser(userModel);
		String menuJSON= JSON.toJSONString(menus);
		model.addAttribute("menuJSON", menuJSON);
		return ControllerConstants.Views.Pages.INDEX;
	}

	@RequestMapping(value = "/logout", method ={ RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request) {
		LOG.info("------------logout------------");
		SecurityContextHolder.clearContext();
		return REDIRECT_PREFIX + "/login?logout=true";
	}

	/**
	 * 跳转到对应页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pageJump", method ={ RequestMethod.GET, RequestMethod.POST })
	public String pageJump(final Model model, final HttpServletRequest request)
	{

		Set<String> param = request.getParameterMap().keySet();
		for(String key :param){
			model.addAttribute(key, request.getParameterMap().get(key)[0]);
		}
		//获取按钮权限
		String pid=request.getParameter("mid");
		if(pid!=null) {
			List<MenuData> buttons = menuFacade.getMenusByPID(pid);
			String buttonJSON = JSON.toJSONString(buttons);
			model.addAttribute("buttonJSON", buttonJSON);
		}

		//发货单列表页面
		if(request.getParameter("pageTarget").equalsIgnoreCase("pages/consignment/consignmentManage")){
			model.addAttribute("statuses",zddsEnumerationService.getEnumerationDataByType(ConsignmentStatus._TYPECODE, Locale.CHINESE));
		}
		return request.getParameter("pageTarget");
	}



	/**
	 * 修改密码
	 * @param model
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping(value = "/updatePass", method ={ RequestMethod.GET, RequestMethod.POST })
	public String updatePass(final Model model, final HttpServletRequest request, RedirectAttributes attr)
	{
		try{
			final UserModel user = getUserService().getUserForUID(request.getParameter("userId"));
			final String oldPass = request.getParameter("password_old");
			final String newPass = request.getParameter("password_new");
			final Integer result = changePassword(user,oldPass,newPass);
			if(result==0){
				GlobalMessages.addErrorMessage(model, "login.error.account.not.exists.password.title");
			}else if(result==1){
				GlobalMessages.addErrorMessage(model, "login.error.account.update.password.exception.title");
			}else{
				GlobalMessages.addInfoMessage(model, "login.confirmation.update.password.title");
			}
		}catch(UnknownIdentifierException exception){
			LOG.error(exception.getMessage());
			GlobalMessages.addErrorMessage(model, "login.error.account.not.exists.title");
		}
		model.addAttribute("updatePass","ok");
		return ControllerConstants.Views.Pages.LOGIN_PAGE;
	}


	public Integer changePassword(final UserModel userModel, final String oldPassword, final String newPassword){
		try{
			if (!getUserService().isAnonymousUser(userModel)){
				if (passwordEncoderService.isValid(userModel, oldPassword)){
					getUserService().setPassword(userModel, newPassword, userModel.getPasswordEncoding());
					userModel.setLoginDisabled(false);
					getModelService().save(userModel);
				}else{
					return 0;
				}
			}
		}catch (final Exception e){
			LOG.error(e.getMessage());
			return 1;
		}
		return 2;
	}
}
