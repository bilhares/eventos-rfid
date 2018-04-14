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
	private AmazonS3 amazonS3;

	public Page<Evento> getEventos(Pageable page) {
		return evRepo.findAll(page);
	}

	public List<Evento> getEventosSemTag() {
		return evImpl.eventosSemTag();
	}

	public void saveEventp(Evento e) {
		String img = saveImageS3(e.getFoto());
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

	private String saveImageS3(byte[] foto) {
		// DatatypeConverter.parseBase64Binary(foto.toString());
		String bucket = "epasstracktag";
		InputStream stream = new ByteArrayInputStream(foto);
		String fileName = getRandomKey()+".jpg";
		amazonS3.putObject(
				new PutObjectRequest(bucket, fileName, stream, null).withCannedAcl(CannedAccessControlList.PublicRead));

		return "http://s3-us-east-2.amazonaws.com/" + bucket + "/" + fileName;
	}

	private String getRandomKey() {
		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();
		return myRandom.substring(0, 20);
	}
}
