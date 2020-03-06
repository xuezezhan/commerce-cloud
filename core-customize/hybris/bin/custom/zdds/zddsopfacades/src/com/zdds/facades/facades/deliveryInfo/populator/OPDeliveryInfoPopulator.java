package com.zdds.facades.facades.deliveryInfo.populator;

import com.zdds.core.model.DeliveryInfoModel;
import com.zddsop.data.OPDeliveryInfoData;
import com.zddsop.data.OPProductData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 9:37 2020/2/29
 * @since JDK 11
 */
public class OPDeliveryInfoPopulator implements Populator<DeliveryInfoModel, OPDeliveryInfoData> {

    @Resource(name = "opProductConverter")
    private Converter<ProductModel, OPProductData> opProductConverter;

    @Override
    public void populate(DeliveryInfoModel source, OPDeliveryInfoData target){
        target.setCarrierCode(source.getCarrier()==null?"":source.getCarrier().getCode());
        target.setCarrierName(source.getCarrier()==null?"":source.getCarrier().getName());
        target.setLogisticsNumber(source.getLogisticsNumber());
        if(CollectionUtils.isNotEmpty(source.getProducts())){
            target.setProducts(opProductConverter.convertAll(source.getProducts()));
        }
    }
}
