/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年3月4日 上午9:02:14                         ---
 * ----------------------------------------------------------------
 */
package com.zdds.facades.jalo;

import com.zdds.core.jalo.Supplier;
import com.zdds.facades.constants.ZddsopfacadesConstants;
import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
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
	/** Qualifier of the <code>OperationMenu.suppliers</code> attribute **/
	public static final String SUPPLIERS = "suppliers";
	/** Relation ordering override parameter constants for MenuToSupplier from ((zddsopfacades))*/
	protected static String MENUTOSUPPLIER_SRC_ORDERED = "relation.MenuToSupplier.source.ordered";
	protected static String MENUTOSUPPLIER_TGT_ORDERED = "relation.MenuToSupplier.target.ordered";
	/** Relation disable markmodifed parameter constants for MenuToSupplier from ((zddsopfacades))*/
	protected static String MENUTOSUPPLIER_MARKMODIFIED = "relation.MenuToSupplier.markmodified";
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
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Supplier");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(MENUTOSUPPLIER_MARKMODIFIED);
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
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.suppliers</code> attribute.
	 * @return the suppliers
	 */
	public List<Supplier> getSuppliers(final SessionContext ctx)
	{
		final List<Supplier> items = getLinkedItems( 
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOSUPPLIER,
			"Supplier",
			null,
			false,
			Utilities.getRelationOrderingOverride(MENUTOSUPPLIER_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OperationMenu.suppliers</code> attribute.
	 * @return the suppliers
	 */
	public List<Supplier> getSuppliers()
	{
		return getSuppliers( getSession().getSessionContext() );
	}
	
	public long getSuppliersCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOSUPPLIER,
			"Supplier",
			null
		);
	}
	
	public long getSuppliersCount()
	{
		return getSuppliersCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.suppliers</code> attribute. 
	 * @param value the suppliers
	 */
	public void setSuppliers(final SessionContext ctx, final List<Supplier> value)
	{
		setLinkedItems( 
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOSUPPLIER,
			null,
			value,
			false,
			Utilities.getRelationOrderingOverride(MENUTOSUPPLIER_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOSUPPLIER_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OperationMenu.suppliers</code> attribute. 
	 * @param value the suppliers
	 */
	public void setSuppliers(final List<Supplier> value)
	{
		setSuppliers( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to suppliers. 
	 * @param value the item to add to suppliers
	 */
	public void addToSuppliers(final SessionContext ctx, final Supplier value)
	{
		addLinkedItems( 
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOSUPPLIER,
			null,
			Collections.singletonList(value),
			false,
			Utilities.getRelationOrderingOverride(MENUTOSUPPLIER_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOSUPPLIER_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to suppliers. 
	 * @param value the item to add to suppliers
	 */
	public void addToSuppliers(final Supplier value)
	{
		addToSuppliers( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from suppliers. 
	 * @param value the item to remove from suppliers
	 */
	public void removeFromSuppliers(final SessionContext ctx, final Supplier value)
	{
		removeLinkedItems( 
			ctx,
			false,
			ZddsopfacadesConstants.Relations.MENUTOSUPPLIER,
			null,
			Collections.singletonList(value),
			false,
			Utilities.getRelationOrderingOverride(MENUTOSUPPLIER_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOSUPPLIER_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from suppliers. 
	 * @param value the item to remove from suppliers
	 */
	public void removeFromSuppliers(final Supplier value)
	{
		removeFromSuppliers( getSession().getSessionContext(), value );
	}
	
}
