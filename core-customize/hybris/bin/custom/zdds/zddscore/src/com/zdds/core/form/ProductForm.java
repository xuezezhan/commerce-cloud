package com.zdds.core.form;

import java.io.Serializable;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 18:06 2020/3/5
 * @since JDK 11
 */
public class ProductForm implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
