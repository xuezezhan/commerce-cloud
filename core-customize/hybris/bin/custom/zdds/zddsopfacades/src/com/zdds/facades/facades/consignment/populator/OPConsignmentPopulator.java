package com.zdds.facades.facades.consignment.populator;


import com.zdds.core.model.DeliveryInfoModel;
import com.zdds.core.util.DateTransferUtil;
import com.zddsop.data.OPConsignmentData;
import com.zddsop.data.OPDeliveryInfoData;
import com.zddsop.data.OPOrderData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.ordersplitting.model.ConsignmentModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 16:36 2020/2/25
 * @since JDK 11
 */
public class OPConsignmentPopulator implements Populator<ConsignmentModel, OPConsignmentData> {

    private static final Logger LOG = Logger.getLogger(OPConsignmentPopulator.class);
    @Autowired
    private EnumerationService enumerationService;

    @Resource(name = "opDeliveryInfoConverter")
    private Converter<DeliveryInfoModel, OPDeliveryInfoData> opDeliveryInfoConverter;

    @Resource(name = "opOrderConverter")
    private Converter<OrderModel, OPOrderData> opOrderConverter;

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void populate(final ConsignmentModel source, final OPConsignmentData target)
    {
        target.setPk(source.getPk().getLongValueAsString());
        target.setCode(source.getCode());
        target.setStatusName(enumerationService.getEnumerationName(source.getStatus(), Locale.CHINESE));
        if(CollectionUtils.isNotEmpty(source.getDeliveryInfoes())){
            target.setDeliveryInfoes(opDeliveryInfoConverter.convertAll(source.getDeliveryInfoes()));
        }

        if(source.getOrder()!=null && source.getOrder() instanceof OrderModel){
            OrderModel orderModel = (OrderModel)source.getOrder();
            target.setOrderData(opOrderConverter.convert(orderModel));
        }
    }
}