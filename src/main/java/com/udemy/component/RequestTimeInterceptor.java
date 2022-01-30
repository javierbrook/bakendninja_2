package com.udemy.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.udemy.repository.LogRepository;

import lombok.extern.java.Log;

@Log
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter  {

	@Autowired
	private LogRepository logRepository;
	
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
		
		String url = request.getRequestURL().toString();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if(auth != null) {
			if(auth.isAuthenticated()) {
				username = auth.getName();
			}
			logRepository.save(new com.udemy.entity.Log(new Date(), auth.getDetails().toString(), username, url)); 
		}
		
		log.info("--REQUEST URL: '"+url+"' --TOTAL TIME: '"+(System.currentTimeMillis() - (long)request.getAttribute("startTime"))+"'ms" );
	}
	
}
