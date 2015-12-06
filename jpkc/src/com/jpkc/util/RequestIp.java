package com.jpkc.util;

import javax.servlet.http.HttpServletRequest;

public class RequestIp {
	public static String getRemoteHost(final HttpServletRequest request) {
        try{
            String remoteAddr = request.getHeader("X-Forwarded-For");
            // 如果通过多级反向代理，X-Forwarded-For的值不止一个，而是一串用逗号分隔的IP值，此时取X-Forwarded-For中第一个非unknown的有效IP字符串
            if (isEffective(remoteAddr) && (remoteAddr.indexOf(",") > -1)) {
                String[] array = remoteAddr.split(",");
                for (String element : array) {
                    if (isEffective(element)) {
                        remoteAddr = element;
                        break;
                    }
                }
            }
            if (!isEffective(remoteAddr)) {
                remoteAddr = request.getHeader("X-Real-IP");
            }
            if (!isEffective(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
            return remoteAddr.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":remoteAddr;
        }catch(Exception e){
          
            return "";
        }
    }
	
	
	
	 private static boolean isEffective(final String remoteAddr) {
	        boolean isEffective = false;
	        if ((null != remoteAddr) && (!"".equals(remoteAddr.trim()))
	                && (!"unknown".equalsIgnoreCase(remoteAddr.trim()))) {
	            isEffective = true;
	        }
	        return isEffective;
	    }
}
