package com.projeto.resource;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.RfidController;
import com.projeto.model.Rfid;
import com.projeto.model.Usuario;

@RestController
@RequestMapping("/api")
public class RfidResource {

	@Autowired
	RfidController rfControl;

	// cadastra uma tag no sistema
	@RequestMapping(value = "/rfid", method = RequestMethod.POST)
	public boolean cadastrarTag(@RequestBody Rfid rfid) {
		return rfControl.cadastrar(rfid);
	}

	// busca todas as tags
	@RequestMapping(value = "/rfid", method = RequestMethod.GET)
	public Page<Rfid> buscaTag(Pageable page) {
		return rfControl.buscarTodas(page);
	}

	// busca todas as tags
	@RequestMapping(value = "/rfid/{id}", method = RequestMethod.GET)
	public Usuario buscaUser(@PathVariable("id") String id) {
		BigInteger bi = new BigInteger(id, 16);
		System.out.println(bi);
		return rfControl.buscarUserByTag(Long.parseLong(bi.toString()));
	}
}
