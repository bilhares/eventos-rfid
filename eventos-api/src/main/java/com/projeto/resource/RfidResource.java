package com.projeto.resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.Rfid;

@RestController
@RequestMapping("/api")
public class RfidResource {

	// cadastra uma tag no sistema
	@RequestMapping(value = "/rfid", method = RequestMethod.POST)
	public void cadastrarTag(@RequestBody Rfid rfid) {
	}

	// busca todas as tags
	@RequestMapping(value = "/rfid", method = RequestMethod.GET)
	public void cadastrarTag() {
	}
}
