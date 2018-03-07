package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.model.Rfid;


public interface RfidRepository extends JpaRepository<Rfid, Long> {

	@Query(value = "select * from rfid", nativeQuery = true)
	public List<Rfid> busca();
}
