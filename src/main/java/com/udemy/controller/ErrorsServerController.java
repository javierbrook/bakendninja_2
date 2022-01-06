package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice     //Esta anotación indica que es un controlador la excepciones (hay que deshabilitarlo para que los errores se vean en Consola)
public class ErrorsServerController {
	
	@ExceptionHandler(Exception.class)    //A esta anotación se le pasa como parámetro el tipo de Excepción a capturar
	public String showInternalServerError() {
		return "/error/500";
	}
}
