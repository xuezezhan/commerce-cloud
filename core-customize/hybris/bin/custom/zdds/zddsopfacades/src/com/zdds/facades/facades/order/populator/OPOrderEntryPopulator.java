package com.zdds.facades.facades.order.populator;

import com.zdds.facades.service.stockLevel.OPStockLevelService;
import com.zddsop.data.OPOrderEntryData;
import com.zddsop.data.OPProductData;
import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 22:00 2020/3/1
 * @since JDK 11
 */
public class OPOrderEntryPopulator implements Populator<OrderEntryModel, OPOrderEntryData> {

    @Resource(name = "opProductConverter")
    private Converter<ProductModel, OPProductData> opProductConverter;

    @Resource(name = "commonI18NService")
    private CommonI18NService commonI18NService;
    @Resource
    private PriceDataFactory priceDataFactory;
    @Resource
    private OPStockLevelService opStockLevelService;

    @Override
    public void populate(OrderEntryModel source, OPOrderEntryData target) throws ConversionException {
        target.setPk(source.getPk().getLongValueAsString());

        Double salesPrice = 0D;
        if(source.getProduct()!=null){
            target.setProduct(opProductConverter.convert(source.getProduct()));

            if(CollectionUtils.isNotEmpty(source.getProduct().getEurope1Prices())){
                for (PriceRowModel priceRowModel:source.getProduct().getEurope1Prices()){
                    if(priceRowModel.getUg()!=null && priceRowModel.getUg().getCode().equalsIgnoreCase("SALES") && priceRowModel.getPrice()!=null){
                        salesPrice = priceRowModel.getPrice();
                        break;
                    }
                }
            }
        }
        target.setQuantity(source.getQuantity() == null ? "" : String.valueOf(source.getQuantity()));
        target.setStockLevel(String.valueOf(opStockLevelService.getAvailableQuantity(source.getProduct().getCode())));

        target.setSubSalesPrice(createPriceData(salesPrice*source.getQuantity()));
    }

    private PriceData createPriceData(Double value) {
        if(null == value){
            value = 0D;
        }
        return priceDataFactory.create(PriceDataType.BUY, new BigDecimal(value), commonI18NService.getCurrentCurrency());
    }
}
