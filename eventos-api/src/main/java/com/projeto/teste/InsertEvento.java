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

public class InsertEvento {
	public static void main(String[] args) throws Exception {
		Path p = Paths.get("C:\\Users\\PSG\\Documents\\felipe\\img_ev\\ev5.jpg");
		byte[] b = Files.readAllBytes(p);

		Evento e = new Evento();
		e.setAtivo(true);
		
		String dataString = "09/08/2025";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());

		e.setData(data);
		e.setFoto(b);
		e.setLocal("Local fo evento 5");
		e.setNome("Evento 05");
		e.setPreco(10987);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity("http://localhost:8081/api/eventos", e, Object.class);

	}
}
