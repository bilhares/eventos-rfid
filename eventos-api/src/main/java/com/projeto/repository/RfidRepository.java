package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Rfid;

public interface RfidRepository extends JpaRepository<Rfid, Long> {

}
