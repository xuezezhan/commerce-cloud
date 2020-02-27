package com.zdds.core.common.enumeration.daos.impl;



import com.zdds.core.common.enumeration.daos.ZddsEnumerationDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/8/15
 *@since  JDK 1.8
 */
@Repository(value = "zddsEnumerationDao")
public class ZddsEnumerationDaoImpl implements ZddsEnumerationDao {

   private final static Logger LOG = LoggerFactory.getLogger(ZddsEnumerationDaoImpl.class);

   @Resource
   private FlexibleSearchService flexibleSearchService;

   @Override
   public SearchResult<List> getEnumerationListByModel(String code) {
       final StringBuffer query = new StringBuffer();
       query.append( "SELECT {p.pk},{p.code},{p.name[zh]} FROM {" + code + " AS p}");

       try{
           final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(query.toString());
           fQuery.setResultClassList(Arrays.asList(String.class,String.class, String.class));

           return flexibleSearchService.search(fQuery);
       }
       catch (Exception e) {
           LOG.error("getEnumerationListByModel throws  exception:",e);
           return null;
       }
   }
}
