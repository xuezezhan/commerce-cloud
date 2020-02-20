/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年2月20日 下午9:34:00                        ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import com.zdds.core.jalo.Department;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Department}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedDepartment extends GenericItem
{
	/** Qualifier of the <code>Department.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>Department.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>Department.isReceipt</code> attribute **/
	public static final String ISRECEIPT = "isReceipt";
	/** Qualifier of the <code>Department.address</code> attribute **/
	public static final String ADDRESS = "address";
	/** Qualifier of the <code>Department.superDepartment</code> attribute **/
	public static final String SUPERDEPARTMENT = "superDepartment";
	/** Qualifier of the <code>Department.subDepartments</code> attribute **/
	public static final String SUBDEPARTMENTS = "subDepartments";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n SUPERDEPARTMENT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedDepartment> SUPERDEPARTMENTHANDLER = new BidirectionalOneToManyHandler<GeneratedDepartment>(
	ZddsCoreConstants.TC.DEPARTMENT,
	false,
	"superDepartment",
	null,
	false,
	true,
	CollectionType.LIST
	);
	/**
	* {@link OneToManyHandler} for handling 1:n SUBDEPARTMENTS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<Department> SUBDEPARTMENTSHANDLER = new OneToManyHandler<Department>(
	ZddsCoreConstants.TC.DEPARTMENT,
	false,
	"superDepartment",
	null,
	false,
	true,
	CollectionType.LIST
	).withRelationQualifier("subDepartments");
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(ISRECEIPT, AttributeMode.INITIAL);
		tmp.put(ADDRESS, AttributeMode.INITIAL);
		tmp.put(SUPERDEPARTMENT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.address</code> attribute.
	 * @return the address - 地址
	 */
	public Address getAddress(final SessionContext ctx)
	{
		return (Address)getProperty( ctx, ADDRESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.address</code> attribute.
	 * @return the address - 地址
	 */
	public Address getAddress()
	{
		return getAddress( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.address</code> attribute. 
	 * @param value the address - 地址
	 */
	public void setAddress(final SessionContext ctx, final Address value)
	{
		setProperty(ctx, ADDRESS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.address</code> attribute. 
	 * @param value the address - 地址
	 */
	public void setAddress(final Address value)
	{
		setAddress( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.code</code> attribute.
	 * @return the code - 单位编号
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.code</code> attribute.
	 * @return the code - 单位编号
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.code</code> attribute. 
	 * @param value the code - 单位编号
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.code</code> attribute. 
	 * @param value the code - 单位编号
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		SUPERDEPARTMENTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.isReceipt</code> attribute.
	 * @return the isReceipt - 是否可接单
	 */
	public Boolean isIsReceipt(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ISRECEIPT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.isReceipt</code> attribute.
	 * @return the isReceipt - 是否可接单
	 */
	public Boolean isIsReceipt()
	{
		return isIsReceipt( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.isReceipt</code> attribute. 
	 * @return the isReceipt - 是否可接单
	 */
	public boolean isIsReceiptAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isIsReceipt( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.isReceipt</code> attribute. 
	 * @return the isReceipt - 是否可接单
	 */
	public boolean isIsReceiptAsPrimitive()
	{
		return isIsReceiptAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.isReceipt</code> attribute. 
	 * @param value the isReceipt - 是否可接单
	 */
	public void setIsReceipt(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ISRECEIPT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.isReceipt</code> attribute. 
	 * @param value the isReceipt - 是否可接单
	 */
	public void setIsReceipt(final Boolean value)
	{
		setIsReceipt( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.isReceipt</code> attribute. 
	 * @param value the isReceipt - 是否可接单
	 */
	public void setIsReceipt(final SessionContext ctx, final boolean value)
	{
		setIsReceipt( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.isReceipt</code> attribute. 
	 * @param value the isReceipt - 是否可接单
	 */
	public void setIsReceipt(final boolean value)
	{
		setIsReceipt( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.name</code> attribute.
	 * @return the name - 单位名称
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.name</code> attribute.
	 * @return the name - 单位名称
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.name</code> attribute. 
	 * @param value the name - 单位名称
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.name</code> attribute. 
	 * @param value the name - 单位名称
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.subDepartments</code> attribute.
	 * @return the subDepartments
	 */
	public List<Department> getSubDepartments(final SessionContext ctx)
	{
		return (List<Department>)SUBDEPARTMENTSHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.subDepartments</code> attribute.
	 * @return the subDepartments
	 */
	public List<Department> getSubDepartments()
	{
		return getSubDepartments( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.subDepartments</code> attribute. 
	 * @param value the subDepartments
	 */
	public void setSubDepartments(final SessionContext ctx, final List<Department> value)
	{
		SUBDEPARTMENTSHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.subDepartments</code> attribute. 
	 * @param value the subDepartments
	 */
	public void setSubDepartments(final List<Department> value)
	{
		setSubDepartments( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to subDepartments. 
	 * @param value the item to add to subDepartments
	 */
	public void addToSubDepartments(final SessionContext ctx, final Department value)
	{
		SUBDEPARTMENTSHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to subDepartments. 
	 * @param value the item to add to subDepartments
	 */
	public void addToSubDepartments(final Department value)
	{
		addToSubDepartments( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from subDepartments. 
	 * @param value the item to remove from subDepartments
	 */
	public void removeFromSubDepartments(final SessionContext ctx, final Department value)
	{
		SUBDEPARTMENTSHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from subDepartments. 
	 * @param value the item to remove from subDepartments
	 */
	public void removeFromSubDepartments(final Department value)
	{
		removeFromSubDepartments( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.superDepartment</code> attribute.
	 * @return the superDepartment
	 */
	public Department getSuperDepartment(final SessionContext ctx)
	{
		return (Department)getProperty( ctx, SUPERDEPARTMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Department.superDepartment</code> attribute.
	 * @return the superDepartment
	 */
	public Department getSuperDepartment()
	{
		return getSuperDepartment( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.superDepartment</code> attribute. 
	 * @param value the superDepartment
	 */
	public void setSuperDepartment(final SessionContext ctx, final Department value)
	{
		SUPERDEPARTMENTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Department.superDepartment</code> attribute. 
	 * @param value the superDepartment
	 */
	public void setSuperDepartment(final Department value)
	{
		setSuperDepartment( getSession().getSessionContext(), value );
	}
	
}
