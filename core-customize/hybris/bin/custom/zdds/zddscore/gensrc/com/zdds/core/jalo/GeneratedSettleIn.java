/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年3月6日 下午2:06:55                         ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import de.hybris.platform.category.jalo.Category;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem SettleIn}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedSettleIn extends GenericItem
{
	/** Qualifier of the <code>SettleIn.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>SettleIn.contactName</code> attribute **/
	public static final String CONTACTNAME = "contactName";
	/** Qualifier of the <code>SettleIn.contactPhone</code> attribute **/
	public static final String CONTACTPHONE = "contactPhone";
	/** Qualifier of the <code>SettleIn.blType</code> attribute **/
	public static final String BLTYPE = "blType";
	/** Qualifier of the <code>SettleIn.companyName</code> attribute **/
	public static final String COMPANYNAME = "companyName";
	/** Qualifier of the <code>SettleIn.blNumber</code> attribute **/
	public static final String BLNUMBER = "blNumber";
	/** Qualifier of the <code>SettleIn.legalRepresentative</code> attribute **/
	public static final String LEGALREPRESENTATIVE = "legalRepresentative";
	/** Qualifier of the <code>SettleIn.blLocal</code> attribute **/
	public static final String BLLOCAL = "blLocal";
	/** Qualifier of the <code>SettleIn.setupDate</code> attribute **/
	public static final String SETUPDATE = "setupDate";
	/** Qualifier of the <code>SettleIn.startDate</code> attribute **/
	public static final String STARTDATE = "startDate";
	/** Qualifier of the <code>SettleIn.endDate</code> attribute **/
	public static final String ENDDATE = "endDate";
	/** Qualifier of the <code>SettleIn.brands</code> attribute **/
	public static final String BRANDS = "brands";
	/** Qualifier of the <code>SettleIn.categories</code> attribute **/
	public static final String CATEGORIES = "categories";
	/** Relation ordering override parameter constants for SettleIn2Category from ((zddscore))*/
	protected static String SETTLEIN2CATEGORY_SRC_ORDERED = "relation.SettleIn2Category.source.ordered";
	protected static String SETTLEIN2CATEGORY_TGT_ORDERED = "relation.SettleIn2Category.target.ordered";
	/** Relation disable markmodifed parameter constants for SettleIn2Category from ((zddscore))*/
	protected static String SETTLEIN2CATEGORY_MARKMODIFIED = "relation.SettleIn2Category.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(CONTACTNAME, AttributeMode.INITIAL);
		tmp.put(CONTACTPHONE, AttributeMode.INITIAL);
		tmp.put(BLTYPE, AttributeMode.INITIAL);
		tmp.put(COMPANYNAME, AttributeMode.INITIAL);
		tmp.put(BLNUMBER, AttributeMode.INITIAL);
		tmp.put(LEGALREPRESENTATIVE, AttributeMode.INITIAL);
		tmp.put(BLLOCAL, AttributeMode.INITIAL);
		tmp.put(SETUPDATE, AttributeMode.INITIAL);
		tmp.put(STARTDATE, AttributeMode.INITIAL);
		tmp.put(ENDDATE, AttributeMode.INITIAL);
		tmp.put(BRANDS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.blLocal</code> attribute.
	 * @return the blLocal - 营业执照所在地
	 */
	public Address getBlLocal(final SessionContext ctx)
	{
		return (Address)getProperty( ctx, BLLOCAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.blLocal</code> attribute.
	 * @return the blLocal - 营业执照所在地
	 */
	public Address getBlLocal()
	{
		return getBlLocal( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.blLocal</code> attribute. 
	 * @param value the blLocal - 营业执照所在地
	 */
	public void setBlLocal(final SessionContext ctx, final Address value)
	{
		setProperty(ctx, BLLOCAL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.blLocal</code> attribute. 
	 * @param value the blLocal - 营业执照所在地
	 */
	public void setBlLocal(final Address value)
	{
		setBlLocal( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.blNumber</code> attribute.
	 * @return the blNumber - 营业执照注册号
	 */
	public String getBlNumber(final SessionContext ctx)
	{
		return (String)getProperty( ctx, BLNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.blNumber</code> attribute.
	 * @return the blNumber - 营业执照注册号
	 */
	public String getBlNumber()
	{
		return getBlNumber( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.blNumber</code> attribute. 
	 * @param value the blNumber - 营业执照注册号
	 */
	public void setBlNumber(final SessionContext ctx, final String value)
	{
		setProperty(ctx, BLNUMBER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.blNumber</code> attribute. 
	 * @param value the blNumber - 营业执照注册号
	 */
	public void setBlNumber(final String value)
	{
		setBlNumber( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.blType</code> attribute.
	 * @return the blType - 营业执照类型
	 */
	public EnumerationValue getBlType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, BLTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.blType</code> attribute.
	 * @return the blType - 营业执照类型
	 */
	public EnumerationValue getBlType()
	{
		return getBlType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.blType</code> attribute. 
	 * @param value the blType - 营业执照类型
	 */
	public void setBlType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, BLTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.blType</code> attribute. 
	 * @param value the blType - 营业执照类型
	 */
	public void setBlType(final EnumerationValue value)
	{
		setBlType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.brands</code> attribute.
	 * @return the brands - 经营品牌
	 */
	public String getBrands(final SessionContext ctx)
	{
		return (String)getProperty( ctx, BRANDS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.brands</code> attribute.
	 * @return the brands - 经营品牌
	 */
	public String getBrands()
	{
		return getBrands( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.brands</code> attribute. 
	 * @param value the brands - 经营品牌
	 */
	public void setBrands(final SessionContext ctx, final String value)
	{
		setProperty(ctx, BRANDS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.brands</code> attribute. 
	 * @param value the brands - 经营品牌
	 */
	public void setBrands(final String value)
	{
		setBrands( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.categories</code> attribute.
	 * @return the categories
	 */
	public List<Category> getCategories(final SessionContext ctx)
	{
		final List<Category> items = getLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			"Category",
			null,
			Utilities.getRelationOrderingOverride(SETTLEIN2CATEGORY_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.categories</code> attribute.
	 * @return the categories
	 */
	public List<Category> getCategories()
	{
		return getCategories( getSession().getSessionContext() );
	}
	
	public long getCategoriesCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			"Category",
			null
		);
	}
	
	public long getCategoriesCount()
	{
		return getCategoriesCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.categories</code> attribute. 
	 * @param value the categories
	 */
	public void setCategories(final SessionContext ctx, final List<Category> value)
	{
		setLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			null,
			value,
			Utilities.getRelationOrderingOverride(SETTLEIN2CATEGORY_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(SETTLEIN2CATEGORY_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.categories</code> attribute. 
	 * @param value the categories
	 */
	public void setCategories(final List<Category> value)
	{
		setCategories( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to categories. 
	 * @param value the item to add to categories
	 */
	public void addToCategories(final SessionContext ctx, final Category value)
	{
		addLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(SETTLEIN2CATEGORY_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(SETTLEIN2CATEGORY_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to categories. 
	 * @param value the item to add to categories
	 */
	public void addToCategories(final Category value)
	{
		addToCategories( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from categories. 
	 * @param value the item to remove from categories
	 */
	public void removeFromCategories(final SessionContext ctx, final Category value)
	{
		removeLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(SETTLEIN2CATEGORY_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(SETTLEIN2CATEGORY_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from categories. 
	 * @param value the item to remove from categories
	 */
	public void removeFromCategories(final Category value)
	{
		removeFromCategories( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.code</code> attribute.
	 * @return the code - 编号
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.code</code> attribute.
	 * @return the code - 编号
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.code</code> attribute. 
	 * @param value the code - 编号
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.code</code> attribute. 
	 * @param value the code - 编号
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.companyName</code> attribute.
	 * @return the companyName - 公司名称
	 */
	public String getCompanyName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, COMPANYNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.companyName</code> attribute.
	 * @return the companyName - 公司名称
	 */
	public String getCompanyName()
	{
		return getCompanyName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.companyName</code> attribute. 
	 * @param value the companyName - 公司名称
	 */
	public void setCompanyName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, COMPANYNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.companyName</code> attribute. 
	 * @param value the companyName - 公司名称
	 */
	public void setCompanyName(final String value)
	{
		setCompanyName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.contactName</code> attribute.
	 * @return the contactName - 联系人姓名
	 */
	public String getContactName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONTACTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.contactName</code> attribute.
	 * @return the contactName - 联系人姓名
	 */
	public String getContactName()
	{
		return getContactName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.contactName</code> attribute. 
	 * @param value the contactName - 联系人姓名
	 */
	public void setContactName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CONTACTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.contactName</code> attribute. 
	 * @param value the contactName - 联系人姓名
	 */
	public void setContactName(final String value)
	{
		setContactName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.contactPhone</code> attribute.
	 * @return the contactPhone - 联系人手机
	 */
	public String getContactPhone(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONTACTPHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.contactPhone</code> attribute.
	 * @return the contactPhone - 联系人手机
	 */
	public String getContactPhone()
	{
		return getContactPhone( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.contactPhone</code> attribute. 
	 * @param value the contactPhone - 联系人手机
	 */
	public void setContactPhone(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CONTACTPHONE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.contactPhone</code> attribute. 
	 * @param value the contactPhone - 联系人手机
	 */
	public void setContactPhone(final String value)
	{
		setContactPhone( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.endDate</code> attribute.
	 * @return the endDate - 营业期限结束日期
	 */
	public Date getEndDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, ENDDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.endDate</code> attribute.
	 * @return the endDate - 营业期限结束日期
	 */
	public Date getEndDate()
	{
		return getEndDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.endDate</code> attribute. 
	 * @param value the endDate - 营业期限结束日期
	 */
	public void setEndDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, ENDDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.endDate</code> attribute. 
	 * @param value the endDate - 营业期限结束日期
	 */
	public void setEndDate(final Date value)
	{
		setEndDate( getSession().getSessionContext(), value );
	}
	
	@Override
	public boolean isMarkModifiedDisabled(final Item referencedItem)
	{
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Category");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(SETTLEIN2CATEGORY_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.legalRepresentative</code> attribute.
	 * @return the legalRepresentative - 法定代表人姓名
	 */
	public String getLegalRepresentative(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LEGALREPRESENTATIVE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.legalRepresentative</code> attribute.
	 * @return the legalRepresentative - 法定代表人姓名
	 */
	public String getLegalRepresentative()
	{
		return getLegalRepresentative( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.legalRepresentative</code> attribute. 
	 * @param value the legalRepresentative - 法定代表人姓名
	 */
	public void setLegalRepresentative(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LEGALREPRESENTATIVE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.legalRepresentative</code> attribute. 
	 * @param value the legalRepresentative - 法定代表人姓名
	 */
	public void setLegalRepresentative(final String value)
	{
		setLegalRepresentative( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.setupDate</code> attribute.
	 * @return the setupDate - 成立日期
	 */
	public Date getSetupDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, SETUPDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.setupDate</code> attribute.
	 * @return the setupDate - 成立日期
	 */
	public Date getSetupDate()
	{
		return getSetupDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.setupDate</code> attribute. 
	 * @param value the setupDate - 成立日期
	 */
	public void setSetupDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, SETUPDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.setupDate</code> attribute. 
	 * @param value the setupDate - 成立日期
	 */
	public void setSetupDate(final Date value)
	{
		setSetupDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.startDate</code> attribute.
	 * @return the startDate - 营业期限起始日期
	 */
	public Date getStartDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, STARTDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SettleIn.startDate</code> attribute.
	 * @return the startDate - 营业期限起始日期
	 */
	public Date getStartDate()
	{
		return getStartDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.startDate</code> attribute. 
	 * @param value the startDate - 营业期限起始日期
	 */
	public void setStartDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, STARTDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SettleIn.startDate</code> attribute. 
	 * @param value the startDate - 营业期限起始日期
	 */
	public void setStartDate(final Date value)
	{
		setStartDate( getSession().getSessionContext(), value );
	}
	
}
