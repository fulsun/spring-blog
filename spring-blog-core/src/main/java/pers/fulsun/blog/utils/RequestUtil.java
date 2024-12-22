package pers.fulsun.blog.utils;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Http 工具类
 *
 * @author fulsun
 */
public class RequestUtil {
    /**
     * 对应 nginx 配置中的请求头，获取真实 ip 地址
     */
    private static final String[] HEADER_ARR = {"X-Real-IP", "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP"};
    private static final String IP_V4 = "127.0.0.1";
    private static final String IP_V6 = "0:0:0:0:0:0:0:1";
    private static final String UN_KNOW = "unknown";
    private static final String DEFAULT_SEPARATOR = ",";
    private static final Integer LENGTH = 15;

    /**
     * 获取本地主机 ip
     */
    public static String getHostIp() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();
                    if (ip != null
                            && ip instanceof Inet4Address
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1) {
                        return ip.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IP_V4;
    }

    /**
     * 获取客户端真实 ip
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader(HEADER_ARR[0]);
        if (StringUtils.isBlank(ipAddress) || UN_KNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(HEADER_ARR[1]);
        }

        if (StringUtils.isBlank(ipAddress) || UN_KNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(HEADER_ARR[2]);
        }

        if (StringUtils.isBlank(ipAddress) || UN_KNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(HEADER_ARR[3]);
        }

        if (StringUtils.isBlank(ipAddress) || UN_KNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();

            if (ipAddress.equals(IP_V4) || ipAddress.equals(IP_V6)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }

                ipAddress = inet.getHostAddress();
            }
        }

        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (StringUtils.isNotBlank(ipAddress)  && ipAddress.length() > LENGTH) {
            if (ipAddress.indexOf(DEFAULT_SEPARATOR) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(DEFAULT_SEPARATOR));
            }
        }

        return ipAddress;
    }
}
