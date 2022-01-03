package com.udemy.bakendninja_2.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter  {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	//Se ejecuta 1ro, cuando comeienza la petición
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	//Se ejecuta 2ro, justo antes de comenzar a cargar la página resultante en el navegador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOG.info("--REQUEST URL: '"+request.getRequestURL().toString()+"' --TOTAL TIME: '"+(System.currentTimeMillis() - (long)request.getAttribute("startTime"))+"'ms" );
	}
	
}
