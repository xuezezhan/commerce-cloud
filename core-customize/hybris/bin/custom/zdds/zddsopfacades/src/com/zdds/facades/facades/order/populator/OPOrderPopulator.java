package com.zdds.facades.facades.order.populator;

import com.zdds.core.util.DateTransferUtil;
import com.zddsop.data.OPOrderData;
import com.zddsop.data.OPOrderEntryData;
import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 21:40 2020/2/29
 * @since JDK 11
 */
public class OPOrderPopulator implements Populator<OrderModel, OPOrderData> {

    @Resource(name = "commonI18NService")
    private CommonI18NService commonI18NService;
    @Resource
    private PriceDataFactory priceDataFactory;

    @Resource(name = "addressConverter")
    private Converter<AddressModel, AddressData> addressConverter;

    @Resource(name = "opOrderEntryConverter")
    private Converter<OrderEntryModel, OPOrderEntryData> opOrderEntryConverter;

    @Override
    public void populate(OrderModel source, OPOrderData target) throws ConversionException {
        target.setPk(source.getPk().getLongValueAsString());
        target.setCode(source.getCode());
        target.setCreationTime(DateTransferUtil.datetime2String(source.getCreationtime()));
        target.setName(source.getUser()==null?"":source.getUser().getDisplayName(Locale.CHINESE));
        if(source.getUser() !=null && source.getUser() instanceof CustomerModel){
            CustomerModel customerModel = (CustomerModel) source.getUser();
            target.setRealName(customerModel.getRealName());
            target.setPhone(customerModel.getPhone());
        }
        if(source instanceof OrderModel){
            OrderModel orderModel = (OrderModel)source;
            target.setRemark(orderModel.getRemark());
        }
        if(source.getDeliveryAddress()!=null){
            target.setAddress(addressConverter.convert(source.getDeliveryAddress()));
        }

        Double totalSalesPrice = 0D;
        if(CollectionUtils.isNotEmpty(source.getEntries())){
            List<OrderEntryModel> orderEntryModelList = new ArrayList<>();
            source.getEntries().stream().forEach(entry->{
                if(entry instanceof OrderEntryModel){
                    orderEntryModelList.add((OrderEntryModel)entry);
                }
            });
            if(CollectionUtils.isNotEmpty(orderEntryModelList)){
                target.setEntries(opOrderEntryConverter.convertAll(orderEntryModelList));
            }

            for (OrderEntryModel orderEntryModel:orderEntryModelList){
                Double salePrice = 0D;
                if(orderEntryModel.getProduct()!=null){
                    if(CollectionUtils.isNotEmpty(orderEntryModel.getProduct().getEurope1Prices())){
                        for (PriceRowModel priceRowModel:orderEntryModel.getProduct().getEurope1Prices()){
                            if(priceRowModel.getUg()!=null && priceRowModel.getUg().getCode().equalsIgnoreCase("SALES") && priceRowModel.getPrice()!=null){
                                salePrice = priceRowModel.getPrice();
                                break;
                            }
                        }
                    }
                }
                totalSalesPrice += salePrice*orderEntryModel.getQuantity();
            }
        }
        target.setTotalSalesPrice(createPriceData(totalSalesPrice));
    }

    private PriceData createPriceData(Double value) {
        if(null == value){
            value = 0D;
        }
        return priceDataFactory.create(PriceDataType.BUY, new BigDecimal(value), commonI18NService.getCurrentCurrency());
    }
}
