package com.desafiobanco.desafiobanco.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transferencia {
	
	@Id
	private long contaSolicitante;
	
	private float saldo;
	
	private long contaBeneficiario;

	public long getContaSolicitante() {
		return contaSolicitante;
	}

	public void setContaSolicitante(long contaSolicitante) {
		this.contaSolicitante = contaSolicitante;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public long getContaBeneficiario() {
		return contaBeneficiario;
	}

	public void setContaBeneficiario(long contaBeneficiario) {
		this.contaBeneficiario = contaBeneficiario;
	}
	
	
}
