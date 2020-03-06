package com.zdds.core.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 17:29 2020/3/5
 * @since JDK 11
 */
public class ResultDTO<T> implements Serializable {

   private int code;
   private T datas;
   private String msg;
   private boolean success;
   private Integer total;
   private Map<String,String> sortInfo;
   private String status;

   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status;
   }

   public Integer getTotal() {
       return total;
   }

   public void setTotal(Integer total) {
       this.total = total;
   }

   public Map<String, String> getSortInfo() {
       return sortInfo;
   }

   public void setSortInfo(Map<String, String> sortInfo) {
       this.sortInfo = sortInfo;
   }

   public ResultDTO() {
   }

   public void setMsg(String msg) {
       this.msg = msg;
   }

   public int getCode() {
       return code;
   }

   public void setCode(int code) {
       this.code = code;
   }

   public String getMsg() {
       return msg;
   }

   public boolean isSuccess() {
       return success;
   }

   public void setSuccess(boolean success) {
       this.success = success;
   }

   public T getDatas() {
       return datas;
   }

   public void setDatas(T datas) {
       this.datas = datas;
   }
}
