/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.zdds.webservices.facades;

import de.hybris.platform.core.servicelayer.data.SearchPageData;

import java.util.List;

import com.zdds.webservices.data.UserData;
import com.zdds.webservices.dto.SampleWsDTO;
import com.zdds.webservices.dto.TestMapWsDTO;


public interface SampleFacades
{
	SampleWsDTO getSampleWsDTO(final String value);

	UserData getUser(String id);

	List<UserData> getUsers();

	SearchPageData<UserData> getUsers(SearchPageData<?> params);

	TestMapWsDTO getMap();
}
