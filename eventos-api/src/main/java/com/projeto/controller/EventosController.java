package com.projeto.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.projeto.model.Evento;
import com.projeto.model.Usuario;
import com.projeto.repository.EventoRepository;
import com.projeto.repository.impl.EventoImpl;

@Controller
public class EventosController {
	@Autowired
	EventoRepository evRepo;
	@Autowired
	EventoImpl evImpl;
	@Autowired
	ImageController imgController;

	public Page<Evento> getEventos(Pageable page) {
		return evRepo.findAll(page);
	}

	public List<Evento> getEventosSemTag() {
		return evImpl.eventosSemTag();
	}

	public void saveEventp(Evento e) {
		String img = imgController.saveImageS3(e.getBytefoto());
		e.setFoto(img);
		System.out.println("foto " + img);
		evRepo.save(e);
	}

	public void delete(Long id) {
		evRepo.delete(id);
	}

	public void eventosByUser(Pageable page, Usuario user) {
		// evRepo.getEventosByUser(page, user.getId());
	}

	public Evento getById(Long id) {
		return evRepo.findOne(id);
	}

}
