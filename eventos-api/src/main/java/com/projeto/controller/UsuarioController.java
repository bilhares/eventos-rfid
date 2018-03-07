package com.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import com.projeto.model.Evento;
import com.projeto.model.IngressoUsuario;
import com.projeto.model.Usuario;
import com.projeto.repository.IngressoUsuarioRepository;
import com.projeto.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioRepository usuRepo;
	@Autowired
	IngressoUsuarioRepository ingUsuRepo;

	public Usuario authenticate(Usuario usuario) {
		Usuario user = usuRepo.findUsuarioByEmail(usuario.getEmail());

		if (user != null) {
			boolean hash = new BCryptPasswordEncoder().matches(usuario.getSenha(), user.getSenha());
			if (hash) {
				return user;
			}
		}
		System.out.println("NOME : " + user.getNome());
		return null;
	}

	public boolean cadastrar(Usuario user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode(user.getSenha());
		user.setSenha(encode);
		if (usuRepo.save(user) != null) {
			return true;
		}
		return false;
	}

	public boolean ingressar(IngressoUsuario ingressoUsuario) {
		if (ingUsuRepo.save(ingressoUsuario) != null) {
			return true;
		}
		return false;
	}

}
