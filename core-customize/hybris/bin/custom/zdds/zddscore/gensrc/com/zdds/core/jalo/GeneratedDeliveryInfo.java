/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年3月4日 上午9:02:14                         ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.jalo;

import com.zdds.core.constants.ZddsCoreConstants;
import com.zdds.core.jalo.Carrier;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.ordersplitting.jalo.Consignment;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem DeliveryInfo}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedDeliveryInfo extends GenericItem
{
	/** Qualifier of the <code>DeliveryInfo.carrier</code> attribute **/
	public static final String CARRIER = "carrier";
	/** Qualifier of the <code>DeliveryInfo.logisticsNumber</code> attribute **/
	public static final String LOGISTICSNUMBER = "logisticsNumber";
	/** Qualifier of the <code>DeliveryInfo.products</code> attribute **/
	public static final String PRODUCTS = "products";
	/** Qualifier of the <code>DeliveryInfo.number</code> attribute **/
	public static final String NUMBER = "number";
	/** Qualifier of the <code>DeliveryInfo.consignment</code> attribute **/
	public static final String CONSIGNMENT = "consignment";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n CONSIGNMENT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedDeliveryInfo> CONSIGNMENTHANDLER = new BidirectionalOneToManyHandler<GeneratedDeliveryInfo>(
	ZddsCoreConstants.TC.DELIVERYINFO,
	false,
	"consignment",
	null,
	false,
	true,
	CollectionType.LIST
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CARRIER, AttributeMode.INITIAL);
		tmp.put(LOGISTICSNUMBER, AttributeMode.INITIAL);
		tmp.put(PRODUCTS, AttributeMode.INITIAL);
		tmp.put(NUMBER, AttributeMode.INITIAL);
		tmp.put(CONSIGNMENT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.carrier</code> attribute.
	 * @return the carrier - 配送公司
	 */
	public Carrier getCarrier(final SessionContext ctx)
	{
		return (Carrier)getProperty( ctx, CARRIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.carrier</code> attribute.
	 * @return the carrier - 配送公司
	 */
	public Carrier getCarrier()
	{
		return getCarrier( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.carrier</code> attribute. 
	 * @param value the carrier - 配送公司
	 */
	public void setCarrier(final SessionContext ctx, final Carrier value)
	{
		setProperty(ctx, CARRIER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.carrier</code> attribute. 
	 * @param value the carrier - 配送公司
	 */
	public void setCarrier(final Carrier value)
	{
		setCarrier( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.consignment</code> attribute.
	 * @return the consignment
	 */
	public Consignment getConsignment(final SessionContext ctx)
	{
		return (Consignment)getProperty( ctx, CONSIGNMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.consignment</code> attribute.
	 * @return the consignment
	 */
	public Consignment getConsignment()
	{
		return getConsignment( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.consignment</code> attribute. 
	 * @param value the consignment
	 */
	public void setConsignment(final SessionContext ctx, final Consignment value)
	{
		CONSIGNMENTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.consignment</code> attribute. 
	 * @param value the consignment
	 */
	public void setConsignment(final Consignment value)
	{
		setConsignment( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		CONSIGNMENTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.logisticsNumber</code> attribute.
	 * @return the logisticsNumber - 物流单号
	 */
	public String getLogisticsNumber(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LOGISTICSNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.logisticsNumber</code> attribute.
	 * @return the logisticsNumber - 物流单号
	 */
	public String getLogisticsNumber()
	{
		return getLogisticsNumber( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.logisticsNumber</code> attribute. 
	 * @param value the logisticsNumber - 物流单号
	 */
	public void setLogisticsNumber(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LOGISTICSNUMBER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.logisticsNumber</code> attribute. 
	 * @param value the logisticsNumber - 物流单号
	 */
	public void setLogisticsNumber(final String value)
	{
		setLogisticsNumber( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.number</code> attribute.
	 * @return the number - 件数合计
	 */
	public Integer getNumber(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, NUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.number</code> attribute.
	 * @return the number - 件数合计
	 */
	public Integer getNumber()
	{
		return getNumber( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.number</code> attribute. 
	 * @return the number - 件数合计
	 */
	public int getNumberAsPrimitive(final SessionContext ctx)
	{
		Integer value = getNumber( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.number</code> attribute. 
	 * @return the number - 件数合计
	 */
	public int getNumberAsPrimitive()
	{
		return getNumberAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.number</code> attribute. 
	 * @param value the number - 件数合计
	 */
	public void setNumber(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, NUMBER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.number</code> attribute. 
	 * @param value the number - 件数合计
	 */
	public void setNumber(final Integer value)
	{
		setNumber( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.number</code> attribute. 
	 * @param value the number - 件数合计
	 */
	public void setNumber(final SessionContext ctx, final int value)
	{
		setNumber( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.number</code> attribute. 
	 * @param value the number - 件数合计
	 */
	public void setNumber(final int value)
	{
		setNumber( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.products</code> attribute.
	 * @return the products - 发货产品
	 */
	public List<Product> getProducts(final SessionContext ctx)
	{
		List<Product> coll = (List<Product>)getProperty( ctx, PRODUCTS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeliveryInfo.products</code> attribute.
	 * @return the products - 发货产品
	 */
	public List<Product> getProducts()
	{
		return getProducts( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.products</code> attribute. 
	 * @param value the products - 发货产品
	 */
	public void setProducts(final SessionContext ctx, final List<Product> value)
	{
		setProperty(ctx, PRODUCTS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeliveryInfo.products</code> attribute. 
	 * @param value the products - 发货产品
	 */
	public void setProducts(final List<Product> value)
	{
		setProducts( getSession().getSessionContext(), value );
	}
	
}
