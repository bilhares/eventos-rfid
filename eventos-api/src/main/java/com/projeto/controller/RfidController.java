package com.projeto.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.projeto.model.Evento;
import com.projeto.model.Rfid;
import com.projeto.model.Usuario;
import com.projeto.model.json.RetUserEvento;
import com.projeto.repository.RfidRepository;

@Controller
public class RfidController {

	@Autowired
	RfidRepository rfRepo;
	@PersistenceContext
	private EntityManager manager;

	public boolean cadastrar(Rfid rfid) {
		if (rfRepo.save(rfid) != null) {
			return true;
		}
		return false;
	}

	public Page<Rfid> buscarTodas(Pageable page) {
		return rfRepo.findAll(page);
		// return rfRepo.busca();
	}

	public Usuario buscarUserByTag(Long id) {
		Query q = null;

		q = manager
				.createNativeQuery(
						"select u.* from tb_evento e \r\n" + "join tb_ingresso_usuario i on (i.id_evento = e.id)\r\n"
								+ "join tb_usuario u on (i.id_usuario = u.id)\r\n" + "where i.rfid_id = :id",
						Usuario.class);

		q.setParameter("id", id);

		Object singleResult = q.getSingleResult();

		return (Usuario) singleResult;

	}

	public RetUserEvento buscarUserEvByTag(Long id) {
		Query q = null;

		q = manager.createNativeQuery(
				"select e.*" + "from tb_evento e \r\n" + "join tb_ingresso_usuario i on (i.id_evento = e.id)\r\n"
						+ "join tb_usuario u on (i.id_usuario = u.id)\r\n" + "where i.rfid_id = :id",
				Evento.class);

		q.setParameter("id", id);

		Evento ev = (Evento) q.getSingleResult();
		Usuario user = buscarUserByTag(id);

		RetUserEvento ret = new RetUserEvento();
		ret.setNomeUser(user.getNome());
		ret.setNomeEvento(ev.getNome());
		ret.setFtUser(user.getFoto());
		ret.setFtEvento(ev.getFoto());
		ret.setLocal(ev.getLocal());
		ret.setPreco(ev.getPreco());
		ret.setData(ev.getData());
		ret.setEmailUser(user.getEmail());

		return ret;

	}

	public Rfid buscarDisponivel(Long idEvento) {
		Query q = null;

		q = manager.createNativeQuery("select * from eventos.rfid e where e.id_evento = :id limit 1;", Rfid.class);

		q.setParameter("id", idEvento);

		Rfid ev = (Rfid) q.getSingleResult();

		return ev;
	}
}
