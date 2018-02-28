package com.projeto.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.UsuarioController;
import com.projeto.model.Usuario;

@RestController
@RequestMapping("/api")
public class UsuarioResource {

	@Autowired
	UsuarioController usuController;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean logar(@RequestBody Usuario user) {
		return usuController.authenticate(user);
	}

}