/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.zdds.facades.setup;

import static com.zdds.facades.constants.ZddsopfacadesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.zdds.facades.constants.ZddsopfacadesConstants;
import com.zdds.facades.service.ZddsopfacadesService;


@SystemSetup(extension = ZddsopfacadesConstants.EXTENSIONNAME)
public class ZddsopfacadesSystemSetup
{
	private final ZddsopfacadesService zddsopfacadesService;

	public ZddsopfacadesSystemSetup(final ZddsopfacadesService zddsopfacadesService)
	{
		this.zddsopfacadesService = zddsopfacadesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		zddsopfacadesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ZddsopfacadesSystemSetup.class.getResourceAsStream("/zddsopfacades/sap-hybris-platform.png");
	}
}
