package com.desafiobanco.desafiobanco.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Saque {
	
	@Id
	private Long numConta;
	
	private float saldo;

	public Long getNumConta() {
		return numConta;
	}

	public void setNumConta(Long numConta) {
		this.numConta = numConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
}
