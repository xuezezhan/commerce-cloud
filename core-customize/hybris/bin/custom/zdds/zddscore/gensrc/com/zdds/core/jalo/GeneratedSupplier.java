/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年2月25日 下午8:28:52                        ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import com.zdds.core.jalo.SettleIn;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.jalo.user.Employee;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.user.Employee Supplier}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedSupplier extends Employee
{
	/** Qualifier of the <code>Supplier.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>Supplier.contact</code> attribute **/
	public static final String CONTACT = "contact";
	/** Qualifier of the <code>Supplier.phone</code> attribute **/
	public static final String PHONE = "phone";
	/** Qualifier of the <code>Supplier.QQ</code> attribute **/
	public static final String QQ = "QQ";
	/** Qualifier of the <code>Supplier.settleIn</code> attribute **/
	public static final String SETTLEIN = "settleIn";
	/** Qualifier of the <code>Supplier.address</code> attribute **/
	public static final String ADDRESS = "address";
	/** Qualifier of the <code>Supplier.isSupplier</code> attribute **/
	public static final String ISSUPPLIER = "isSupplier";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Employee.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(CONTACT, AttributeMode.INITIAL);
		tmp.put(PHONE, AttributeMode.INITIAL);
		tmp.put(QQ, AttributeMode.INITIAL);
		tmp.put(SETTLEIN, AttributeMode.INITIAL);
		tmp.put(ADDRESS, AttributeMode.INITIAL);
		tmp.put(ISSUPPLIER, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.address</code> attribute.
	 * @return the address - 地址
	 */
	public Address getAddress(final SessionContext ctx)
	{
		return (Address)getProperty( ctx, ADDRESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.address</code> attribute.
	 * @return the address - 地址
	 */
	public Address getAddress()
	{
		return getAddress( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.address</code> attribute. 
	 * @param value the address - 地址
	 */
	public void setAddress(final SessionContext ctx, final Address value)
	{
		setProperty(ctx, ADDRESS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.address</code> attribute. 
	 * @param value the address - 地址
	 */
	public void setAddress(final Address value)
	{
		setAddress( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.code</code> attribute.
	 * @return the code - 供应商编号
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.code</code> attribute.
	 * @return the code - 供应商编号
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.code</code> attribute. 
	 * @param value the code - 供应商编号
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.code</code> attribute. 
	 * @param value the code - 供应商编号
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.contact</code> attribute.
	 * @return the contact - 联系人
	 */
	public String getContact(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONTACT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.contact</code> attribute.
	 * @return the contact - 联系人
	 */
	public String getContact()
	{
		return getContact( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.contact</code> attribute. 
	 * @param value the contact - 联系人
	 */
	public void setContact(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CONTACT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.contact</code> attribute. 
	 * @param value the contact - 联系人
	 */
	public void setContact(final String value)
	{
		setContact( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.isSupplier</code> attribute.
	 * @return the isSupplier - 是否为供应商
	 */
	public Boolean isIsSupplier(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ISSUPPLIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.isSupplier</code> attribute.
	 * @return the isSupplier - 是否为供应商
	 */
	public Boolean isIsSupplier()
	{
		return isIsSupplier( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.isSupplier</code> attribute. 
	 * @return the isSupplier - 是否为供应商
	 */
	public boolean isIsSupplierAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isIsSupplier( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.isSupplier</code> attribute. 
	 * @return the isSupplier - 是否为供应商
	 */
	public boolean isIsSupplierAsPrimitive()
	{
		return isIsSupplierAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.isSupplier</code> attribute. 
	 * @param value the isSupplier - 是否为供应商
	 */
	public void setIsSupplier(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ISSUPPLIER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.isSupplier</code> attribute. 
	 * @param value the isSupplier - 是否为供应商
	 */
	public void setIsSupplier(final Boolean value)
	{
		setIsSupplier( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.isSupplier</code> attribute. 
	 * @param value the isSupplier - 是否为供应商
	 */
	public void setIsSupplier(final SessionContext ctx, final boolean value)
	{
		setIsSupplier( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.isSupplier</code> attribute. 
	 * @param value the isSupplier - 是否为供应商
	 */
	public void setIsSupplier(final boolean value)
	{
		setIsSupplier( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.phone</code> attribute.
	 * @return the phone - 座机电话
	 */
	public String getPhone(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.phone</code> attribute.
	 * @return the phone - 座机电话
	 */
	public String getPhone()
	{
		return getPhone( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.phone</code> attribute. 
	 * @param value the phone - 座机电话
	 */
	public void setPhone(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PHONE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.phone</code> attribute. 
	 * @param value the phone - 座机电话
	 */
	public void setPhone(final String value)
	{
		setPhone( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.QQ</code> attribute.
	 * @return the QQ - QQ
	 */
	public String getQQ(final SessionContext ctx)
	{
		return (String)getProperty( ctx, QQ);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.QQ</code> attribute.
	 * @return the QQ - QQ
	 */
	public String getQQ()
	{
		return getQQ( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.QQ</code> attribute. 
	 * @param value the QQ - QQ
	 */
	public void setQQ(final SessionContext ctx, final String value)
	{
		setProperty(ctx, QQ,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.QQ</code> attribute. 
	 * @param value the QQ - QQ
	 */
	public void setQQ(final String value)
	{
		setQQ( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.settleIn</code> attribute.
	 * @return the settleIn - 入驻信息
	 */
	public SettleIn getSettleIn(final SessionContext ctx)
	{
		return (SettleIn)getProperty( ctx, SETTLEIN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Supplier.settleIn</code> attribute.
	 * @return the settleIn - 入驻信息
	 */
	public SettleIn getSettleIn()
	{
		return getSettleIn( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.settleIn</code> attribute. 
	 * @param value the settleIn - 入驻信息
	 */
	public void setSettleIn(final SessionContext ctx, final SettleIn value)
	{
		setProperty(ctx, SETTLEIN,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Supplier.settleIn</code> attribute. 
	 * @param value the settleIn - 入驻信息
	 */
	public void setSettleIn(final SettleIn value)
	{
		setSettleIn( getSession().getSessionContext(), value );
	}
	
}
