package com.zdds.facades.facades.product.populator;

import com.zddsop.data.OPProductData;
import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 21:46 2020/2/29
 * @since JDK 11
 */
public class OPProductPopulator implements Populator<ProductModel, OPProductData> {

    @Resource(name = "commonI18NService")
    private CommonI18NService commonI18NService;
    @Resource
    private PriceDataFactory priceDataFactory;

    @Override
    public void populate(ProductModel source, OPProductData target) throws ConversionException {
        target.setCode(source.getCode());
        target.setName(source.getName());
        if(CollectionUtils.isNotEmpty(source.getNormal())){
            List<MediaModel> normalMedias = new ArrayList<>(source.getNormal());
            target.setNormalMedia(normalMedias.get(0).getURL());
        }
        target.setModel(source.getModel());

        Double salesPrice = 0D;
        if(CollectionUtils.isNotEmpty(source.getEurope1Prices())){
            for (PriceRowModel priceRowModel:source.getEurope1Prices()){
                if(priceRowModel.getUg()!=null && priceRowModel.getUg().getCode().equalsIgnoreCase("SALES") && priceRowModel.getPrice()!=null){
                    salesPrice = priceRowModel.getPrice();
                    break;
                }
            }
        }
        target.setSalesPrice(createPriceData(salesPrice));
    }

    private PriceData createPriceData(Double value) {
        if(null == value){
            value = 0D;
        }
        return priceDataFactory.create(PriceDataType.BUY, new BigDecimal(value), commonI18NService.getCurrentCurrency());
    }
}
