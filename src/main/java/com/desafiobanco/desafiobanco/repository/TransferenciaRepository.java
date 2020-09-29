package com.desafiobanco.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiobanco.desafiobanco.models.Transferencia;

public interface TransferenciaRepository  extends JpaRepository<Transferencia, Long>{
	
}
