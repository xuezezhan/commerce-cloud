
package com.zdds.core.util;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author 李亚廷
 * @time 2017年11月8日 上午11:40:59
 * @since JDK 1.8
 */

public class DaoUtils {

	private final static Logger LOG = LoggerFactory.getLogger(DaoUtils.class);

	public static <T> T getUnique(final FlexibleSearchService flexibleSearchService, final String type, final String key,
                                  final String value) throws AmbiguousIdentifierException {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		final FlexibleSearchQuery query = new FlexibleSearchQuery(
				"SELECT {p.pk} FROM {" + type + " AS p} WHERE {p." + key + "}=?val ");
		query.addQueryParameter("val", value);
		List<T> tList = flexibleSearchService.<T>search(query).getResult();
		if (CollectionUtils.isEmpty(tList) || tList.size() <= 0) {
//            LOG.info(type + "====with code " + value + " is not found ===");
			return null;
		} else if (tList.size() > 1) {
			throw new AmbiguousIdentifierException(type + "  with code '" + value + "' is not unique. " + tList.size()
					+ "  found!");
		}
		return tList.get(0);
	}

	public static <T> List<T> getList(final FlexibleSearchService flexibleSearchService, final String type, final String key,
                                      final Object value) throws ModelNotFoundException, AmbiguousIdentifierException {
		final FlexibleSearchQuery query = new FlexibleSearchQuery(
				"SELECT {p.pk} FROM {" + type + " AS p} WHERE {p." + key + "}=?val ");
		query.addQueryParameter("val", value);
		try {
			return flexibleSearchService.<T>search(query).getResult();
		} catch (final Exception e) {
			e.printStackTrace();
			return new ArrayList<T>();
		}
	}

	public static <T> List<T> findResemble(final FlexibleSearchService flexibleSearchService, final String type, final String key,
                                           final Object value) throws ModelNotFoundException, AmbiguousIdentifierException {
		final FlexibleSearchQuery query = new FlexibleSearchQuery(
				"SELECT {p.pk} FROM {" + type + " AS p} WHERE {p." + key + "} like ?val ");
		query.addQueryParameter("val", '%' + value.toString() + '%');
		try {
			return flexibleSearchService.<T>search(query).getResult();
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> List<T> getAll(final FlexibleSearchService flexibleSearchService, final String type)
			throws ModelNotFoundException, AmbiguousIdentifierException {
		final FlexibleSearchQuery query = new FlexibleSearchQuery("SELECT {p.pk} FROM {" + type + " AS p}");
		try {
			return flexibleSearchService.<T>search(query).getResult();
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public static <T> T getString(final FlexibleSearchService flexibleSearchService, final String type, final String key,
                                  final String returnValue, final Object value) throws ModelNotFoundException, AmbiguousIdentifierException {
		final FlexibleSearchQuery query = new FlexibleSearchQuery(
				"SELECT {p." + returnValue + "} FROM {" + type + " AS p} WHERE {p." + key + "}=?val ");
		query.addQueryParameter("val", value);
		query.setResultClassList(Arrays.asList(String.class));
		try {
			return flexibleSearchService.<T>search(query).getResult().get(0);
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> List<T> getListBySql(final FlexibleSearchService flexibleSearchService, final String sql)
			throws ModelNotFoundException, AmbiguousIdentifierException {
		final FlexibleSearchQuery query = new FlexibleSearchQuery(sql);
		try {
			return flexibleSearchService.<T>search(query).getResult();
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
