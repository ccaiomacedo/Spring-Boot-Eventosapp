package com.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.models.Eventos;
import com.eventosapp.repository.EventoRepository;

@Controller // definindo a classe como controller
// ela que recebe requisições e da respostas
public class EventosController {
	
	@Autowired //faz injeção de dependências 
	private EventoRepository er;//pra toda vez que eu usar essa interface ele fazer as instâncias automaticamente
	
	@RequestMapping(value="/cadastrarEvento",method=RequestMethod.GET) // recebendo uma requisição do tipo get
	public String form() {
		return "evento/formEvento";
	}
	@RequestMapping(value="/cadastrarEvento",method=RequestMethod.POST) // recebendo uma requisição do tipo post
	public String form(Eventos evento) {
		er.save(evento); //salva o evento no banco de dados
		return "redirect:/cadastrarEvento";//redireciona pra cadastrarEvento
	}
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv= new ModelAndView("index");//estou especificando qual classe será renderizada
		Iterable<Eventos> eventos = er.findAll();//retorna uma lista,busca essa lista de eventos no banco de dados
		mv.addObject("Eventos",eventos);
		return mv;
		
	}
	@RequestMapping("/{codigo}")//retorna o codigo de cada evento
	public ModelAndView detalhesEvento(@PathVariable("codigo") Long codigo) {
		Eventos evento = er.findByCodigo(codigo);//está guardando a ação findByCodigo na variavel evento
		ModelAndView mv= new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento",evento);
		System.out.println("evento"+evento);
		return mv;
	}
	
}
