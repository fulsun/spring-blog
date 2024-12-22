package pers.fulsun.blog.utils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 浏览器工具类
 *
 * @author fulsun
 */

public class BrowserUtil {
    /**
     * 获取远程客户端系统名称
     *
     * @param httpServletRequest
     * @return
     */
    public static String getOsName(HttpServletRequest httpServletRequest) {
        String userAgent = httpServletRequest.getHeader("User-Agent");
        UserAgent userAgentParser = UserAgent.parseUserAgentString(userAgent);
        return userAgentParser.getOperatingSystem().getName();
    }

    /**
     * 获取远程客户端浏览器名称
     *
     * @param httpServletRequest
     * @return
     */
    public static Object getBrowserName(HttpServletRequest httpServletRequest) {
        Browser browser = getBrowser(httpServletRequest);
        return browser.getName();
    }

    /**
     * 获取远程客户端浏览器版本
     *
     * @param request
     * @return
     */
    public static String getBrowserVersion(HttpServletRequest request) {
        Browser browser = getBrowser(request);
        Version version = browser.getVersion(request.getHeader("User-Agent"));
        return version.getVersion();
    }

    /**
     * 获取远程客户端浏览器信息
     *
     * @param request
     * @return
     */
    public static String getBrowserInfo(HttpServletRequest request) {
        Browser browser = UserAgent.parseUserAgentString(request.getHeader("User-Agent")).getBrowser();
        Version version = browser.getVersion(request.getHeader("User-Agent"));
        return browser.getName() + "/" + version;
    }


    private static Browser getBrowser(HttpServletRequest request) {
        return UserAgent.parseUserAgentString(request.getHeader("User-Agent")).getBrowser();
    }
}
