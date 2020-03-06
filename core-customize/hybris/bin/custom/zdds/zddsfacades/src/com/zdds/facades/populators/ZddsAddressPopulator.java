package com.zdds.facades.populators;


import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 22:11 2020/2/28
 * @since JDK 11
 */

public class ZddsAddressPopulator implements Populator<AddressModel, AddressData> {

    @Override
    public void populate(final AddressModel source, final AddressData target) throws ConversionException {
        target.setStreetName(source.getStreetname());
    }
}
