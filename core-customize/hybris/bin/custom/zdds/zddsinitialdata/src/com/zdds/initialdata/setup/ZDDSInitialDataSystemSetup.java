/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.zdds.initialdata.setup;

import com.zdds.initialdata.constants.ZddsInitialDataConstants;
import com.zdds.initialdata.services.dataimport.impl.ZDDSCoreDataImportService;
import com.zdds.initialdata.services.dataimport.impl.ZDDSSampleDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.commerceservices.setup.events.CoreDataImportedEvent;
import de.hybris.platform.commerceservices.setup.events.SampleDataImportedEvent;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.initialization.SystemSetup.Type;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class provides hooks into the system's initialization and update processes.
 */
@SystemSetup(extension = ZddsInitialDataConstants.EXTENSIONNAME)
public class ZDDSInitialDataSystemSetup extends AbstractSystemSetup
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ZDDSInitialDataSystemSetup.class);

	private static final String IMPORT_CORE_DATA = "importCoreData";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";
	private static final String ACTIVATE_SOLR_CRON_JOBS = "activateSolrCronJobs";

	public static final String STORE_NAME_ZDDSB2B = "zddsb2b";
	public static final String STORE_NAME_ZDDSB2C = "zddsb2c";


	private ZDDSCoreDataImportService zddsCoreDataImportService;
	private ZDDSSampleDataImportService zddsSampleDataImportService;

	/**
	 * Generates the Dropdown and Multi-select boxes for the project data import
	 */
	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();

		params.add(createBooleanSystemSetupParameter(IMPORT_CORE_DATA, "Import Core Data", true));
		params.add(createBooleanSystemSetupParameter(IMPORT_SAMPLE_DATA, "Import Sample Data", true));
		params.add(createBooleanSystemSetupParameter(ACTIVATE_SOLR_CRON_JOBS, "Activate Solr Cron Jobs", true));
		// Add more Parameters here as you require

		return params;
	}

	/**
	 * Implement this method to create initial objects. This method will be called by system creator during
	 * initialization and system update. Be sure that this method can be called repeatedly.
	 * 
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.ESSENTIAL, process = Process.ALL)
	public void createEssentialData(final SystemSetupContext context)
	{
		// Add Essential Data here as you require
	}

	/**
	 * Implement this method to create data that is used in your project. This method will be called during the system
	 * initialization. <br>
	 * Add import data for each site you have configured
	 *
	 * <pre>
	 * final List<ImportData> importData = new ArrayList<ImportData>();
	 *
	 * final ImportData sampleImportData = new ImportData();
	 * sampleImportData.setProductCatalogName(SAMPLE_PRODUCT_CATALOG_NAME);
	 * sampleImportData.setContentCatalogNames(Arrays.asList(SAMPLE_CONTENT_CATALOG_NAME));
	 * sampleImportData.setStoreNames(Arrays.asList(SAMPLE_STORE_NAME));
	 * importData.add(sampleImportData);
	 *
	 * getCoreDataImportService().execute(this, context, importData);
	 * getEventService().publishEvent(new CoreDataImportedEvent(context, importData));
	 *
	 * getSampleDataImportService().execute(this, context, importData);
	 * getEventService().publishEvent(new SampleDataImportedEvent(context, importData));
	 * </pre>
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.PROJECT, process = Process.ALL)
	public void createProjectData(final SystemSetupContext context)
	{
		/*
		 * Add import data for each site you have configured
		 */
		final List<ImportData> importDatas = new ArrayList<ImportData>();

		final ImportData sampleImportDataForB2B = new ImportData();
		final ImportData sampleImportDataForB2C = new ImportData();

		sampleImportDataForB2B.setProductCatalogName(STORE_NAME_ZDDSB2B);
		sampleImportDataForB2B.setContentCatalogNames(Arrays.asList(STORE_NAME_ZDDSB2B));
		sampleImportDataForB2B.setStoreNames(Arrays.asList(STORE_NAME_ZDDSB2B));

		sampleImportDataForB2C.setProductCatalogName(STORE_NAME_ZDDSB2C);
		sampleImportDataForB2C.setContentCatalogNames(Arrays.asList(STORE_NAME_ZDDSB2C));
		sampleImportDataForB2C.setStoreNames(Arrays.asList(STORE_NAME_ZDDSB2C));

		importDatas.add(sampleImportDataForB2B);
		importDatas.add(sampleImportDataForB2C);

		LOG.info("-------CoreData Import start------");
		getZddsCoreDataImportService().execute(this, context, importDatas);
		getEventService().publishEvent(new CoreDataImportedEvent(context, importDatas));
		LOG.info("-------CoreData Import end------");

		LOG.info("-------SampleData Import start------");
		getZddsSampleDataImportService().execute(this, context, importDatas);
		getZddsSampleDataImportService().importCommerceOrgData(context);
		getEventService().publishEvent(new SampleDataImportedEvent(context, importDatas));
		LOG.info("-------SampleData Import end------");
	}

	public ZDDSCoreDataImportService getZddsCoreDataImportService()
	{
		return zddsCoreDataImportService;
	}

	@Required
	public void setZddsCoreDataImportService(final ZDDSCoreDataImportService zddsCoreDataImportService)
	{
		this.zddsCoreDataImportService = zddsCoreDataImportService;
	}

	public ZDDSSampleDataImportService getZddsSampleDataImportService()
	{
		return zddsSampleDataImportService;
	}

	@Required
	public void setZddsSampleDataImportService(final ZDDSSampleDataImportService zddsSampleDataImportService)
	{
		this.zddsSampleDataImportService = zddsSampleDataImportService;
	}
}
