package com.uca.capas.tareanCapas4.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareanCapas4.domain.Product;

@Controller
public class MainController {
	
	@RequestMapping("/producto")
	public ModelAndView product() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("producto", new Product());
		mav.setViewName("producto");
		return mav;
	}
	
	@RequestMapping("/facturar")
	public ModelAndView facturar(@Valid @ModelAttribute Product producto, BindingResult respuesta) {
		ModelAndView mav = new ModelAndView();
		
		if(respuesta.hasErrors()) {
			mav.setViewName("producto");
		}
		else { 
			mav.addObject("prod", producto.getNombre());
			mav.setViewName("respuesta");
		}
		return mav;
	}
	
}
