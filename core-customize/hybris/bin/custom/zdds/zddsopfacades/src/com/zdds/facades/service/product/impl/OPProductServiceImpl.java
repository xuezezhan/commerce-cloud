package com.zdds.facades.service.product.impl;

import com.zdds.core.form.ProductForm;
import com.zdds.core.util.LogUtil;
import com.zdds.facades.service.product.OPProductService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 20:34 2020/3/5
 * @since JDK 11
 */
@Service(value = "opProductService")
public class OPProductServiceImpl implements OPProductService {

    @Resource
    private ModelService modelService;

    @Override
    public Boolean saveOrSubmitProduct(ProductForm productForm) {
        try {
            ProductModel productModel = this.modelService.create(ProductModel.class);
            productModel.setName(productForm.getName());
            this.modelService.save(productModel);
            return Boolean.TRUE;
        }catch (Exception e){
            LogUtil.error(e.getMessage());
            return Boolean.FALSE;
        }
    }
}
