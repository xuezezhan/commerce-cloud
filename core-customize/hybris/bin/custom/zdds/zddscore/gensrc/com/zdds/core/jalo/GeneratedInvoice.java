/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年3月6日 下午2:06:55                         ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Invoice}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedInvoice extends GenericItem
{
	/** Qualifier of the <code>Invoice.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>Invoice.type</code> attribute **/
	public static final String TYPE = "type";
	/** Qualifier of the <code>Invoice.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>Invoice.number</code> attribute **/
	public static final String NUMBER = "number";
	/** Qualifier of the <code>Invoice.bank</code> attribute **/
	public static final String BANK = "bank";
	/** Qualifier of the <code>Invoice.address</code> attribute **/
	public static final String ADDRESS = "address";
	/** Qualifier of the <code>Invoice.phone</code> attribute **/
	public static final String PHONE = "phone";
	/** Qualifier of the <code>Invoice.account</code> attribute **/
	public static final String ACCOUNT = "account";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(TYPE, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(NUMBER, AttributeMode.INITIAL);
		tmp.put(BANK, AttributeMode.INITIAL);
		tmp.put(ADDRESS, AttributeMode.INITIAL);
		tmp.put(PHONE, AttributeMode.INITIAL);
		tmp.put(ACCOUNT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.account</code> attribute.
	 * @return the account - 银行账户
	 */
	public String getAccount(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ACCOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.account</code> attribute.
	 * @return the account - 银行账户
	 */
	public String getAccount()
	{
		return getAccount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.account</code> attribute. 
	 * @param value the account - 银行账户
	 */
	public void setAccount(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ACCOUNT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.account</code> attribute. 
	 * @param value the account - 银行账户
	 */
	public void setAccount(final String value)
	{
		setAccount( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.address</code> attribute.
	 * @return the address - 单位地址
	 */
	public String getAddress(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ADDRESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.address</code> attribute.
	 * @return the address - 单位地址
	 */
	public String getAddress()
	{
		return getAddress( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.address</code> attribute. 
	 * @param value the address - 单位地址
	 */
	public void setAddress(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ADDRESS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.address</code> attribute. 
	 * @param value the address - 单位地址
	 */
	public void setAddress(final String value)
	{
		setAddress( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.bank</code> attribute.
	 * @return the bank - 开户银行
	 */
	public String getBank(final SessionContext ctx)
	{
		return (String)getProperty( ctx, BANK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.bank</code> attribute.
	 * @return the bank - 开户银行
	 */
	public String getBank()
	{
		return getBank( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.bank</code> attribute. 
	 * @param value the bank - 开户银行
	 */
	public void setBank(final SessionContext ctx, final String value)
	{
		setProperty(ctx, BANK,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.bank</code> attribute. 
	 * @param value the bank - 开户银行
	 */
	public void setBank(final String value)
	{
		setBank( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.code</code> attribute.
	 * @return the code - 编号
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.code</code> attribute.
	 * @return the code - 编号
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.code</code> attribute. 
	 * @param value the code - 编号
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.code</code> attribute. 
	 * @param value the code - 编号
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.name</code> attribute.
	 * @return the name - 发票抬头
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.name</code> attribute.
	 * @return the name - 发票抬头
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.name</code> attribute. 
	 * @param value the name - 发票抬头
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.name</code> attribute. 
	 * @param value the name - 发票抬头
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.number</code> attribute.
	 * @return the number - 税号
	 */
	public String getNumber(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.number</code> attribute.
	 * @return the number - 税号
	 */
	public String getNumber()
	{
		return getNumber( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.number</code> attribute. 
	 * @param value the number - 税号
	 */
	public void setNumber(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NUMBER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.number</code> attribute. 
	 * @param value the number - 税号
	 */
	public void setNumber(final String value)
	{
		setNumber( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.phone</code> attribute.
	 * @return the phone - 电话号码
	 */
	public String getPhone(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.phone</code> attribute.
	 * @return the phone - 电话号码
	 */
	public String getPhone()
	{
		return getPhone( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.phone</code> attribute. 
	 * @param value the phone - 电话号码
	 */
	public void setPhone(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PHONE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.phone</code> attribute. 
	 * @param value the phone - 电话号码
	 */
	public void setPhone(final String value)
	{
		setPhone( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.type</code> attribute.
	 * @return the type - 发票类型
	 */
	public EnumerationValue getType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Invoice.type</code> attribute.
	 * @return the type - 发票类型
	 */
	public EnumerationValue getType()
	{
		return getType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.type</code> attribute. 
	 * @param value the type - 发票类型
	 */
	public void setType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, TYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Invoice.type</code> attribute. 
	 * @param value the type - 发票类型
	 */
	public void setType(final EnumerationValue value)
	{
		setType( getSession().getSessionContext(), value );
	}
	
}
