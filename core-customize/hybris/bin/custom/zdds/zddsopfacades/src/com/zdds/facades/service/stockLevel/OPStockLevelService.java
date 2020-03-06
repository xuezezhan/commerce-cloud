package com.zdds.facades.service.stockLevel;

import de.hybris.platform.ordersplitting.model.WarehouseModel;
import de.hybris.platform.stock.impl.StockLevelDao;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 17:35 2020/3/4
 * @since JDK 11
 */
public interface OPStockLevelService {

    /**
     * 获取可用库存
     * @param productCode
     * @return
     */
    Integer getAvailableQuantity(String productCode);
}
