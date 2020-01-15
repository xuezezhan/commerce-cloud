/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.zdds.initialdata.services.dataimport.impl;

import de.hybris.platform.commerceservices.dataimport.impl.SampleDataImportService;
import de.hybris.platform.core.initialization.SystemSetupContext;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 9:18 2020/1/14
 * @since JDK 11
 */

public class ZDDSSampleDataImportService extends SampleDataImportService
{

	/**
	 * Imports the data related to Commerce Org.
	 *
	 * @param context
	 *           the context used.
	 */
	public void importCommerceOrgData(final SystemSetupContext context)
	{
		final String extensionName = context.getExtensionName();

		getSetupImpexService().importImpexFile(String.format("/%s/import/sampledata/commerceorg/user-groups.impex", extensionName),
				false);
	}

}
