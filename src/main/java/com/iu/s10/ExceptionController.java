package com.iu.s10;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView getNull() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/error/404");
		return mv;
	}
	
	@ExceptionHandler(SQLException.class)
		public void setSql() {
	}
	
	@ExceptionHandler(Exception.class)
		public void getEx() {
	}
	
	@ExceptionHandler(Throwable.class)
	public void getAll() {
		
	}
}
