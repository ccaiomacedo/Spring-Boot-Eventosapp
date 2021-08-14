package com.eventosapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.models.Usuario;
//teste
@Controller
public class IndexController {
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login/login");
		mv.addObject("usuario",new Usuario());
		return mv;
	}
}
