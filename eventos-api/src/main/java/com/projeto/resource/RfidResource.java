package com.projeto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.RfidController;
import com.projeto.model.Rfid;

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
	public Page<Rfid> cadastrarTag(Pageable page) {
		return rfControl.buscarTodas(page);
	}
}
