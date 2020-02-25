/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年2月25日 下午8:28:52                        ---
 * ----------------------------------------------------------------
 */
package com.zdds.facades.jalo;

import com.zdds.facades.constants.ZddsopfacadesConstants;
import com.zdds.facades.jalo.MenuGroup;
import com.zdds.facades.jalo.OperationMenu;
import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Employee;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type <code>ZddsopfacadesManager</code>.
 */
@SuppressWarnings({"unused","cast"})
@SLDSafe
public class ZddsopfacadesManager extends Extension
{
	/** Relation ordering override parameter constants for MenuToEmployee from ((zddsopfacades))*/
	protected static String MENUTOEMPLOYEE_SRC_ORDERED = "relation.MenuToEmployee.source.ordered";
	protected static String MENUTOEMPLOYEE_TGT_ORDERED = "relation.MenuToEmployee.target.ordered";
	/** Relation disable markmodifed parameter constants for MenuToEmployee from ((zddsopfacades))*/
	protected static String MENUTOEMPLOYEE_MARKMODIFIED = "relation.MenuToEmployee.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
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
	
	public MenuGroup createMenuGroup(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("MenuGroup");
			return (MenuGroup)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating MenuGroup : "+e.getMessage(), 0 );
		}
	}
	
	public MenuGroup createMenuGroup(final Map attributeValues)
	{
		return createMenuGroup( getSession().getSessionContext(), attributeValues );
	}
	
	public OperationMenu createOperationMenu(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("OperationMenu");
			return (OperationMenu)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating OperationMenu : "+e.getMessage(), 0 );
		}
	}
	
	public OperationMenu createOperationMenu(final Map attributeValues)
	{
		return createOperationMenu( getSession().getSessionContext(), attributeValues );
	}
	
	public static final ZddsopfacadesManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ZddsopfacadesManager) em.getExtension(ZddsopfacadesConstants.EXTENSIONNAME);
	}
	
	@Override
	public String getName()
	{
		return ZddsopfacadesConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.menus</code> attribute.
	 * @return the menus
	 */
	public Collection<OperationMenu> getMenus(final SessionContext ctx, final Employee item)
	{
		final List<OperationMenu> items = item.getLinkedItems( 
			ctx,
			true,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			"OperationMenu",
			null,
			false,
			Utilities.getRelationOrderingOverride(MENUTOEMPLOYEE_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Employee.menus</code> attribute.
	 * @return the menus
	 */
	public Collection<OperationMenu> getMenus(final Employee item)
	{
		return getMenus( getSession().getSessionContext(), item );
	}
	
	public long getMenusCount(final SessionContext ctx, final Employee item)
	{
		return item.getLinkedItemsCount(
			ctx,
			true,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			"OperationMenu",
			null
		);
	}
	
	public long getMenusCount(final Employee item)
	{
		return getMenusCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.menus</code> attribute. 
	 * @param value the menus
	 */
	public void setMenus(final SessionContext ctx, final Employee item, final Collection<OperationMenu> value)
	{
		item.setLinkedItems( 
			ctx,
			true,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			null,
			value,
			false,
			Utilities.getRelationOrderingOverride(MENUTOEMPLOYEE_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOEMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Employee.menus</code> attribute. 
	 * @param value the menus
	 */
	public void setMenus(final Employee item, final Collection<OperationMenu> value)
	{
		setMenus( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to menus. 
	 * @param value the item to add to menus
	 */
	public void addToMenus(final SessionContext ctx, final Employee item, final OperationMenu value)
	{
		item.addLinkedItems( 
			ctx,
			true,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			null,
			Collections.singletonList(value),
			false,
			Utilities.getRelationOrderingOverride(MENUTOEMPLOYEE_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOEMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to menus. 
	 * @param value the item to add to menus
	 */
	public void addToMenus(final Employee item, final OperationMenu value)
	{
		addToMenus( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from menus. 
	 * @param value the item to remove from menus
	 */
	public void removeFromMenus(final SessionContext ctx, final Employee item, final OperationMenu value)
	{
		item.removeLinkedItems( 
			ctx,
			true,
			ZddsopfacadesConstants.Relations.MENUTOEMPLOYEE,
			null,
			Collections.singletonList(value),
			false,
			Utilities.getRelationOrderingOverride(MENUTOEMPLOYEE_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MENUTOEMPLOYEE_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from menus. 
	 * @param value the item to remove from menus
	 */
	public void removeFromMenus(final Employee item, final OperationMenu value)
	{
		removeFromMenus( getSession().getSessionContext(), item, value );
	}
	
}
