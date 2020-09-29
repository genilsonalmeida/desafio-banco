package com.desafiobanco.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiobanco.desafiobanco.models.Saque;

public interface SaqueRepository   extends JpaRepository<Saque, Long>{
	
}
