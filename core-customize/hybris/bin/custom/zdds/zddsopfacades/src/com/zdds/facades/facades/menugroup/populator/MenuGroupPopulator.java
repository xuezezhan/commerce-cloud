package com.zdds.facades.facades.menugroup.populator;


import com.zdds.facades.model.MenuGroupModel;
import com.zddsop.data.MenuGroupData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Locale;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 13:10 2020/1/18
 * @since JDK 11
 */
public class MenuGroupPopulator implements Populator<MenuGroupModel, MenuGroupData> {
    @Override
    public void populate(MenuGroupModel source, MenuGroupData target) throws ConversionException {
        target.setUid(source.getUid());
        target.setName(source.getLocName(Locale.CHINA));
        target.setDescription(source.getDescription());
    }
}
