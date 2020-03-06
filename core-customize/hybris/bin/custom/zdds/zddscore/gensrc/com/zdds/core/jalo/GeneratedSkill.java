/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年3月4日 上午9:02:14                         ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.Employee;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Skill}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedSkill extends GenericItem
{
	/** Qualifier of the <code>Skill.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>Skill.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>Skill.employees</code> attribute **/
	public static final String EMPLOYEES = "employees";
	/** Relation ordering override parameter constants for Employee2Skill from ((zddscore))*/
	protected static String EMPLOYEE2SKILL_SRC_ORDERED = "relation.Employee2Skill.source.ordered";
	protected static String EMPLOYEE2SKILL_TGT_ORDERED = "relation.Employee2Skill.target.ordered";
	/** Relation disable markmodifed parameter constants for Employee2Skill from ((zddscore))*/
	protected static String EMPLOYEE2SKILL_MARKMODIFIED = "relation.Employee2Skill.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Skill.code</code> attribute.
	 * @return the code - 编号
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Skill.code</code> attribute.
	 * @return the code - 编号
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Skill.code</code> attribute. 
	 * @param value the code - 编号
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Skill.code</code> attribute. 
	 * @param value the code - 编号
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Skill.employees</code> attribute.
	 * @return the employees
	 */
	public Collection<Employee> getEmployees(final SessionContext ctx)
	{
		final List<Employee> items = getLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			"Employee",
			null,
			Utilities.getRelationOrderingOverride(EMPLOYEE2SKILL_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Skill.employees</code> attribute.
	 * @return the employees
	 */
	public Collection<Employee> getEmployees()
	{
		return getEmployees( getSession().getSessionContext() );
	}
	
	public long getEmployeesCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			"Employee",
			null
		);
	}
	
	public long getEmployeesCount()
	{
		return getEmployeesCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Skill.employees</code> attribute. 
	 * @param value the employees
	 */
	public void setEmployees(final SessionContext ctx, final Collection<Employee> value)
	{
		setLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			null,
			value,
			Utilities.getRelationOrderingOverride(EMPLOYEE2SKILL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(EMPLOYEE2SKILL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Skill.employees</code> attribute. 
	 * @param value the employees
	 */
	public void setEmployees(final Collection<Employee> value)
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
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(EMPLOYEE2SKILL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(EMPLOYEE2SKILL_MARKMODIFIED)
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
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(EMPLOYEE2SKILL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(EMPLOYEE2SKILL_MARKMODIFIED)
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
	
	@Override
	public boolean isMarkModifiedDisabled(final Item referencedItem)
	{
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Employee");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(EMPLOYEE2SKILL_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Skill.name</code> attribute.
	 * @return the name - 技能名称
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Skill.name</code> attribute.
	 * @return the name - 技能名称
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Skill.name</code> attribute. 
	 * @param value the name - 技能名称
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Skill.name</code> attribute. 
	 * @param value the name - 技能名称
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
}
