package com.zdds.facades.facades.consignment.populator;


import com.zdds.core.util.DateTransferUtil;
import com.zddsop.data.OPConsignmentData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.ordersplitting.model.ConsignmentModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void populate(final ConsignmentModel source, final OPConsignmentData target)
    {
        target.setPk(source.getPk().getLongValueAsString());
        target.setCode(source.getCode());
        target.setOrderCode(source.getOrder()==null?"":source.getOrder().getCode());
        target.setStatusName(enumerationService.getEnumerationName(source.getStatus(), Locale.CHINESE));
        target.setCreationTime(source.getOrder()==null?"": DateTransferUtil.datetime2String(source.getOrder().getCreationtime()));
        target.setName(source.getOrder()==null?"":source.getOrder().getUser()==null?"":source.getOrder().getUser().getDisplayName(Locale.CHINESE));
        if(source.getOrder() !=null && source.getOrder().getUser() !=null && source.getOrder().getUser() instanceof CustomerModel){
            CustomerModel customerModel = (CustomerModel) source.getOrder().getUser();
            target.setRealName(customerModel.getRealName());
            target.setPhone(customerModel.getPhone());
        }
        if(source.getOrder()!=null && source.getOrder() instanceof OrderModel){
            OrderModel orderModel = (OrderModel)source.getOrder();
            target.setRemark(orderModel.getRemark());
        }
    }
}