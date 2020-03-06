/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年3月4日 上午9:02:14                         ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import com.zdds.core.jalo.ApparelProduct;
import com.zdds.core.jalo.ApparelSizeVariantProduct;
import com.zdds.core.jalo.ApparelStyleVariantProduct;
import com.zdds.core.jalo.Brand;
import com.zdds.core.jalo.Carrier;
import com.zdds.core.jalo.DeliveryInfo;
import com.zdds.core.jalo.Department;
import com.zdds.core.jalo.ElectronicsColorVariantProduct;
import com.zdds.core.jalo.Invoice;
import com.zdds.core.jalo.ServiceRecord;
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
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.Employee;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.ordersplitting.jalo.Consignment;
import de.hybris.platform.util.OneToManyHandler;
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
	/** Relation ordering override parameter constants for Order2Employee from ((zddscore))*/
	protected static String ORDER2EMPLOYEE_SRC_ORDERED = "relation.Order2Employee.source.ordered";
	protected static String ORDER2EMPLOYEE_TGT_ORDERED = "relation.Order2Employee.target.ordered";
	/** Relation disable markmodifed parameter constants for Order2Employee from ((zddscore))*/
	protected static String ORDER2EMPLOYEE_MARKMODIFIED = "relation.Order2Employee.markmodified";
	/**
	* {@link OneToManyHandler} for handling 1:n SERVICERECORDS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<ServiceRecord> ORDER2SERVICERECORDSERVICERECORDSHANDLER = new OneToManyHandler<ServiceRecord>(
	ZddsCoreConstants.TC.SERVICERECORD,
	false,
	"order",
	null,
	false,
	true,
	CollectionType.LIST
	).withRelationQualifier("serviceRecords");
	/**
	* {@link OneToManyHandler} for handling 1:n DELIVERYINFOES's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<DeliveryInfo> CONSIGNMENT2DELIVERYINFODELIVERYINFOESHANDLER = new OneToManyHandler<DeliveryInfo>(
	ZddsCoreConstants.TC.DELIVERYINFO,
	false,
	"consignment",
	null,
	false,
	true,
	CollectionType.LIST
	).withRelationQualifier("deliveryInfoes");
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
		tmp.put("orderType", AttributeMode.INITIAL);
		tmp.put("serviceStatus", AttributeMode.INITIAL);
		tmp.put("recommender", AttributeMode.INITIAL);
		tmp.put("invoice", AttributeMode.INITIAL);
		tmp.put("department", AttributeMode.INITIAL);
		tmp.put("isPresent", AttributeMode.INITIAL);
		tmp.put("illustration", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.order.Order", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("supplier", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.ordersplitting.jalo.Consignment", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("brand", AttributeMode.INITIAL);
		tmp.put("model", AttributeMode.INITIAL);
		tmp.put("deliveryCharge", AttributeMode.INITIAL);
		tmp.put("salesVolume", AttributeMode.INITIAL);
		tmp.put("taxPoint", AttributeMode.INITIAL);
		tmp.put("commission", AttributeMode.INITIAL);
		tmp.put("checkStatus", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("level", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.category.jalo.Category", Collections.unmodifiableMap(tmp));
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
	 * <i>Generated method</i> - Getter of the <code>Product.checkStatus</code> attribute.
	 * @return the checkStatus - 商品审核状态
	 */
	public EnumerationValue getCheckStatus(final SessionContext ctx, final Product item)
	{
		return (EnumerationValue)item.getProperty( ctx, ZddsCoreConstants.Attributes.Product.CHECKSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.checkStatus</code> attribute.
	 * @return the checkStatus - 商品审核状态
	 */
	public EnumerationValue getCheckStatus(final Product item)
	{
		return getCheckStatus( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.checkStatus</code> attribute. 
	 * @param value the checkStatus - 商品审核状态
	 */
	public void setCheckStatus(final SessionContext ctx, final Product item, final EnumerationValue value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Product.CHECKSTATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.checkStatus</code> attribute. 
	 * @param value the checkStatus - 商品审核状态
	 */
	public void setCheckStatus(final Product item, final EnumerationValue value)
	{
		setCheckStatus( getSession().getSessionContext(), item, value );
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
	
	public Carrier createCarrier(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.CARRIER );
			return (Carrier)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating Carrier : "+e.getMessage(), 0 );
		}
	}
	
	public Carrier createCarrier(final Map attributeValues)
	{
		return createCarrier( getSession().getSessionContext(), attributeValues );
	}
	
	public DeliveryInfo createDeliveryInfo(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.DELIVERYINFO );
			return (DeliveryInfo)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating DeliveryInfo : "+e.getMessage(), 0 );
		}
	}
	
	public DeliveryInfo createDeliveryInfo(final Map attributeValues)
	{
		return createDeliveryInfo( getSession().getSessionContext(), attributeValues );
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
	
	public Invoice createInvoice(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.INVOICE );
			return (Invoice)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating Invoice : "+e.getMessage(), 0 );
		}
	}
	
	public Invoice createInvoice(final Map attributeValues)
	{
		return createInvoice( getSession().getSessionContext(), attributeValues );
	}
	
	public ServiceRecord createServiceRecord(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ZddsCoreConstants.TC.SERVICERECORD );
			return (ServiceRecord)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating ServiceRecord : "+e.getMessage(), 0 );
		}
	}
	
	public ServiceRecord createServiceRecord(final Map attributeValues)
	{
		return createServiceRecord( getSession().getSessionContext(), attributeValues );
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
	 * <i>Generated method</i> - Getter of the <code>Consignment.deliveryInfoes</code> attribute.
	 * @return the deliveryInfoes
	 */
	public List<DeliveryInfo> getDeliveryInfoes(final SessionContext ctx, final Consignment item)
	{
		return (List<DeliveryInfo>)CONSIGNMENT2DELIVERYINFODELIVERYINFOESHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.deliveryInfoes</code> attribute.
	 * @return the deliveryInfoes
	 */
	public List<DeliveryInfo> getDeliveryInfoes(final Consignment item)
	{
		return getDeliveryInfoes( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Consignment.deliveryInfoes</code> attribute. 
	 * @param value the deliveryInfoes
	 */
	public void setDeliveryInfoes(final SessionContext ctx, final Consignment item, final List<DeliveryInfo> value)
	{
		CONSIGNMENT2DELIVERYINFODELIVERYINFOESHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Consignment.deliveryInfoes</code> attribute. 
	 * @param value the deliveryInfoes
	 */
	public void setDeliveryInfoes(final Consignment item, final List<DeliveryInfo> value)
	{
		setDeliveryInfoes( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to deliveryInfoes. 
	 * @param value the item to add to deliveryInfoes
	 */
	public void addToDeliveryInfoes(final SessionContext ctx, final Consignment item, final DeliveryInfo value)
	{
		CONSIGNMENT2DELIVERYINFODELIVERYINFOESHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to deliveryInfoes. 
	 * @param value the item to add to deliveryInfoes
	 */
	public void addToDeliveryInfoes(final Consignment item, final DeliveryInfo value)
	{
		addToDeliveryInfoes( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from deliveryInfoes. 
	 * @param value the item to remove from deliveryInfoes
	 */
	public void removeFromDeliveryInfoes(final SessionContext ctx, final Consignment item, final DeliveryInfo value)
	{
		CONSIGNMENT2DELIVERYINFODELIVERYINFOESHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from deliveryInfoes. 
	 * @param value the item to remove from deliveryInfoes
	 */
	public void removeFromDeliveryInfoes(final Consignment item, final DeliveryInfo value)
	{
		removeFromDeliveryInfoes( getSession().getSessionContext(), item, value );
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
	 * <i>Generated method</i> - Getter of the <code>Order.department</code> attribute.
	 * @return the department - 派单供电所
	 */
	public Department getDepartment(final SessionContext ctx, final Order item)
	{
		return (Department)item.getProperty( ctx, ZddsCoreConstants.Attributes.Order.DEPARTMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.department</code> attribute.
	 * @return the department - 派单供电所
	 */
	public Department getDepartment(final Order item)
	{
		return getDepartment( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.department</code> attribute. 
	 * @param value the department - 派单供电所
	 */
	public void setDepartment(final SessionContext ctx, final Order item, final Department value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Order.DEPARTMENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.department</code> attribute. 
	 * @param value the department - 派单供电所
	 */
	public void setDepartment(final Order item, final Department value)
	{
		setDepartment( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.employees</code> attribute.
	 * @return the employees
	 */
	public List<Employee> getEmployees(final SessionContext ctx, final Order item)
	{
		final List<Employee> items = item.getLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			"Employee",
			null,
			Utilities.getRelationOrderingOverride(ORDER2EMPLOYEE_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.employees</code> attribute.
	 * @return the employees
	 */
	public List<Employee> getEmployees(final Order item)
	{
		return getEmployees( getSession().getSessionContext(), item );
	}
	
	public long getEmployeesCount(final SessionContext ctx, final Order item)
	{
		return item.getLinkedItemsCount(
			ctx,
			true,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			"Employee",
			null
		);
	}
	
	public long getEmployeesCount(final Order item)
	{
		return getEmployeesCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.employees</code> attribute. 
	 * @param value the employees
	 */
	public void setEmployees(final SessionContext ctx, final Order item, final List<Employee> value)
	{
		item.setLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			null,
			value,
			Utilities.getRelationOrderingOverride(ORDER2EMPLOYEE_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(ORDER2EMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.employees</code> attribute. 
	 * @param value the employees
	 */
	public void setEmployees(final Order item, final List<Employee> value)
	{
		setEmployees( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to employees. 
	 * @param value the item to add to employees
	 */
	public void addToEmployees(final SessionContext ctx, final Order item, final Employee value)
	{
		item.addLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(ORDER2EMPLOYEE_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(ORDER2EMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to employees. 
	 * @param value the item to add to employees
	 */
	public void addToEmployees(final Order item, final Employee value)
	{
		addToEmployees( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from employees. 
	 * @param value the item to remove from employees
	 */
	public void removeFromEmployees(final SessionContext ctx, final Order item, final Employee value)
	{
		item.removeLinkedItems( 
			ctx,
			true,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(ORDER2EMPLOYEE_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(ORDER2EMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from employees. 
	 * @param value the item to remove from employees
	 */
	public void removeFromEmployees(final Order item, final Employee value)
	{
		removeFromEmployees( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.empOrders</code> attribute.
	 * @return the empOrders
	 */
	public Collection<Order> getEmpOrders(final SessionContext ctx, final Employee item)
	{
		final List<Order> items = item.getLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			"Order",
			null,
			Utilities.getRelationOrderingOverride(ORDER2EMPLOYEE_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.empOrders</code> attribute.
	 * @return the empOrders
	 */
	public Collection<Order> getEmpOrders(final Employee item)
	{
		return getEmpOrders( getSession().getSessionContext(), item );
	}
	
	public long getEmpOrdersCount(final SessionContext ctx, final Employee item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			"Order",
			null
		);
	}
	
	public long getEmpOrdersCount(final Employee item)
	{
		return getEmpOrdersCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.empOrders</code> attribute. 
	 * @param value the empOrders
	 */
	public void setEmpOrders(final SessionContext ctx, final Employee item, final Collection<Order> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			null,
			value,
			Utilities.getRelationOrderingOverride(ORDER2EMPLOYEE_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(ORDER2EMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.empOrders</code> attribute. 
	 * @param value the empOrders
	 */
	public void setEmpOrders(final Employee item, final Collection<Order> value)
	{
		setEmpOrders( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to empOrders. 
	 * @param value the item to add to empOrders
	 */
	public void addToEmpOrders(final SessionContext ctx, final Employee item, final Order value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(ORDER2EMPLOYEE_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(ORDER2EMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to empOrders. 
	 * @param value the item to add to empOrders
	 */
	public void addToEmpOrders(final Employee item, final Order value)
	{
		addToEmpOrders( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from empOrders. 
	 * @param value the item to remove from empOrders
	 */
	public void removeFromEmpOrders(final SessionContext ctx, final Employee item, final Order value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			ZddsCoreConstants.Relations.ORDER2EMPLOYEE,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(ORDER2EMPLOYEE_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(ORDER2EMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from empOrders. 
	 * @param value the item to remove from empOrders
	 */
	public void removeFromEmpOrders(final Employee item, final Order value)
	{
		removeFromEmpOrders( getSession().getSessionContext(), item, value );
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
	 * <i>Generated method</i> - Getter of the <code>Order.illustration</code> attribute.
	 * @return the illustration - 维修说明
	 */
	public String getIllustration(final SessionContext ctx, final Order item)
	{
		return (String)item.getProperty( ctx, ZddsCoreConstants.Attributes.Order.ILLUSTRATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.illustration</code> attribute.
	 * @return the illustration - 维修说明
	 */
	public String getIllustration(final Order item)
	{
		return getIllustration( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.illustration</code> attribute. 
	 * @param value the illustration - 维修说明
	 */
	public void setIllustration(final SessionContext ctx, final Order item, final String value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Order.ILLUSTRATION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.illustration</code> attribute. 
	 * @param value the illustration - 维修说明
	 */
	public void setIllustration(final Order item, final String value)
	{
		setIllustration( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.invoice</code> attribute.
	 * @return the invoice - 发票信息
	 */
	public Invoice getInvoice(final SessionContext ctx, final Order item)
	{
		return (Invoice)item.getProperty( ctx, ZddsCoreConstants.Attributes.Order.INVOICE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.invoice</code> attribute.
	 * @return the invoice - 发票信息
	 */
	public Invoice getInvoice(final Order item)
	{
		return getInvoice( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.invoice</code> attribute. 
	 * @param value the invoice - 发票信息
	 */
	public void setInvoice(final SessionContext ctx, final Order item, final Invoice value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Order.INVOICE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.invoice</code> attribute. 
	 * @param value the invoice - 发票信息
	 */
	public void setInvoice(final Order item, final Invoice value)
	{
		setInvoice( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.isPresent</code> attribute.
	 * @return the isPresent - 维修员是否在现场
	 */
	public Boolean isIsPresent(final SessionContext ctx, final Order item)
	{
		return (Boolean)item.getProperty( ctx, ZddsCoreConstants.Attributes.Order.ISPRESENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.isPresent</code> attribute.
	 * @return the isPresent - 维修员是否在现场
	 */
	public Boolean isIsPresent(final Order item)
	{
		return isIsPresent( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.isPresent</code> attribute. 
	 * @return the isPresent - 维修员是否在现场
	 */
	public boolean isIsPresentAsPrimitive(final SessionContext ctx, final Order item)
	{
		Boolean value = isIsPresent( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.isPresent</code> attribute. 
	 * @return the isPresent - 维修员是否在现场
	 */
	public boolean isIsPresentAsPrimitive(final Order item)
	{
		return isIsPresentAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.isPresent</code> attribute. 
	 * @param value the isPresent - 维修员是否在现场
	 */
	public void setIsPresent(final SessionContext ctx, final Order item, final Boolean value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Order.ISPRESENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.isPresent</code> attribute. 
	 * @param value the isPresent - 维修员是否在现场
	 */
	public void setIsPresent(final Order item, final Boolean value)
	{
		setIsPresent( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.isPresent</code> attribute. 
	 * @param value the isPresent - 维修员是否在现场
	 */
	public void setIsPresent(final SessionContext ctx, final Order item, final boolean value)
	{
		setIsPresent( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.isPresent</code> attribute. 
	 * @param value the isPresent - 维修员是否在现场
	 */
	public void setIsPresent(final Order item, final boolean value)
	{
		setIsPresent( getSession().getSessionContext(), item, value );
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
	 * <i>Generated method</i> - Getter of the <code>Category.level</code> attribute.
	 * @return the level - 类别级别
	 */
	public EnumerationValue getLevel(final SessionContext ctx, final Category item)
	{
		return (EnumerationValue)item.getProperty( ctx, ZddsCoreConstants.Attributes.Category.LEVEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.level</code> attribute.
	 * @return the level - 类别级别
	 */
	public EnumerationValue getLevel(final Category item)
	{
		return getLevel( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.level</code> attribute. 
	 * @param value the level - 类别级别
	 */
	public void setLevel(final SessionContext ctx, final Category item, final EnumerationValue value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Category.LEVEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.level</code> attribute. 
	 * @param value the level - 类别级别
	 */
	public void setLevel(final Category item, final EnumerationValue value)
	{
		setLevel( getSession().getSessionContext(), item, value );
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
	 * <i>Generated method</i> - Getter of the <code>Order.orderType</code> attribute.
	 * @return the orderType - 订单类型
	 */
	public EnumerationValue getOrderType(final SessionContext ctx, final Order item)
	{
		return (EnumerationValue)item.getProperty( ctx, ZddsCoreConstants.Attributes.Order.ORDERTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.orderType</code> attribute.
	 * @return the orderType - 订单类型
	 */
	public EnumerationValue getOrderType(final Order item)
	{
		return getOrderType( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.orderType</code> attribute. 
	 * @param value the orderType - 订单类型
	 */
	public void setOrderType(final SessionContext ctx, final Order item, final EnumerationValue value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Order.ORDERTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.orderType</code> attribute. 
	 * @param value the orderType - 订单类型
	 */
	public void setOrderType(final Order item, final EnumerationValue value)
	{
		setOrderType( getSession().getSessionContext(), item, value );
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
	 * <i>Generated method</i> - Getter of the <code>Order.recommender</code> attribute.
	 * @return the recommender - 推荐人
	 */
	public Employee getRecommender(final SessionContext ctx, final Order item)
	{
		return (Employee)item.getProperty( ctx, ZddsCoreConstants.Attributes.Order.RECOMMENDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.recommender</code> attribute.
	 * @return the recommender - 推荐人
	 */
	public Employee getRecommender(final Order item)
	{
		return getRecommender( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.recommender</code> attribute. 
	 * @param value the recommender - 推荐人
	 */
	public void setRecommender(final SessionContext ctx, final Order item, final Employee value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Order.RECOMMENDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.recommender</code> attribute. 
	 * @param value the recommender - 推荐人
	 */
	public void setRecommender(final Order item, final Employee value)
	{
		setRecommender( getSession().getSessionContext(), item, value );
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
	 * <i>Generated method</i> - Getter of the <code>Order.serviceRecords</code> attribute.
	 * @return the serviceRecords
	 */
	public List<ServiceRecord> getServiceRecords(final SessionContext ctx, final Order item)
	{
		return (List<ServiceRecord>)ORDER2SERVICERECORDSERVICERECORDSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.serviceRecords</code> attribute.
	 * @return the serviceRecords
	 */
	public List<ServiceRecord> getServiceRecords(final Order item)
	{
		return getServiceRecords( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.serviceRecords</code> attribute. 
	 * @param value the serviceRecords
	 */
	public void setServiceRecords(final SessionContext ctx, final Order item, final List<ServiceRecord> value)
	{
		ORDER2SERVICERECORDSERVICERECORDSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.serviceRecords</code> attribute. 
	 * @param value the serviceRecords
	 */
	public void setServiceRecords(final Order item, final List<ServiceRecord> value)
	{
		setServiceRecords( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to serviceRecords. 
	 * @param value the item to add to serviceRecords
	 */
	public void addToServiceRecords(final SessionContext ctx, final Order item, final ServiceRecord value)
	{
		ORDER2SERVICERECORDSERVICERECORDSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to serviceRecords. 
	 * @param value the item to add to serviceRecords
	 */
	public void addToServiceRecords(final Order item, final ServiceRecord value)
	{
		addToServiceRecords( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from serviceRecords. 
	 * @param value the item to remove from serviceRecords
	 */
	public void removeFromServiceRecords(final SessionContext ctx, final Order item, final ServiceRecord value)
	{
		ORDER2SERVICERECORDSERVICERECORDSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from serviceRecords. 
	 * @param value the item to remove from serviceRecords
	 */
	public void removeFromServiceRecords(final Order item, final ServiceRecord value)
	{
		removeFromServiceRecords( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.serviceStatus</code> attribute.
	 * @return the serviceStatus - 服务订单状态
	 */
	public EnumerationValue getServiceStatus(final SessionContext ctx, final Order item)
	{
		return (EnumerationValue)item.getProperty( ctx, ZddsCoreConstants.Attributes.Order.SERVICESTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.serviceStatus</code> attribute.
	 * @return the serviceStatus - 服务订单状态
	 */
	public EnumerationValue getServiceStatus(final Order item)
	{
		return getServiceStatus( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.serviceStatus</code> attribute. 
	 * @param value the serviceStatus - 服务订单状态
	 */
	public void setServiceStatus(final SessionContext ctx, final Order item, final EnumerationValue value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Order.SERVICESTATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.serviceStatus</code> attribute. 
	 * @param value the serviceStatus - 服务订单状态
	 */
	public void setServiceStatus(final Order item, final EnumerationValue value)
	{
		setServiceStatus( getSession().getSessionContext(), item, value );
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
	 * <i>Generated method</i> - Getter of the <code>Consignment.supplier</code> attribute.
	 * @return the supplier - 发货供应商
	 */
	public Supplier getSupplier(final SessionContext ctx, final Consignment item)
	{
		return (Supplier)item.getProperty( ctx, ZddsCoreConstants.Attributes.Consignment.SUPPLIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Consignment.supplier</code> attribute.
	 * @return the supplier - 发货供应商
	 */
	public Supplier getSupplier(final Consignment item)
	{
		return getSupplier( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Consignment.supplier</code> attribute. 
	 * @param value the supplier - 发货供应商
	 */
	public void setSupplier(final SessionContext ctx, final Consignment item, final Supplier value)
	{
		item.setProperty(ctx, ZddsCoreConstants.Attributes.Consignment.SUPPLIER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Consignment.supplier</code> attribute. 
	 * @param value the supplier - 发货供应商
	 */
	public void setSupplier(final Consignment item, final Supplier value)
	{
		setSupplier( getSession().getSessionContext(), item, value );
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
