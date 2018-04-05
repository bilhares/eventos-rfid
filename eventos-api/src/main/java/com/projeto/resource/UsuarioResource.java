package com.projeto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.UsuarioController;
import com.projeto.model.Evento;
import com.projeto.model.IngressoUsuario;
import com.projeto.model.Usuario;

@RestController
@RequestMapping("/api")
public class UsuarioResource {

	@Autowired
	UsuarioController usuController;

	// loga no sistema
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Usuario logar(@RequestBody Usuario user) {
		return usuController.authenticate(user);
	}

	// cadastra user
	@RequestMapping(value = "/usuario/cadastrar", method = RequestMethod.POST)
	public boolean cadastrar(@RequestBody Usuario user) {
		return usuController.cadastrar(user);
	}

	// Ingressa o usuario em um evento
	@RequestMapping(value = "/usuario/ingressar", method = RequestMethod.POST)
	public boolean ingressar(@RequestBody IngressoUsuario ingresso) {
		return usuController.ingressar(ingresso);
	}

	// Ingressa o usuario em um evento
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<Usuario> listar() {
		return usuController.listar();
	}
}
