/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.zdds.webservices.services;

import de.hybris.platform.core.model.user.UserModel;

import java.util.Collection;


public interface SampleUserServices
{
	UserModel getUserById(String id);

	Collection<UserModel> getUsers();
}
