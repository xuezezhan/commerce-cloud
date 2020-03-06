package com.zdds.facades.service.product;

import com.zdds.core.form.ProductForm;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;

import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 20:33 2020/3/5
 * @since JDK 11
 */
public interface OPProductService {

    /**
     * 保存或提交商品数据
     * @param productForm
     * @return
     */
    Boolean saveOrSubmitProduct(final ProductForm productForm);

    /**
     * 分页查询发货单
     * @param params
     * @param pageableData
     * @return
     */
    SearchPageData searchProduct(Map<String, Object> params, PageableData pageableData);
}
