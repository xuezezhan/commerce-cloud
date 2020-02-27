/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年2月27日 下午7:52:57                        ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import com.zdds.core.jalo.ApparelProduct;
import com.zdds.core.jalo.ApparelSizeVariantProduct;
import com.zdds.core.jalo.ApparelStyleVariantProduct;
import com.zdds.core.jalo.Brand;
import com.zdds.core.jalo.Department;
import com.zdds.core.jalo.ElectronicsColorVariantProduct;
import com.zdds.core.jalo.SettleIn;
import com.zdds.core.jalo.Skill;
import com.zdds.core.jalo.Supplier;
import de.hybris.platform.category.jalo.Category;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.order.AbstractOrder;
import de.hybris.platform.jalo.order.Order;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.Employee;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type <code>ZddsCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedZddsCoreManager extends Extension
{
	/** Relation ordering override parameter constants for Employee2Skill from ((zddscore))*/
	protected static String EMPLOYEE2SKILL_SRC_ORDERED = "relation.Employee2Skill.source.ordered";
	protected static String EMPLOYEE2SKILL_TGT_ORDERED = "relation.Employee2Skill.target.ordered";
	/** Relation disable markmodifed parameter constants for Employee2Skill from ((zddscore))*/
	protected static String EMPLOYEE2SKILL_MARKMODIFIED = "relation.Employee2Skill.markmodified";
	/** Relation ordering override parameter constants for SettleIn2Category from ((zddscore))*/
	protected static String SETTLEIN2CATEGORY_SRC_ORDERED = "relation.SettleIn2Category.source.ordered";
	protected static String SETTLEIN2CATEGORY_TGT_ORDERED = "relation.SettleIn2Category.target.ordered";
	/** Relation disable markmodifed parameter constants for SettleIn2Category from ((zddscore))*/
	protected static String SETTLEIN2CATEGORY_MARKMODIFIED = "relation.SettleIn2Category.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("telephone", AttributeMode.INITIAL);
		tmp.put("department", AttributeMode.INITIAL);
		tmp.put("position", AttributeMode.INITIAL);
		tmp.put("idNumber", AttributeMode.INITIAL);
		tmp.put("gender", AttributeMode.INITIAL);
		tmp.put("isSupplier", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Employee", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("realName", AttributeMode.INITIAL);
		tmp.put("phone", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("remark", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.order.Order", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("brand", AttributeMode.INITIAL);
		tmp.put("model", AttributeMode.INITIAL);
		tmp.put("deliveryCharge", AttributeMode.INITIAL);
		tmp.put("salesVolume", AttributeMode.INITIAL);
		tmp.put("taxPoint", AttributeMode.INITIAL);
		tmp.put("commission", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.brand</code> attribute.
	 * @return the brand - 品牌
	 */
	public Brand getBrand(final SessionContext ctx, final Product item)
	{
		return (Brand)item.getProperty( ctx, ZddsCoreConstants.Attributes.Product.BRAND);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.brand</code> attribute.
	 * @return the brand - 品牌
	 */
	public Brand getBrand(final Product item)
	{
		return getBrand( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.brand</code> attribute. 
	 * @param value the brand - 品牌
	 */
	public void setBrand(final SessionContext ctx, final Product item, final Brand value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Product.BRAND,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.brand</code> attribute. 
	 * @param value the brand - 品牌
	 */
	public void setBrand(final Product item, final Brand value)
	{
		setBrand( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.commission</code> attribute.
	 * @return the commission - 回扣
	 */
	public Double getCommission(final SessionContext ctx, final Product item)
	{
		return (Double)item.getProperty( ctx, ZddsCoreConstants.Attributes.Product.COMMISSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.commission</code> attribute.
	 * @return the commission - 回扣
	 */
	public Double getCommission(final Product item)
	{
		return getCommission( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.commission</code> attribute. 
	 * @return the commission - 回扣
	 */
	public double getCommissionAsPrimitive(final SessionContext ctx, final Product item)
	{
		Double value = getCommission( ctx,item );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.commission</code> attribute. 
	 * @return the commission - 回扣
	 */
	public double getCommissionAsPrimitive(final Product item)
	{
		return getCommissionAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.commission</code> attribute. 
	 * @param value the commission - 回扣
	 */
	public void setCommission(final SessionContext ctx, final Product item, final Double value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Product.COMMISSION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.commission</code> attribute. 
	 * @param value the commission - 回扣
	 */
	public void setCommission(final Product item, final Double value)
	{
		setCommission( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.commission</code> attribute. 
	 * @param value the commission - 回扣
	 */
	public void setCommission(final SessionContext ctx, final Product item, final double value)
	{
		setCommission( ctx, item, Double.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.commission</code> attribute. 
	 * @param value the commission - 回扣
	 */
	public void setCommission(final Product item, final double value)
	{
		setCommission( getSession().getSessionContext(), item, value );
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public Brand createBrand(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.BRAND );
			return (Brand)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Brand : "+e.getMessage(), 0 );
		}
	}
	
	public Brand createBrand(final Map attributeValues)
	{
		return createBrand( getSession().getSessionContext(), attributeValues );
	}
	
	public Department createDepartment(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.DEPARTMENT );
			return (Department)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Department : "+e.getMessage(), 0 );
		}
	}
	
	public Department createDepartment(final Map attributeValues)
	{
		return createDepartment( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public SettleIn createSettleIn(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.SETTLEIN );
			return (SettleIn)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating SettleIn : "+e.getMessage(), 0 );
		}
	}
	
	public SettleIn createSettleIn(final Map attributeValues)
	{
		return createSettleIn( getSession().getSessionContext(), attributeValues );
	}
	
	public Skill createSkill(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.SKILL );
			return (Skill)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Skill : "+e.getMessage(), 0 );
		}
	}
	
	public Skill createSkill(final Map attributeValues)
	{
		return createSkill( getSession().getSessionContext(), attributeValues );
	}
	
	public Supplier createSupplier(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.SUPPLIER );
			return (Supplier)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Supplier : "+e.getMessage(), 0 );
		}
	}
	
	public Supplier createSupplier(final Map attributeValues)
	{
		return createSupplier( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.deliveryCharge</code> attribute.
	 * @return the deliveryCharge - 运费
	 */
	public Double getDeliveryCharge(final SessionContext ctx, final Product item)
	{
		return (Double)item.getProperty( ctx, ZddsCoreConstants.Attributes.Product.DELIVERYCHARGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.deliveryCharge</code> attribute.
	 * @return the deliveryCharge - 运费
	 */
	public Double getDeliveryCharge(final Product item)
	{
		return getDeliveryCharge( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.deliveryCharge</code> attribute. 
	 * @return the deliveryCharge - 运费
	 */
	public double getDeliveryChargeAsPrimitive(final SessionContext ctx, final Product item)
	{
		Double value = getDeliveryCharge( ctx,item );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.deliveryCharge</code> attribute. 
	 * @return the deliveryCharge - 运费
	 */
	public double getDeliveryChargeAsPrimitive(final Product item)
	{
		return getDeliveryChargeAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.deliveryCharge</code> attribute. 
	 * @param value the deliveryCharge - 运费
	 */
	public void setDeliveryCharge(final SessionContext ctx, final Product item, final Double value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Product.DELIVERYCHARGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.deliveryCharge</code> attribute. 
	 * @param value the deliveryCharge - 运费
	 */
	public void setDeliveryCharge(final Product item, final Double value)
	{
		setDeliveryCharge( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.deliveryCharge</code> attribute. 
	 * @param value the deliveryCharge - 运费
	 */
	public void setDeliveryCharge(final SessionContext ctx, final Product item, final double value)
	{
		setDeliveryCharge( ctx, item, Double.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.deliveryCharge</code> attribute. 
	 * @param value the deliveryCharge - 运费
	 */
	public void setDeliveryCharge(final Product item, final double value)
	{
		setDeliveryCharge( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.department</code> attribute.
	 * @return the department - 单位
	 */
	public Department getDepartment(final SessionContext ctx, final Employee item)
	{
		return (Department)item.getProperty( ctx, ZddsCoreConstants.Attributes.Employee.DEPARTMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.department</code> attribute.
	 * @return the department - 单位
	 */
	public Department getDepartment(final Employee item)
	{
		return getDepartment( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.department</code> attribute. 
	 * @param value the department - 单位
	 */
	public void setDepartment(final SessionContext ctx, final Employee item, final Department value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Employee.DEPARTMENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.department</code> attribute. 
	 * @param value the department - 单位
	 */
	public void setDepartment(final Employee item, final Department value)
	{
		setDepartment( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.gender</code> attribute.
	 * @return the gender - 性别
	 */
	public EnumerationValue getGender(final SessionContext ctx, final Employee item)
	{
		return (EnumerationValue)item.getProperty( ctx, ZddsCoreConstants.Attributes.Employee.GENDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.gender</code> attribute.
	 * @return the gender - 性别
	 */
	public EnumerationValue getGender(final Employee item)
	{
		return getGender( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.gender</code> attribute. 
	 * @param value the gender - 性别
	 */
	public void setGender(final SessionContext ctx, final Employee item, final EnumerationValue value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Employee.GENDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.gender</code> attribute. 
	 * @param value the gender - 性别
	 */
	public void setGender(final Employee item, final EnumerationValue value)
	{
		setGender( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return ZddsCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.idNumber</code> attribute.
	 * @return the idNumber - 身份证号
	 */
	public String getIdNumber(final SessionContext ctx, final Employee item)
	{
		return (String)item.getProperty( ctx, ZddsCoreConstants.Attributes.Employee.IDNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.idNumber</code> attribute.
	 * @return the idNumber - 身份证号
	 */
	public String getIdNumber(final Employee item)
	{
		return getIdNumber( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.idNumber</code> attribute. 
	 * @param value the idNumber - 身份证号
	 */
	public void setIdNumber(final SessionContext ctx, final Employee item, final String value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Employee.IDNUMBER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.idNumber</code> attribute. 
	 * @param value the idNumber - 身份证号
	 */
	public void setIdNumber(final Employee item, final String value)
	{
		setIdNumber( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.isSupplier</code> attribute.
	 * @return the isSupplier - 是否为供应商
	 */
	public Boolean isIsSupplier(final SessionContext ctx, final Employee item)
	{
		return (Boolean)item.getProperty( ctx, ZddsCoreConstants.Attributes.Employee.ISSUPPLIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.isSupplier</code> attribute.
	 * @return the isSupplier - 是否为供应商
	 */
	public Boolean isIsSupplier(final Employee item)
	{
		return isIsSupplier( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.isSupplier</code> attribute. 
	 * @return the isSupplier - 是否为供应商
	 */
	public boolean isIsSupplierAsPrimitive(final SessionContext ctx, final Employee item)
	{
		Boolean value = isIsSupplier( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.isSupplier</code> attribute. 
	 * @return the isSupplier - 是否为供应商
	 */
	public boolean isIsSupplierAsPrimitive(final Employee item)
	{
		return isIsSupplierAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.isSupplier</code> attribute. 
	 * @param value the isSupplier - 是否为供应商
	 */
	public void setIsSupplier(final SessionContext ctx, final Employee item, final Boolean value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Employee.ISSUPPLIER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.isSupplier</code> attribute. 
	 * @param value the isSupplier - 是否为供应商
	 */
	public void setIsSupplier(final Employee item, final Boolean value)
	{
		setIsSupplier( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.isSupplier</code> attribute. 
	 * @param value the isSupplier - 是否为供应商
	 */
	public void setIsSupplier(final SessionContext ctx, final Employee item, final boolean value)
	{
		setIsSupplier( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.isSupplier</code> attribute. 
	 * @param value the isSupplier - 是否为供应商
	 */
	public void setIsSupplier(final Employee item, final boolean value)
	{
		setIsSupplier( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.model</code> attribute.
	 * @return the model - 商品型号
	 */
	public String getModel(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, ZddsCoreConstants.Attributes.Product.MODEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.model</code> attribute.
	 * @return the model - 商品型号
	 */
	public String getModel(final Product item)
	{
		return getModel( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.model</code> attribute. 
	 * @param value the model - 商品型号
	 */
	public void setModel(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Product.MODEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.model</code> attribute. 
	 * @param value the model - 商品型号
	 */
	public void setModel(final Product item, final String value)
	{
		setModel( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.phone</code> attribute.
	 * @return the phone - 手机号码
	 */
	public String getPhone(final SessionContext ctx, final Customer item)
	{
		return (String)item.getProperty( ctx, ZddsCoreConstants.Attributes.Customer.PHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.phone</code> attribute.
	 * @return the phone - 手机号码
	 */
	public String getPhone(final Customer item)
	{
		return getPhone( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.phone</code> attribute. 
	 * @param value the phone - 手机号码
	 */
	public void setPhone(final SessionContext ctx, final Customer item, final String value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Customer.PHONE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.phone</code> attribute. 
	 * @param value the phone - 手机号码
	 */
	public void setPhone(final Customer item, final String value)
	{
		setPhone( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.position</code> attribute.
	 * @return the position - 职位
	 */
	public EnumerationValue getPosition(final SessionContext ctx, final Employee item)
	{
		return (EnumerationValue)item.getProperty( ctx, ZddsCoreConstants.Attributes.Employee.POSITION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.position</code> attribute.
	 * @return the position - 职位
	 */
	public EnumerationValue getPosition(final Employee item)
	{
		return getPosition( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.position</code> attribute. 
	 * @param value the position - 职位
	 */
	public void setPosition(final SessionContext ctx, final Employee item, final EnumerationValue value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Employee.POSITION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.position</code> attribute. 
	 * @param value the position - 职位
	 */
	public void setPosition(final Employee item, final EnumerationValue value)
	{
		setPosition( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.realName</code> attribute.
	 * @return the realName - 真实名字
	 */
	public String getRealName(final SessionContext ctx, final Customer item)
	{
		return (String)item.getProperty( ctx, ZddsCoreConstants.Attributes.Customer.REALNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.realName</code> attribute.
	 * @return the realName - 真实名字
	 */
	public String getRealName(final Customer item)
	{
		return getRealName( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.realName</code> attribute. 
	 * @param value the realName - 真实名字
	 */
	public void setRealName(final SessionContext ctx, final Customer item, final String value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Customer.REALNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.realName</code> attribute. 
	 * @param value the realName - 真实名字
	 */
	public void setRealName(final Customer item, final String value)
	{
		setRealName( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.remark</code> attribute.
	 * @return the remark - 订单备注
	 */
	public String getRemark(final SessionContext ctx, final Order item)
	{
		return (String)item.getProperty( ctx, ZddsCoreConstants.Attributes.Order.REMARK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.remark</code> attribute.
	 * @return the remark - 订单备注
	 */
	public String getRemark(final Order item)
	{
		return getRemark( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.remark</code> attribute. 
	 * @param value the remark - 订单备注
	 */
	public void setRemark(final SessionContext ctx, final Order item, final String value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Order.REMARK,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.remark</code> attribute. 
	 * @param value the remark - 订单备注
	 */
	public void setRemark(final Order item, final String value)
	{
		setRemark( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.salesVolume</code> attribute.
	 * @return the salesVolume - 销量
	 */
	public Integer getSalesVolume(final SessionContext ctx, final Product item)
	{
		return (Integer)item.getProperty( ctx, ZddsCoreConstants.Attributes.Product.SALESVOLUME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.salesVolume</code> attribute.
	 * @return the salesVolume - 销量
	 */
	public Integer getSalesVolume(final Product item)
	{
		return getSalesVolume( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.salesVolume</code> attribute. 
	 * @return the salesVolume - 销量
	 */
	public int getSalesVolumeAsPrimitive(final SessionContext ctx, final Product item)
	{
		Integer value = getSalesVolume( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.salesVolume</code> attribute. 
	 * @return the salesVolume - 销量
	 */
	public int getSalesVolumeAsPrimitive(final Product item)
	{
		return getSalesVolumeAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.salesVolume</code> attribute. 
	 * @param value the salesVolume - 销量
	 */
	public void setSalesVolume(final SessionContext ctx, final Product item, final Integer value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Product.SALESVOLUME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.salesVolume</code> attribute. 
	 * @param value the salesVolume - 销量
	 */
	public void setSalesVolume(final Product item, final Integer value)
	{
		setSalesVolume( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.salesVolume</code> attribute. 
	 * @param value the salesVolume - 销量
	 */
	public void setSalesVolume(final SessionContext ctx, final Product item, final int value)
	{
		setSalesVolume( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.salesVolume</code> attribute. 
	 * @param value the salesVolume - 销量
	 */
	public void setSalesVolume(final Product item, final int value)
	{
		setSalesVolume( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.settleins</code> attribute.
	 * @return the settleins
	 */
	public Collection<SettleIn> getSettleins(final SessionContext ctx, final Category item)
	{
		final List<SettleIn> items = item.getLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			"SettleIn",
			null,
			Utilities.getRelationOrderingOverride(SETTLEIN2CATEGORY_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.settleins</code> attribute.
	 * @return the settleins
	 */
	public Collection<SettleIn> getSettleins(final Category item)
	{
		return getSettleins( getSession().getSessionContext(), item );
	}
	
	public long getSettleinsCount(final SessionContext ctx, final Category item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			"SettleIn",
			null
		);
	}
	
	public long getSettleinsCount(final Category item)
	{
		return getSettleinsCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.settleins</code> attribute. 
	 * @param value the settleins
	 */
	public void setSettleins(final SessionContext ctx, final Category item, final Collection<SettleIn> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			null,
			value,
			Utilities.getRelationOrderingOverride(SETTLEIN2CATEGORY_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(SETTLEIN2CATEGORY_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.settleins</code> attribute. 
	 * @param value the settleins
	 */
	public void setSettleins(final Category item, final Collection<SettleIn> value)
	{
		setSettleins( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to settleins. 
	 * @param value the item to add to settleins
	 */
	public void addToSettleins(final SessionContext ctx, final Category item, final SettleIn value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(SETTLEIN2CATEGORY_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(SETTLEIN2CATEGORY_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to settleins. 
	 * @param value the item to add to settleins
	 */
	public void addToSettleins(final Category item, final SettleIn value)
	{
		addToSettleins( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from settleins. 
	 * @param value the item to remove from settleins
	 */
	public void removeFromSettleins(final SessionContext ctx, final Category item, final SettleIn value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.SETTLEIN2CATEGORY,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(SETTLEIN2CATEGORY_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(SETTLEIN2CATEGORY_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from settleins. 
	 * @param value the item to remove from settleins
	 */
	public void removeFromSettleins(final Category item, final SettleIn value)
	{
		removeFromSettleins( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.skills</code> attribute.
	 * @return the skills
	 */
	public List<Skill> getSkills(final SessionContext ctx, final Employee item)
	{
		final List<Skill> items = item.getLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			"Skill",
			null,
			Utilities.getRelationOrderingOverride(EMPLOYEE2SKILL_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.skills</code> attribute.
	 * @return the skills
	 */
	public List<Skill> getSkills(final Employee item)
	{
		return getSkills( getSession().getSessionContext(), item );
	}
	
	public long getSkillsCount(final SessionContext ctx, final Employee item)
	{
		return item.getLinkedItemsCount(
			ctx,
			true,
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			"Skill",
			null
		);
	}
	
	public long getSkillsCount(final Employee item)
	{
		return getSkillsCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.skills</code> attribute. 
	 * @param value the skills
	 */
	public void setSkills(final SessionContext ctx, final Employee item, final List<Skill> value)
	{
		item.setLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			null,
			value,
			Utilities.getRelationOrderingOverride(EMPLOYEE2SKILL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(EMPLOYEE2SKILL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.skills</code> attribute. 
	 * @param value the skills
	 */
	public void setSkills(final Employee item, final List<Skill> value)
	{
		setSkills( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to skills. 
	 * @param value the item to add to skills
	 */
	public void addToSkills(final SessionContext ctx, final Employee item, final Skill value)
	{
		item.addLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(EMPLOYEE2SKILL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(EMPLOYEE2SKILL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to skills. 
	 * @param value the item to add to skills
	 */
	public void addToSkills(final Employee item, final Skill value)
	{
		addToSkills( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from skills. 
	 * @param value the item to remove from skills
	 */
	public void removeFromSkills(final SessionContext ctx, final Employee item, final Skill value)
	{
		item.removeLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.EMPLOYEE2SKILL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(EMPLOYEE2SKILL_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(EMPLOYEE2SKILL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from skills. 
	 * @param value the item to remove from skills
	 */
	public void removeFromSkills(final Employee item, final Skill value)
	{
		removeFromSkills( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.taxPoint</code> attribute.
	 * @return the taxPoint - 税点
	 */
	public Double getTaxPoint(final SessionContext ctx, final Product item)
	{
		return (Double)item.getProperty( ctx, ZddsCoreConstants.Attributes.Product.TAXPOINT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.taxPoint</code> attribute.
	 * @return the taxPoint - 税点
	 */
	public Double getTaxPoint(final Product item)
	{
		return getTaxPoint( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.taxPoint</code> attribute. 
	 * @return the taxPoint - 税点
	 */
	public double getTaxPointAsPrimitive(final SessionContext ctx, final Product item)
	{
		Double value = getTaxPoint( ctx,item );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.taxPoint</code> attribute. 
	 * @return the taxPoint - 税点
	 */
	public double getTaxPointAsPrimitive(final Product item)
	{
		return getTaxPointAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.taxPoint</code> attribute. 
	 * @param value the taxPoint - 税点
	 */
	public void setTaxPoint(final SessionContext ctx, final Product item, final Double value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Product.TAXPOINT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.taxPoint</code> attribute. 
	 * @param value the taxPoint - 税点
	 */
	public void setTaxPoint(final Product item, final Double value)
	{
		setTaxPoint( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.taxPoint</code> attribute. 
	 * @param value the taxPoint - 税点
	 */
	public void setTaxPoint(final SessionContext ctx, final Product item, final double value)
	{
		setTaxPoint( ctx, item, Double.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.taxPoint</code> attribute. 
	 * @param value the taxPoint - 税点
	 */
	public void setTaxPoint(final Product item, final double value)
	{
		setTaxPoint( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.telephone</code> attribute.
	 * @return the telephone - 手机号码
	 */
	public String getTelephone(final SessionContext ctx, final Employee item)
	{
		return (String)item.getProperty( ctx, ZddsCoreConstants.Attributes.Employee.TELEPHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.telephone</code> attribute.
	 * @return the telephone - 手机号码
	 */
	public String getTelephone(final Employee item)
	{
		return getTelephone( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.telephone</code> attribute. 
	 * @param value the telephone - 手机号码
	 */
	public void setTelephone(final SessionContext ctx, final Employee item, final String value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Employee.TELEPHONE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.telephone</code> attribute. 
	 * @param value the telephone - 手机号码
	 */
	public void setTelephone(final Employee item, final String value)
	{
		setTelephone( getSession().getSessionContext(), item, value );
	}
	
}
