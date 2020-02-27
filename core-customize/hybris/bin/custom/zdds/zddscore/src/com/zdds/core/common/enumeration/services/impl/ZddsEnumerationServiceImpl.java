package com.zdds.core.common.enumeration.services.impl;


import com.zdds.core.bean.EnumerationBean;
import com.zdds.core.common.enumeration.daos.ZddsEnumerationDao;
import com.zdds.core.common.enumeration.services.ZddsEnumerationService;
import com.zdds.core.common.flexible.services.ZddsCommonService;
import com.zdds.core.util.DaoUtils;
import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.core.HybrisEnumValue;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.RegionModel;
import de.hybris.platform.core.model.enumeration.EnumerationValueModel;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.ordersplitting.model.WarehouseModel;
import de.hybris.platform.paymentstandard.model.StandardPaymentModeModel;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/8/15
 *@since  JDK 1.8
 */
@Service(value = "zddsEnumerationService")
public class ZddsEnumerationServiceImpl implements ZddsEnumerationService {

   private final static Logger LOG = LoggerFactory.getLogger(ZddsEnumerationServiceImpl.class);

   @Resource(name = "i18nService")
   private I18NService i18nService;

   @Resource(name = "enumerationService")
   private EnumerationService enumerationService;

   @Resource(name = "typeService")
   private TypeService typeService;

   @Resource
    private ZddsEnumerationDao zddsEnumerationDao;

   @Resource
   private FlexibleSearchService flexibleSearchService;

   @Resource
   private ZddsCommonService zddsCommonService;


   /**
    * 根据枚举值type获取枚举值list
    * @param type
    * @param locale
    * @return
    */
   @Override
   public List<EnumerationBean> getEnumerationDataByType(String type, Locale locale) {

       final List<HybrisEnumValue> enumValueList = enumerationService.getEnumerationValues(type);
       final List<EnumerationBean> enumDataList = new ArrayList<EnumerationBean>();
       Locale curLocale = null;
       if (locale == null)
       {
           curLocale = i18nService.getCurrentLocale();
       }
       else
       {
           curLocale = locale;
       }

       for (final HybrisEnumValue enumValue : enumValueList)
       {
           final EnumerationBean data = new EnumerationBean();
           final EnumerationValueModel enumerationValue = typeService.getEnumerationValue(enumValue);
           data.setPk(enumerationValue.getPk().getLongValueAsString());
           data.setCode(enumerationValue.getCode());
           data.setName(enumerationValue.getName(curLocale) == null ? "" : enumerationValue.getName(curLocale));
           enumDataList.add(data);
       }

       return enumDataList;
   }


   /**
    * 根据枚举值type和枚举值code获取枚举值
    * @param type
    * @param locale
    * @param code
    * @return
    */
   @Override
   public EnumerationBean getOne(String type, Locale locale, String code) {
       final EnumerationBean data = new EnumerationBean();
       if (StringUtils.isBlank(code)|| StringUtils.isBlank(type)){
           return data;
       }
       final HybrisEnumValue enumValue = enumerationService.getEnumerationValue(type, code);

       Locale curLocale = null;
       if (locale == null)
       {
           curLocale = i18nService.getCurrentLocale();
       }
       else
       {
           curLocale = locale;
       }


       final EnumerationValueModel enumerationValue = typeService.getEnumerationValue(enumValue);
       data.setPk(enumerationValue.getPk().getLongValueAsString());
       data.setCode(enumerationValue.getCode());
       data.setName(enumerationValue.getName(curLocale));

       return data;
   }

   @Override
   public List<EnumerationBean> getEnumerationDataByModel(String model, Locale locale) {

       final List<EnumerationBean> enumDataList = new ArrayList<EnumerationBean>();
       final List<Object> all = DaoUtils.getAll(flexibleSearchService, model);
       for (final Object object : all)
       {
           if (object instanceof WarehouseModel)
           {
               final WarehouseModel warehouse = (WarehouseModel) object;
               final EnumerationBean data = new EnumerationBean();
               if (warehouse.getName(locale) != null)
               {
                   data.setCode(warehouse.getCode());
                   data.setName(warehouse.getName(locale));
                   data.setPk(warehouse.getPk().getLongValueAsString());
                   enumDataList.add(data);
               }
           }
           if (object instanceof BaseStoreModel)
           {
               final BaseStoreModel storeModel = (BaseStoreModel) object;
               final EnumerationBean data = new EnumerationBean();
               if (storeModel.getName(locale) != null)
               {
                   data.setCode(storeModel.getUid());
                   data.setPk(storeModel.getPk().getLongValueAsString());
                   data.setName(storeModel.getName(locale));
                   enumDataList.add(data);
               }
           }
           if (object instanceof PointOfServiceModel)
           {
               final PointOfServiceModel pointOfService = (PointOfServiceModel) object;
               final EnumerationBean data = new EnumerationBean();
               data.setCode(pointOfService.getPk().getLongValueAsString());
               data.setPk(pointOfService.getPk().getLongValueAsString());
               data.setName(pointOfService.getName());
               enumDataList.add(data);
           }
           if (object instanceof CMSSiteModel)
           {
               final CMSSiteModel site = (CMSSiteModel) object;
               final EnumerationBean data = new EnumerationBean();
               data.setCode(site.getUid());
               data.setName(site.getName(Locale.CHINA));
               data.setPk(site.getPk().getLongValueAsString());
               enumDataList.add(data);
           }
           if (object instanceof StandardPaymentModeModel)
           {
               final StandardPaymentModeModel standardPaymentModeModel = (StandardPaymentModeModel) object;
               final EnumerationBean data = new EnumerationBean();
               data.setCode(standardPaymentModeModel.getCode());
               data.setPk(standardPaymentModeModel.getPk().getLongValueAsString());
               data.setName(standardPaymentModeModel.getName(locale));
               enumDataList.add(data);
           }
           if (object instanceof CountryModel)
           {
               final CountryModel country = (CountryModel) object;
               final EnumerationBean data = new EnumerationBean();
               data.setCode(country.getIsocode());
               data.setPk(country.getPk().getLongValueAsString());
               data.setName(country.getName(locale));
               enumDataList.add(data);
           }
           if (object instanceof RegionModel)
           {
               final RegionModel com = (RegionModel) object;
               final EnumerationBean data = new EnumerationBean();
               data.setCode(com.getIsocode());
               data.setPk(com.getPk().getLongValueAsString());
               data.setName(com.getName(locale));
               enumDataList.add(data);
           }

           //下面可添加自己需要的枚举值Model
       }
       return enumDataList;
   }

   @Override
   public List<EnumerationBean> getEnumerationData(String typeCode) {

       //枚举值List
       List<EnumerationBean> enumDataList = new ArrayList<>();

       final List<Object> all = DaoUtils.getAll(flexibleSearchService, typeCode);
       for(final Object object : all)
       {
           if(object instanceof EnumerationValueModel)
           {
               enumDataList = this.getEnumerationDataByType(typeCode,Locale.CHINA);
               break;
           }
           else if(object instanceof ItemModel)
           {
               SearchResult<List> searchPageData = zddsEnumerationDao.getEnumerationListByModel(typeCode);
               Collection<List> collection = searchPageData.getResult();
               for (List list : collection) {
                   EnumerationBean data = new EnumerationBean();
                   data.setPk(list.get(0) == null ? "" : list.get(0).toString());
                   data.setCode(list.get(1) == null ? "" : list.get(1).toString());
                   data.setName(list.get(2) == null ? "" : list.get(2).toString());
                   enumDataList.add(data);
               }
               break;
           }
       }
       return enumDataList;
   }
}