package com.eventosapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventosController {
	@RequestMapping("/cadastrarEvento")
	public String form() {
		return "evento/formEvento";
	}
	
}
