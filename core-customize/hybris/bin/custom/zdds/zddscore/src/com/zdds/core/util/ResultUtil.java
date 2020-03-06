package com.zdds.core.util;


import com.zdds.core.bean.ResultDTO;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Map;

/**

 *@params
 *@return
 *@author  李亚廷
 *@time  2018/7/28
 *@since  JDK 1.8
 */
public class ResultUtil {

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE =500;
    public static final String SUCCESS_MSG = "success";


    /**
     * 查询列表数据成功
     *
     * @param data
     *            model转化后的数据list
     * @param total
     *            表示经过查询条件筛选后数据记录总条数，前端需要根据这个做分页
     * @param <T>
     *            所查model转化后的数据类型
     * @return result
     */
    public static <T> ResultDTO<List<T>> success(List<T> data, int total) {
        ResultDTO<List<T>> result = new ResultDTO<>();
        ResultUtil.setResultDTOPatch(result, data);
        result.setTotal(total);
        return result;
    }


    /**
     * 查询列表数据成功
     *
     * @param data
     *            model转化后的数据list
     * @param total
     *            表示经过查询条件筛选后数据记录总条数，前端需要根据这个做分页
     * @param <T>
     *            所查model转化后的数据类型
     * @param map
     *            排序信息
     * @return result
     */
    public static <T> ResultDTO<List<T>> success(List<T> data, int total , Map<String,String> map) {
        ResultDTO<List<T>> result = new ResultDTO<>();
        ResultUtil.setResultDTOPatch(result, data);
        result.setTotal(total);
        result.setSortInfo(map);
        return result;
    }


    /**
     * 查询单条数据成功
     *
     * @param data
     *            model转化后的数据
     * @param <T>
     *            所查model转化后的数据类型
     * @return result
     */
    public static <T> ResultDTO<T> success(T data) {
        ResultDTO<T> result = new ResultDTO<>();
        result.setStatus("S");
        ResultUtil.setResultDTOPatch(result, data);
        return result;
    }

    /**
     * 查询单条数据成功
     *
     * @param data
     *            model转化后的数据
     * @param msg
     *            返回到前台的说明信息
     * @param <T>
     *            所查model转化后的数据类型
     * @return result
     */
    public static <T> ResultDTO<T> success(T data, String msg) {
        ResultDTO<T> result = new ResultDTO<>();
        ResultUtil.setResultDTOPatch(result, data);
        result.setMsg(msg);
        result.setStatus("S");
        result.setCode(SUCCESS_CODE);
        return result;
    }

    /**
     * 执行某个动作成功
     *
     * @param msg
     *            返回到前台的说明信息
     * @return result
     */
    public static ResultDTO success(String msg) {
        ResultDTO result = new ResultDTO<>();
        result.setSuccess(true);
        result.setStatus("S");
        result.setCode(SUCCESS_CODE);
        result.setMsg(msg);
        return result;
    }

    /**
     * 执行某个动作成功
     *
     * @param succeed
     *            返回到前台的说明信息 成功条数
     * @param fail
     *            返回到前台的说明信息 失败条数
     * @return result
     */
    public static ResultDTO success(int succeed, int fail) {
        ResultDTO result = new ResultDTO<>();
        result.setSuccess(true);
        result.setStatus("S");
        result.setCode(SUCCESS_CODE);
        result.setMsg("成功" + succeed + "条,失败+" + fail + "条");
        return result;
    }

    /**
     * 执行某个动作成功
     *
     * @return result
     */
    public static ResultDTO success() {
        ResultDTO result = new ResultDTO<>();
        result.setSuccess(true);
        result.setStatus("S");
        result.setCode(SUCCESS_CODE);
        return result;
    }

    /**
     * 请求失败
     *
     * @param msg
     *            返回到前台的说明信息
     * @return result
     */
    public static <T> ResultDTO<T> fail(String msg) {
        ResultDTO<T> result = new ResultDTO<>();
        result.setSuccess(false);
        result.setStatus("E");
        result.setCode(FAIL_CODE);
        result.setMsg(msg);
        return result;
    }

    /**
     * 请求失败
     *
     * @param msg
     *            返回到前台的说明信息
     * @return result
     */
    public static <T> ResultDTO<T> fail(T data, String msg) {
        ResultDTO<T> result = new ResultDTO<>();
        result.setSuccess(false);
        result.setStatus("E");
        result.setCode(FAIL_CODE);
        result.setDatas(data);
        result.setMsg(msg);
        return result;
    }

    /**
     * 执行某个动作失败
     *
     * @param succeed
     *            返回到前台的说明信息 失败条数
     * @param fail
     *            返回到前台的说明信息 失败条数
     * @return result
     */
    public static ResultDTO fail(int succeed, int fail) {
        ResultDTO result = new ResultDTO<>();
        result.setSuccess(false);
        result.setStatus("E");
        result.setMsg("成功" + succeed + "条,失败" + fail + "条");
        return result;
    }

    /**
     * 请求失败,并返回失败数据,用于和其它平台交互
     *
     * @param data
     *            失败数据
     * @param mes
     *            返回到前台的说明信息
     * @return result
     */
    public static <T> ResultDTO<List<T>> fail(List<T> data, String mes) {
        ResultDTO<List<T>> result = new ResultDTO<>();
        result.setSuccess(false);
        result.setDatas(data);
        result.setStatus("E");
        result.setMsg(mes);
        return result;
    }



    private static <T> void setResultDTOPatch(ResultDTO<T> result, T data) {
        result.setStatus("S");
        result.setDatas(data);
        result.setMsg(SUCCESS_MSG);
        result.setSuccess(true);
    }

    /**
     * 为空时返回默认值
     */
    private static <T> T defVal(T value, T deful) {
        return ObjectUtils.defaultIfNull(value, deful);
    }

}
