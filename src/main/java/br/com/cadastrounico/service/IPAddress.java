package br.com.cadastrounico.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class IPAddress{

	private Logger logger = LoggerFactory.getLogger(IPAddress.class);
	
	private final String LOCALHOST_IPV4 = "127.0.0.1";
	private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";
	private final String UNKNOWN = "unknown";

	public String getClientIPAddress(HttpServletRequest request) {
		String clientIPAddress = request.getHeader("X-FORWARDED-FOR");
		if(!StringUtils.hasLength(clientIPAddress) || "UNKNOWN ".equals(clientIPAddress)) {
			clientIPAddress = request.getHeader("Prox-Client-IP");
		}
		if(!StringUtils.hasLength(clientIPAddress) || "UNKNOWN ".equals(clientIPAddress)) {
			clientIPAddress = request.getHeader("WL-Prox-Client-IP");
		}
		if(!StringUtils.hasLength(clientIPAddress) || "UNKNOWN ".equals(clientIPAddress)) {
			clientIPAddress = request.getRemoteAddr();
			if(LOCALHOST_IPV4.equals(clientIPAddress) || "0:0:0:0:0:0:0:1".equals(clientIPAddress)) {
				try {
					InetAddress inetAdress = InetAddress.getLocalHost();
					clientIPAddress = inetAdress.getHostAddress();
					
				} catch (UnknownHostException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		if(!StringUtils.hasLength(clientIPAddress) 
				&& clientIPAddress.length() > 15 
				&& clientIPAddress.indexOf(",") > 0){
					clientIPAddress = clientIPAddress.substring(0, clientIPAddress.indexOf(","));
				}
		return clientIPAddress;
	}
}
