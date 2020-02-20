/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年2月20日 下午9:34:00                        ---
 * ----------------------------------------------------------------
 */
package com.zdds.facades.jalo;

import com.zdds.facades.constants.ZddsopfacadesConstants;
import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.Employee;
import de.hybris.platform.jalo.user.UserGroup;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type OperationMenu.
 */
@SLDSafe
@SuppressWarnings({"unused","cast"})
public class OperationMenu extends UserGroup
{
	/** Qualifier of the <code>OperationMenu.pId</code> attribute **/
	public static final String PID = "pId";
	/** Qualifier of the <code>OperationMenu.icon</code> attribute **/
	public static final String ICON = "icon";
	/** Qualifier of the <code>OperationMenu.file</code> attribute **/
	public static final String FILE = "file";
	/** Qualifier of the <code>OperationMenu.employees</code> attribute **/
	public static final String EMPLOYEES = "employees";
	/** Relation ordering override parameter constants for MenuToEmployee from ((zddsopfacades))*/
	protected static String MENUTOEMPLOYEE_SRC_ORDERED = "relation.MenuToEmployee.source.ordered";
	protected static String MENUTOEMPLOYEE_TGT_ORDERED = "relation.MenuToEmployee.target.ordered";
	/** Relation disable markmodifed parameter constants for MenuToEmployee from ((zddsopfacades))*/
	protected static String MENUTOEMPLOYEE_MARKMODIFIED = "relation.MenuToEmployee.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(UserGroup.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(PID, AttributeMode.INITIAL);
		tmp.put(ICON, AttributeMode.INITIAL);
		tmp.put(FILE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.employees</code> attribute.
	 * @return the employees
	 */
	public List<Employee> getEmployees(final SessionContext ctx)
	{
		final List<Employee> items = getLinkedItems( 
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			"Employee",
			null,
			false,
			Utilities.getRelationOrderingOverride(MENUTOEMPLOYEE_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.employees</code> attribute.
	 * @return the employees
	 */
	public List<Employee> getEmployees()
	{
		return getEmployees( getSession().getSessionContext() );
	}
	
	public long getEmployeesCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			"Employee",
			null
		);
	}
	
	public long getEmployeesCount()
	{
		return getEmployeesCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.employees</code> attribute. 
	 * @param value the employees
	 */
	public void setEmployees(final SessionContext ctx, final List<Employee> value)
	{
		setLinkedItems( 
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			null,
			value,
			false,
			Utilities.getRelationOrderingOverride(MENUTOEMPLOYEE_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOEMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.employees</code> attribute. 
	 * @param value the employees
	 */
	public void setEmployees(final List<Employee> value)
	{
		setEmployees( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to employees. 
	 * @param value the item to add to employees
	 */
	public void addToEmployees(final SessionContext ctx, final Employee value)
	{
		addLinkedItems( 
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			null,
			Collections.singletonList(value),
			false,
			Utilities.getRelationOrderingOverride(MENUTOEMPLOYEE_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOEMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to employees. 
	 * @param value the item to add to employees
	 */
	public void addToEmployees(final Employee value)
	{
		addToEmployees( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from employees. 
	 * @param value the item to remove from employees
	 */
	public void removeFromEmployees(final SessionContext ctx, final Employee value)
	{
		removeLinkedItems( 
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			null,
			Collections.singletonList(value),
			false,
			Utilities.getRelationOrderingOverride(MENUTOEMPLOYEE_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOEMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from employees. 
	 * @param value the item to remove from employees
	 */
	public void removeFromEmployees(final Employee value)
	{
		removeFromEmployees( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.file</code> attribute.
	 * @return the file - file
	 */
	public String getFile(final SessionContext ctx)
	{
		return (String)getProperty( ctx, "file".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.file</code> attribute.
	 * @return the file - file
	 */
	public String getFile()
	{
		return getFile( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.file</code> attribute. 
	 * @param value the file - file
	 */
	public void setFile(final SessionContext ctx, final String value)
	{
		setProperty(ctx, "file".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.file</code> attribute. 
	 * @param value the file - file
	 */
	public void setFile(final String value)
	{
		setFile( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.icon</code> attribute.
	 * @return the icon - icon
	 */
	public String getIcon(final SessionContext ctx)
	{
		return (String)getProperty( ctx, "icon".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.icon</code> attribute.
	 * @return the icon - icon
	 */
	public String getIcon()
	{
		return getIcon( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.icon</code> attribute. 
	 * @param value the icon - icon
	 */
	public void setIcon(final SessionContext ctx, final String value)
	{
		setProperty(ctx, "icon".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.icon</code> attribute. 
	 * @param value the icon - icon
	 */
	public void setIcon(final String value)
	{
		setIcon( getSession().getSessionContext(), value );
	}
	
	@Override
	public boolean isMarkModifiedDisabled(final Item referencedItem)
	{
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Employee");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(MENUTOEMPLOYEE_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.pId</code> attribute.
	 * @return the pId - pid
	 */
	public String getPId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, "pId".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.pId</code> attribute.
	 * @return the pId - pid
	 */
	public String getPId()
	{
		return getPId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.pId</code> attribute. 
	 * @param value the pId - pid
	 */
	public void setPId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, "pId".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.pId</code> attribute. 
	 * @param value the pId - pid
	 */
	public void setPId(final String value)
	{
		setPId( getSession().getSessionContext(), value );
	}
	
}
