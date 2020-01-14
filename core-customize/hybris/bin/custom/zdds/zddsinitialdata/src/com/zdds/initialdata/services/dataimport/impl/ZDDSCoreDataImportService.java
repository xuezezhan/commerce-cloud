/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.zdds.initialdata.services.dataimport.impl;

import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;


/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 9:21 2020/1/14
 * @since JDK 11
 */
public class ZDDSCoreDataImportService extends CoreDataImportService
{
	/**
	 * Imports store data related to Powertools. Imports a site-override impex if available.
	 *
	 * @param extensionName
	 *           the extension name used.
	 * @param storeName
	 *           the store to import for.
	 * @param productCatalogName
	 *           the product catalog used.
	 */
	@Override
	protected void importStore(final String extensionName, final String storeName, final String productCatalogName)
	{
		super.importStore(extensionName, storeName, productCatalogName);

		if (getConfigurationService().getConfiguration().getBoolean("setup.siteoverride", false))
		{
			getSetupImpexService()
					.importImpexFile(String.format("/%s/import/coredata/stores/%s/site-override.impex", extensionName, storeName), false);
		}
	}
}
