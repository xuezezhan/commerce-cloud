package com.zdds.facades.service.stockLevel.impl;

import com.zdds.core.util.DaoUtils;
import com.zdds.facades.service.stockLevel.OPStockLevelService;
import de.hybris.platform.ordersplitting.model.WarehouseModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.stock.impl.StockLevelDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 17:35 2020/3/4
 * @since JDK 11
 */
@Service(value = "opStockLevelService")
public class OPStockLevelServiceImpl implements OPStockLevelService {
    @Resource
    private StockLevelDao stockLevelDao;
    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Override
    public Integer getAvailableQuantity(String productCode) {
        WarehouseModel warehouseModel = DaoUtils.getUnique(flexibleSearchService,WarehouseModel._TYPECODE,WarehouseModel.CODE,"Default");
        return stockLevelDao.getAvailableQuantity(warehouseModel,productCode);
    }
}
