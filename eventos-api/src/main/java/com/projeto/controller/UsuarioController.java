package com.projeto.controller;

import java.util.List;

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
	@Autowired
	ImageController imgController;

	public Usuario authenticate(Usuario usuario) {
		Usuario user = usuRepo.findUsuarioByEmail(usuario.getEmail());

		if (user != null) {
			boolean hash = new BCryptPasswordEncoder().matches(usuario.getSenha(), user.getSenha());
			System.out.println("NOME : " + user.getNome());
			if (hash) {
				return user;
			}
		}
		return null;
	}

	public boolean cadastrar(Usuario user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode(user.getSenha());
		user.setSenha(encode);

		String img = imgController.saveImageS3(user.getByteFoto());
		user.setFoto(img);
		System.out.println("foto " + img);

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

	public List<Usuario> listar() {
		return usuRepo.findAll();
	}
}
