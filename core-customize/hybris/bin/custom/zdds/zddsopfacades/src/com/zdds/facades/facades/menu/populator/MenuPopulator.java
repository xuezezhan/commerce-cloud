package com.zdds.facades.facades.menu.populator;


import com.zdds.facades.model.OperationMenuModel;
import com.zddsop.data.MenuData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Locale;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 13:09 2020/1/18
 * @since JDK 11
 */
public class MenuPopulator implements Populator<OperationMenuModel, MenuData> {
    @Override
    public void populate(OperationMenuModel source, MenuData target) throws ConversionException {
        target.setUid(source.getUid());
        target.setName(source.getLocName(Locale.CHINA));
        target.setFile(source.getFile());
        target.setPid(source.getPId());
    }
}
