/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 2020年3月4日 上午9:02:14                         ---
 * ----------------------------------------------------------------
 */
package com.zdds.core.constants;

/**
 * @deprecated since ages - use constants in Model classes instead
 */
@Deprecated
@SuppressWarnings({"unused","cast"})
public class GeneratedZddsCoreConstants
{
	public static final String EXTENSIONNAME = "zddscore";
	public static class TC
	{
		public static final String APPARELPRODUCT = "ApparelProduct".intern();
		public static final String APPARELSIZEVARIANTPRODUCT = "ApparelSizeVariantProduct".intern();
		public static final String APPARELSTYLEVARIANTPRODUCT = "ApparelStyleVariantProduct".intern();
		public static final String BLTYPE = "BLType".intern();
		public static final String BRAND = "Brand".intern();
		public static final String CARRIER = "Carrier".intern();
		public static final String CHECKSTATUS = "CheckStatus".intern();
		public static final String DELIVERYINFO = "DeliveryInfo".intern();
		public static final String DEPARTMENT = "Department".intern();
		public static final String ELECTRONICSCOLORVARIANTPRODUCT = "ElectronicsColorVariantProduct".intern();
		public static final String INVOICE = "Invoice".intern();
		public static final String INVOICETYPE = "InvoiceType".intern();
		public static final String LEVEL = "Level".intern();
		public static final String ORDERTYPE = "OrderType".intern();
		public static final String POSITION = "Position".intern();
		public static final String SERVICERECORD = "ServiceRecord".intern();
		public static final String SERVICESTATUS = "ServiceStatus".intern();
		public static final String SETTLEIN = "SettleIn".intern();
		public static final String SKILL = "Skill".intern();
		public static final String SUPPLIER = "Supplier".intern();
		public static final String SWATCHCOLORENUM = "SwatchColorEnum".intern();
	}
	public static class Attributes
	{
		public static class Category
		{
			public static final String LEVEL = "level".intern();
			public static final String SETTLEINS = "settleins".intern();
		}
		public static class Consignment
		{
			public static final String DELIVERYINFOES = "deliveryInfoes".intern();
			public static final String SUPPLIER = "supplier".intern();
		}
		public static class Customer
		{
			public static final String PHONE = "phone".intern();
			public static final String REALNAME = "realName".intern();
		}
		public static class Employee
		{
			public static final String DEPARTMENT = "department".intern();
			public static final String EMPORDERS = "empOrders".intern();
			public static final String GENDER = "gender".intern();
			public static final String IDNUMBER = "idNumber".intern();
			public static final String ISSUPPLIER = "isSupplier".intern();
			public static final String POSITION = "position".intern();
			public static final String SKILLS = "skills".intern();
			public static final String TELEPHONE = "telephone".intern();
		}
		public static class Order
		{
			public static final String DEPARTMENT = "department".intern();
			public static final String EMPLOYEES = "employees".intern();
			public static final String ILLUSTRATION = "illustration".intern();
			public static final String INVOICE = "invoice".intern();
			public static final String ISPRESENT = "isPresent".intern();
			public static final String ORDERTYPE = "orderType".intern();
			public static final String RECOMMENDER = "recommender".intern();
			public static final String REMARK = "remark".intern();
			public static final String SERVICERECORDS = "serviceRecords".intern();
			public static final String SERVICESTATUS = "serviceStatus".intern();
		}
		public static class Product
		{
			public static final String BRAND = "brand".intern();
			public static final String CHECKSTATUS = "checkStatus".intern();
			public static final String COMMISSION = "commission".intern();
			public static final String DELIVERYCHARGE = "deliveryCharge".intern();
			public static final String MODEL = "model".intern();
			public static final String SALESVOLUME = "salesVolume".intern();
			public static final String TAXPOINT = "taxPoint".intern();
		}
	}
	public static class Enumerations
	{
		public static class BLType
		{
			public static final String UNIFY = "UNIFY".intern();
			public static final String NORMAL = "NORMAL".intern();
			public static final String UNUNIFY = "UNUNIFY".intern();
		}
		public static class CheckStatus
		{
			public static final String PENDINGREVIEW = "PENDINGREVIEW".intern();
			public static final String APPROVED = "APPROVED".intern();
			public static final String UNAPPROVED = "UNAPPROVED".intern();
		}
		public static class InvoiceType
		{
			public static final String GENERAL = "GENERAL".intern();
		}
		public static class Level
		{
			public static final String ONE = "ONE".intern();
			public static final String TWO = "TWO".intern();
			public static final String THREE = "THREE".intern();
		}
		public static class OrderType
		{
			public static final String APPLIANCE = "APPLIANCE".intern();
			public static final String SERVICE = "SERVICE".intern();
		}
		public static class Position
		{
			public static final String SUPPORTSTAFF = "SUPPORTSTAFF".intern();
			public static final String ELECTRICIAN = "ELECTRICIAN".intern();
		}
		public static class ServiceStatus
		{
			public static final String CREATED = "CREATED".intern();
			public static final String DISTRIBUTED = "DISTRIBUTED".intern();
			public static final String DEPARTING = "DEPARTING".intern();
			public static final String MAINTAINING = "MAINTAINING".intern();
			public static final String CONFIRMING = "CONFIRMING".intern();
			public static final String PAYING = "PAYING".intern();
			public static final String EVALUATING = "EVALUATING".intern();
			public static final String COMPLETED = "COMPLETED".intern();
		}
		public static class SwatchColorEnum
		{
			public static final String BLACK = "BLACK".intern();
			public static final String BLUE = "BLUE".intern();
			public static final String BROWN = "BROWN".intern();
			public static final String GREEN = "GREEN".intern();
			public static final String GREY = "GREY".intern();
			public static final String ORANGE = "ORANGE".intern();
			public static final String PINK = "PINK".intern();
			public static final String PURPLE = "PURPLE".intern();
			public static final String RED = "RED".intern();
			public static final String SILVER = "SILVER".intern();
			public static final String WHITE = "WHITE".intern();
			public static final String YELLOW = "YELLOW".intern();
		}
	}
	public static class Relations
	{
		public static final String CONSIGNMENT2DELIVERYINFO = "Consignment2DeliveryInfo".intern();
		public static final String DEPARTMENT2DEPARTMENT = "Department2Department".intern();
		public static final String EMPLOYEE2SKILL = "Employee2Skill".intern();
		public static final String ORDER2EMPLOYEE = "Order2Employee".intern();
		public static final String ORDER2SERVICERECORD = "Order2ServiceRecord".intern();
		public static final String SETTLEIN2CATEGORY = "SettleIn2Category".intern();
	}
	
	protected GeneratedZddsCoreConstants()
	{
		// private constructor
	}
	
	
}
