package com.eventosapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventosapp.models.Usuario;
import com.eventosapp.repository.UsuarioRepository;

@Controller
public class LoginController {
	
	//@Autowired
	//UsuarioRepository ur;
	
	@PostMapping("/login")
	public String login(Usuario usuario,HttpSession session,RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView();
		if(usuario.getNome().equals("admin")&&usuario.getSenha().equals("1234")) {
			usuario.setNome("Administrador");
			//guardar sessao o objeto usuario
			session.setAttribute("usuarioLogado", usuario);
			return "index";
		}else {
			ra.addFlashAttribute("msg","Login/senha invalidos!");
			return "redirect:/";
		}
		
	}
	
	/********metodo pra validar login e senha vinda do banco de dados***********/
	/*
	@PostMapping("/login")
	public String login(Usuario usuario,HttpSession session,RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView();
		usuario = this.ur.findByLoginAndSenha(usuario.getNome(), usuario.getSenha());
		if(usuario!=null) {		
			//guardar sessao o objeto usuario
			session.setAttribute("usuarioLogado", usuario);
			return "index";
		}else {
			ra.addFlashAttribute("msg","Login/senha invalidos!");
			return "redirect:/";
		}
		
	}*/


	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
