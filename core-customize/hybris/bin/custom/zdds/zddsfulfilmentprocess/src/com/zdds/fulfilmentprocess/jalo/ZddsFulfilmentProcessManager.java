package com.zdds.fulfilmentprocess.jalo;

import com.zdds.fulfilmentprocess.constants.ZddsFulfilmentProcessConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

public class ZddsFulfilmentProcessManager extends GeneratedZddsFulfilmentProcessManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( ZddsFulfilmentProcessManager.class.getName() );
	
	public static final ZddsFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ZddsFulfilmentProcessManager) em.getExtension(ZddsFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
