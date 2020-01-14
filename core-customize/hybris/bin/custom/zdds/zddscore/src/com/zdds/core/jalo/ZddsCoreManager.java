package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

public class ZddsCoreManager extends GeneratedZddsCoreManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( ZddsCoreManager.class.getName() );
	
	public static final ZddsCoreManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ZddsCoreManager) em.getExtension(ZddsCoreConstants.EXTENSIONNAME);
	}
	
}
