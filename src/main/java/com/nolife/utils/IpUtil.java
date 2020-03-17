package com.nolife.utils;

import com.nolife.common.Constants;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取远程访问用户的真实ip
 * 
 * @author 胡砥峰
 * 
 * @mail hdfyq@qq.com
 * 
 * @date 2016年11月10日
 *
 */
public class IpUtil {

	/**
	 * 获取访问者的真实ip
	 *
	 * 服务器nginx转发，导致无法用InetAddress.getLocalHost()获取地址-nginx将用户真实ip设置到header-获取ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		return request.getHeader(Constants.NGINX_REAL_IP);
//		String ipAddress = request.getHeader("x-forwarded-for");
//		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//			ipAddress = request.getHeader("Proxy-Client-IP");
//		}
//		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//			ipAddress = request.getHeader("WL-Proxy-Client-IP");
//		}
//		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
//			ipAddress = request.getRemoteAddr();
//			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
//				// 根据网卡取本机配置的IP
//				InetAddress inet = null;
//				try {
//					inet = InetAddress.getLocalHost();
//				} catch (UnknownHostException e) {
//					//e.printStackTrace();
//					System.out.println("getLocalhost");
//				}
//				ipAddress = inet.getHostAddress();
//			}
//		}
//		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
//		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length() = 15
//			if (ipAddress.indexOf(",") > 0) {
//				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
//			}
//		}
//		return ipAddress;
	}

	public static void main(String[] args) {

	}

}
