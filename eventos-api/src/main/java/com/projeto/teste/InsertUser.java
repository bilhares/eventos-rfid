package com.projeto.teste;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.ws.Response;

import org.springframework.web.client.RestTemplate;

import com.projeto.model.Evento;
import com.projeto.model.Usuario;

public class InsertUser {
	public static void main(String[] args) throws Exception {
		Path p = Paths.get("C:\\Users\\Felipe\\Documents\\felipe\\tracktag_01.png");
		byte[] b = Files.readAllBytes(p);

		Usuario e = new Usuario();

		e.setNome("Felipe Bilhares");
		e.setEmail("felipe");
		e.setSenha("123");
		e.setByteFoto(b);
		e.setAtivo(true);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity("http://localhost:8080/api/usuario/cadastrar", e, Object.class);

	}
}
