package com.desafiobanco.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiobanco.desafiobanco.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	
}
