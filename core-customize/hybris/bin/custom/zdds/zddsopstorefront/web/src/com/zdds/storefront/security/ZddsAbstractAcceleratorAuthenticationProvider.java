package com.zdds.storefront.security;

import de.hybris.platform.acceleratorstorefrontcommons.security.BruteForceAttackCounter;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.spring.security.CoreAuthenticationProvider;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;


/**
 *
 *
 * 中台登陆逻辑
 *
 * @author 李亚廷
 * @Date 16:40 2020/1/18
 * @since JDK 11
 */
public abstract class ZddsAbstractAcceleratorAuthenticationProvider extends CoreAuthenticationProvider
{
	private static final Logger LOG = Logger.getLogger(ZddsAbstractAcceleratorAuthenticationProvider.class);

	public static final String CORE_AUTHENTICATION_PROVIDER_BAD_CREDENTIALS = "CoreAuthenticationProvider.badCredentials";
	public static final String BAD_CREDENTIALS = "Bad credentials";

	private BruteForceAttackCounter bruteForceAttackCounter;
	private UserService userService;
	private ModelService modelService;


	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException
	{
		final String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
		final boolean isBruteForceAttack = getBruteForceAttackCounter().isAttack(username);
		UserModel userModel = null;
		LOG.info("username=" + username);
		// throw BadCredentialsException if user does not exist
		try
		{
			userModel = getUserService().getUserForUID(StringUtils.lowerCase(username));
			LOG.info("userModel=" + userModel.getPk());
		}
		catch (final UnknownIdentifierException e)
		{
			if (isBruteForceAttack)
			{
				LOG.warn("Brute force attack attempt for non existing user name " + username);
			}
			throw new BadCredentialsException(messages.getMessage(CORE_AUTHENTICATION_PROVIDER_BAD_CREDENTIALS, BAD_CREDENTIALS), e);
		}

		LOG.info("-------------isBruteForceAttack=" + isBruteForceAttack);
		// throw BadCredentialsException if it's brute force attack
		if (isBruteForceAttack)
		{
			userModel.setLoginDisabled(true);
			getModelService().save(userModel);
			bruteForceAttackCounter.resetUserCounter(userModel.getUid());
			throw new BadCredentialsException(messages.getMessage(CORE_AUTHENTICATION_PROVIDER_BAD_CREDENTIALS, BAD_CREDENTIALS));
		}

		//		if (!getUserService().isMemberOfGroup(userModel, getUserService().getUserGroupForUID("customergroup")))
		//		{
		//			throw new BadCredentialsException(messages.getMessage(CORE_AUTHENTICATION_PROVIDER_BAD_CREDENTIALS, BAD_CREDENTIALS));
		//		}

		LOG.info("-------------super.authenticate-----------------");
		return super.authenticate(authentication);
	}

	/**
	 * @see CoreAuthenticationProvider#additionalAuthenticationChecks(UserDetails, AbstractAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(final UserDetails details, final AbstractAuthenticationToken authentication)
			throws AuthenticationException
	{
		super.additionalAuthenticationChecks(details, authentication);
		// Check if user has supplied no password
		if (StringUtils.isEmpty((String) authentication.getCredentials()))
		{
			throw new BadCredentialsException("Login without password");
		}
	}

	protected BruteForceAttackCounter getBruteForceAttackCounter()
	{
		return bruteForceAttackCounter;
	}

	@Required
	public void setBruteForceAttackCounter(final BruteForceAttackCounter bruteForceAttackCounter)
	{
		this.bruteForceAttackCounter = bruteForceAttackCounter;
	}

	protected UserService getUserService()
	{
		return userService;
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	protected ModelService getModelService()
	{
		return modelService;
	}

	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}
}
