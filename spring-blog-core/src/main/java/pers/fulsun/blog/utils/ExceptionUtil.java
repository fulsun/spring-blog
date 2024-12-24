package pers.fulsun.blog.utils;


import pers.fulsun.blog.common.exception.GlobalException;
import pers.fulsun.blog.common.exception.GlobalExceptionMap;

/**
 * @Description: 异常工具类
 * @author: fulsun
 */
public class ExceptionUtil {

    private ExceptionUtil() {}

    /**
     * 抛异常
     * @param globalExceptionMap
     */
    public static void throwEx(GlobalExceptionMap globalExceptionMap) {
        throw new GlobalException(globalExceptionMap, true);
    }

    /**
     * 抛异常
     * @param code
     * @param message
     */
    public static void throwEx(int code, String message) {
        throw new GlobalException(code, message);
    }

    /**
     * 抛异常到异常页面
     * @param globalExceptionMap
     */
    public static void throwExToPage(GlobalExceptionMap globalExceptionMap) {
        throw new GlobalException(globalExceptionMap, false);
    }

}
