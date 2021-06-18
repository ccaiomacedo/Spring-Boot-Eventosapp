package com.eventosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventosapp.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
//	public Usuario findByLoginAndSenha(String login,String senha);
}
