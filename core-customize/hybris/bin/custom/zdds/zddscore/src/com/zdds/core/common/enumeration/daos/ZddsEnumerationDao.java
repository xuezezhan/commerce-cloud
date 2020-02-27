package com.zdds.core.common.enumeration.daos;

import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/8/15
 *@since  JDK 1.8
 */
public interface ZddsEnumerationDao {

   SearchResult<List> getEnumerationListByModel(final String code);
}
