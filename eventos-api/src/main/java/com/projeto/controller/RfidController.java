package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.projeto.model.Rfid;
import com.projeto.repository.RfidRepository;

@Controller
public class RfidController {
	
	@Autowired
	RfidRepository rfRepo;
	
	
	public boolean cadastrar(Rfid rfid) {
		if(rfRepo.save(rfid) != null) {
			return true;
		}
		return false;
	}
	
	public Page<Rfid> buscarTodas(Pageable page) {
		return rfRepo.findAll(page);
		//return rfRepo.busca();
	}
}
