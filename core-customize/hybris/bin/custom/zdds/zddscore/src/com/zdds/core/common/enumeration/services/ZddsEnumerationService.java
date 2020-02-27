package com.zdds.core.common.enumeration.services;



import com.zdds.core.bean.EnumerationBean;

import java.util.List;
import java.util.Locale;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/8/15
 *@since  JDK 1.8
 */
public interface ZddsEnumerationService {

   /**
    * 根据枚举值type获取枚举值list
    * @param type
    * @param locale
    * @return
    */
   List<EnumerationBean> getEnumerationDataByType(String type, Locale locale);

   /**
    * 根据枚举值type和枚举值code获取枚举值
    * @param type
    * @param locale
    * @param code
    * @return
    */
   EnumerationBean getOne(String type, Locale locale, final String code);

   /**
    * 根据model获取枚举值list
    * @param model
    * @param locale
    * @return
    */
   List<EnumerationBean> getEnumerationDataByModel(String model, Locale locale);


   /**
    * 根据code获取code和name,包括了（枚举值和枚举model）
    * @param typeCode
    * @return
    */
   List<EnumerationBean> getEnumerationData(final String typeCode);

}
