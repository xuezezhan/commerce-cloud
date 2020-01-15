package org.zddsbackoffice.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;
import org.zddsbackoffice.constants.YacceleratorbackofficeConstants;

public class YacceleratorbackofficeManager extends GeneratedYacceleratorbackofficeManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( YacceleratorbackofficeManager.class.getName() );
	
	public static final YacceleratorbackofficeManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (YacceleratorbackofficeManager) em.getExtension(YacceleratorbackofficeConstants.EXTENSIONNAME);
	}
	
}
