package com.zdds.facades.utils;

import com.zddsop.data.PageResultBean;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 * 前台工具类
 * @author 李亚廷
 * @Date 13:12 2020/1/18
 * @since JDK 11
 */
public class ControllerPageUtil {

    private static Logger logger = Logger.getLogger(ControllerPageUtil.class);
    /**
     * 获取分页参数
     * @param request
     * @return
     */
    public static PageableData getPageableData(HttpServletRequest request){
        PageableData pageableData = new PageableData();
        String pageStr = request.getParameter("page");
        String limitStr = request.getParameter("limit");
        String sortStr = request.getParameter("sort");
        int page = 0;
        int limit = 10;
        try{
            if(StringUtils.isNotBlank(pageStr)){
                page = Integer.parseInt(pageStr);
            }
            if(StringUtils.isNotBlank(limitStr)){
                limit = Integer.parseInt(limitStr);
            }
        }catch (NumberFormatException e){
            logger.error("page = " + pageStr + "; limit = "+ limitStr + ";转换错误！",e);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        pageableData.setPageSize(limit);
        if(page >0 ){
            pageableData.setCurrentPage(page - 1);
        }else {
            pageableData.setCurrentPage(page);
        }

        pageableData.setSort(sortStr);
        return pageableData;
    }

    /**
     * 获取查询参数
     * @return
     */
    public static Map<String, Object> getRequestParam(HttpServletRequest request){
        Map<String, Object> params = new HashMap<String, Object>();
        Set<String> param = request.getParameterMap().keySet();
        for(String key :param){
            if("page".equals(key) || "limit".equals(key) || "sort".equals(key)){
                continue;
            }else if(request.getParameterMap().get(key) == null || StringUtils.isBlank(request.getParameterMap().get(key)[0])){
                continue;
            }
            params.put(key, request.getParameterMap().get(key)[0]);
        }
        return params;
    }

    /**
     * 获取查询结果
     * @param searchPageData 查询结果
     * @param msg 返回纤细
     * @param statusCode 状态码 0为无异常，
     * @return
     */
    public static PageResultBean getPageResultBean(SearchPageData searchPageData, String msg, int statusCode){
        PageResultBean pageResultBean = new PageResultBean();
        if(searchPageData != null){
            pageResultBean.setData(searchPageData.getResults());
            pageResultBean.setCount(searchPageData.getPagination().getTotalNumberOfResults());
        }
        pageResultBean.setMsg(msg);
        pageResultBean.setCode(statusCode);
        return pageResultBean;
    }

    /**
     * 获取查询结果
     * @param searchPageData 查询结果
     * @param msg 返回纤细
     * @param statusCode 状态码 0为无异常，
     * @return
     */
    public static PageResultBean getAllResultBean(SearchPageData searchPageData, SearchPageData searchAllData, String msg, int statusCode){
        PageResultBean pageResultBean = new PageResultBean();
        if(searchPageData != null){
            pageResultBean.setData(searchPageData.getResults());
            pageResultBean.setCount(searchPageData.getPagination().getTotalNumberOfResults());
        }
        if(searchAllData != null){
            pageResultBean.setAllData(searchAllData.getResults());
        }
        pageResultBean.setMsg(msg);
        pageResultBean.setCode(statusCode);
        return pageResultBean;
    }
}
