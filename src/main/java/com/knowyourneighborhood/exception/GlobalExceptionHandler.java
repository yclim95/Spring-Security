package com.knowyourneighborhood.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{
	@ExceptionHandler(StoreNotFoundException.class)
	public String handleStoreNotFoundException(Model model, Exception ex) {
		model.addAttribute("error_message","Store does not exist!");
		return "view-store";
	}
}
