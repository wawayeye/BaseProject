package com.tuandai.baseproject.util;

import com.alibaba.druid.util.StringUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class RequestCommon {
    public static final String LOCAL_IP = "127.0.0.1";//本地ip地址
    public static final String DEFAULT_IP = "0:0:0:0:0:0:0:1";//默认ip地址
    public static final int DEFAULT_IP_LENGTH = 15;//默认ip地址长度

    /**
     * 获取合法ip地址
     * @param request
     * @return
     */
    public static String getRealIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");//squid 服务代理
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");//apache服务代理
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");//weblogic 代理
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");//有些代理
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP"); //nginx代理
        }

    /*
    * 如果此时还是获取不到ip地址，那么最后就使用request.getRemoteAddr()来获取
    * */
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(StringUtils.equals(ip,LOCAL_IP) || StringUtils.equals(ip,DEFAULT_IP)){
                //根据网卡取本机配置的IP
                InetAddress iNet = null;
                try {
                    iNet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
//                    logger.error("InetAddress getLocalHost error In HttpUtils getRealIpAddress: " ,e);
                    System.out.println("InetAddress getLocalHost error In HttpUtils getRealIpAddress: " +e);
                }
                ip= iNet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        //"***.***.***.***".length() = 15
        if(!StringUtils.isEmpty(ip) && ip.length()> DEFAULT_IP_LENGTH){
            if(ip.indexOf(",") > 0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }


}
