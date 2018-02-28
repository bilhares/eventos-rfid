package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
