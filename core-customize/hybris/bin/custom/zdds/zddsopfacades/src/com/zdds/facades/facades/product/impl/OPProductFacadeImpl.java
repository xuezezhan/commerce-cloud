package com.zdds.facades.facades.product.impl;

import com.zdds.facades.facades.product.OPProductFacade;
import com.zdds.facades.service.product.OPProductService;
import com.zdds.facades.utils.ControllerPageUtil;
import com.zddsop.data.OPProductData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 23:08 2020/3/5
 * @since JDK 11
 */
@Service(value = "opProductFacade")
public class OPProductFacadeImpl implements OPProductFacade {

    @Resource
    private OPProductService opProductService;

    @Resource(name = "opProductConverter")
    private Converter<ProductModel, OPProductData> opProductConverter;

    @Override
    public SearchPageData searchProduct(Map<String, Object> params, PageableData pageableData) {
        final SearchPageData searchPageData = opProductService.searchProduct(params, pageableData);
        return ControllerPageUtil.convertPageData(searchPageData, opProductConverter);
    }
}
