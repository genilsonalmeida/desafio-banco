package com.desafiobanco.desafiobanco.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafiobanco.desafiobanco.repository.ContaRepository;
import com.desafiobanco.desafiobanco.models.Conta;

@RestController
public class ContaControl {
	@Autowired
	private ContaRepository _contaRepository;

	@RequestMapping(value = "/conta", method = RequestMethod.POST)
	public ResponseEntity<String> Post(@Valid @RequestBody Conta conta) {
		if (conta.getCpf().isEmpty()) {
			return new ResponseEntity<>("É necessário informar um cpf para abertura de nova conta.",
					HttpStatus.NOT_FOUND);
		} else if (conta.getSaldo() < 50) {
			return new ResponseEntity<>("Saldo insuficiente para abertura de nova conta.", HttpStatus.NOT_FOUND);
		} else if (conta.getCpf().length() != 11) {
			return new ResponseEntity<>("CPF informado para criação de conta está inválido.", HttpStatus.NOT_FOUND);
		} else {
			_contaRepository.save(conta);
			return new ResponseEntity<>("Número da conta: " + conta.getNumConta() + "\nConta cadastrada com sucesso!",
					HttpStatus.OK);
		}
	}
}
