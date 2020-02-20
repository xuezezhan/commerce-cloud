package com.zdds.facades.facades.account.populator;


import com.zdds.facades.model.MenuGroupModel;
import com.zdds.facades.utils.DateUtil;
import com.zddsop.data.AccountData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.commons.lang.StringUtils;

import java.util.Locale;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 13:08 2020/1/18
 * @since JDK 11
 */
public class AccountPopulator implements Populator<EmployeeModel, AccountData> {

    @Override
    public void populate(EmployeeModel source, AccountData target) throws ConversionException {
        target.setName(source.getName());
        target.setUid(source.getUid());
        target.setCreationTime(DateUtil.YMDHMSdateToString(source.getCreationtime()));
        if(source.isLoginDisabled()){
            target.setStatus("已停用");
        }else{
            target.setStatus("使用中");
        }

        String gorupName="";
        for(PrincipalGroupModel principalGroupModel:source.getGroups()){
            if(principalGroupModel instanceof MenuGroupModel){
                gorupName=gorupName+principalGroupModel.getLocName(Locale.CHINA)+",";
            }
        }
        if(StringUtils.isNotEmpty(gorupName)) {
            target.setGroupName(gorupName.substring(0, gorupName.length() - 1));
        }
    }
}

