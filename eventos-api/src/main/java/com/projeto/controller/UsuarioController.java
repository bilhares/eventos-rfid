package com.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioRepository usuRepo;

	public boolean authenticate(Usuario usuario) {
		Usuario user = usuRepo.findUsuarioByEmail(usuario.getEmail());

		if (user != null) {
			boolean hash = new BCryptPasswordEncoder().matches(usuario.getSenha(), user.getSenha());
			if (hash) {
				return true;
			}
		}
		System.out.println("NOME : " + user.getNome());
		return false;
	}

}
