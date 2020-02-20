package com.zdds.backoffice.renderers;

import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;

import com.hybris.cockpitng.core.config.impl.jaxb.listview.ListColumn;
import com.hybris.cockpitng.dataaccess.facades.type.DataType;
import com.hybris.cockpitng.engine.WidgetInstanceManager;
import com.hybris.cockpitng.widgets.common.AbstractWidgetComponentRenderer;
import com.zdds.core.model.DepartmentModel;

/**
 * 组织结构-上级单位名称
 *
 * @author xuezezhan
 * @time 2020年2月20日 下午9:06:37
 * @since JDK 11.0
 */
public class SuperDepartmentNameRenderer extends AbstractWidgetComponentRenderer<Listcell, ListColumn, Object> {

	@Override
	public void render(final Listcell listcell, final ListColumn configuration, final Object data, final DataType dataType,
			final WidgetInstanceManager widgetInstanceManager)
	{
		String superDepartmentName = "";
		final DepartmentModel departmentModel = (DepartmentModel) data;
		final DepartmentModel superDepartment = departmentModel.getSuperDepartment();
		if (null != superDepartment)
		{
			superDepartmentName = superDepartment.getName();
		}
		listcell.appendChild(new Label(superDepartmentName));
	}

}



