package com.zdds.facades.facades.consignment.impl;


import com.zdds.facades.facades.consignment.OPConsignmentFacade;
import com.zdds.facades.service.consignment.OPConsignmentService;
import com.zdds.facades.utils.ControllerPageUtil;
import com.zddsop.data.OPConsignmentData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.PK;
import de.hybris.platform.ordersplitting.model.ConsignmentModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 16:35 2020/2/25
 * @since JDK 11
 */
@Service(value = "opConsignmentFacade")
public class OPConsignmentFacadeImpl implements OPConsignmentFacade {


    @Resource
    private ModelService modelService;

    @Resource(name = "opConsignmentService")
    private OPConsignmentService opConsignmentService;

    @Resource(name = "opConsignmentConverter")
    private Converter<ConsignmentModel, OPConsignmentData> opConsignmentConverter;

    /**
     * 分页查询发货单
     *
     * @param params
     * @param pageableData
     * @return
     */
    @Override
    public SearchPageData searchConsignment(final Map<String, Object> params, final PageableData pageableData) {
        final SearchPageData searchPageData = opConsignmentService.searchConsignment(params, pageableData);
        return ControllerPageUtil.convertPageData(searchPageData, opConsignmentConverter);
    }

    @Override
    public OPConsignmentData searchConsignmentInfoForPk(String pk) {
        final ConsignmentModel consignmentModel = modelService.get(PK.fromLong(Long.parseLong(pk)));
        return opConsignmentConverter.convert(consignmentModel);
    }
}