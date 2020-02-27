package com.zdds.core.bean;

import java.io.Serializable;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/8/15
 *@since  JDK 1.8
 */
public class EnumerationBean implements Serializable {

   private String pk;
   private String code;
   private String name;

   public String getPk() {
       return pk;
   }

   public void setPk(String pk) {
       this.pk = pk;
   }

   public String getCode() {
       return code;
   }

   public void setCode(String code) {
       this.code = code;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }
}
