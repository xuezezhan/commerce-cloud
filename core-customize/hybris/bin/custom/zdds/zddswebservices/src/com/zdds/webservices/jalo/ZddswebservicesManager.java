package com.zdds.webservices.jalo;

import com.zdds.webservices.constants.ZddswebservicesConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

public class ZddswebservicesManager extends GeneratedZddswebservicesManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( ZddswebservicesManager.class.getName() );
	
	public static final ZddswebservicesManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ZddswebservicesManager) em.getExtension(ZddswebservicesConstants.EXTENSIONNAME);
	}
	
}
