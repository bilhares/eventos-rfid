package com.projeto.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.projeto.model.Rfid;
import com.projeto.model.Usuario;
import com.projeto.repository.RfidRepository;

@Controller
public class RfidController {
	
	@Autowired
	RfidRepository rfRepo;
	@PersistenceContext
	private EntityManager manager;
	
	
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
	
	public Usuario buscarUserByTag(Long id) {
		Query q = null;

		q = manager.createNativeQuery("select u.* from tb_evento e \r\n" + 
				"join tb_ingresso_usuario i on (i.id_evento = e.id)\r\n" + 
				"join tb_usuario u on (i.id_usuario = u.id)\r\n" + 
				"where i.rfid_id = :id", Usuario.class);

		q.setParameter("id", id);
		
		 Object singleResult = q.getSingleResult();

		return (Usuario) singleResult;
		
	}
}
