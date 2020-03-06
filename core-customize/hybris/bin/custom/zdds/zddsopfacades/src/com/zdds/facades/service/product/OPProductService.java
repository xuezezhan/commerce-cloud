package com.zdds.facades.service.product;

import com.zdds.core.form.ProductForm;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 20:33 2020/3/5
 * @since JDK 11
 */
public interface OPProductService {

    Boolean saveOrSubmitProduct(final ProductForm productForm);
}
