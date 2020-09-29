package com.desafiobanco.desafiobanco.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafiobanco.desafiobanco.models.Conta;
import com.desafiobanco.desafiobanco.models.Saque;
import com.desafiobanco.desafiobanco.repository.ContaRepository;

@RestController
public class SaqueControl {
	@Autowired
	private ContaRepository _contaRepository;

	@RequestMapping(value = "/conta/saque", method = RequestMethod.PUT)
	public ResponseEntity<String> Put(@Valid @RequestBody Saque saque) {
		long numConta = saque.getNumConta();

		Optional<Conta> contaAntiga = _contaRepository.findById(numConta);
		if (contaAntiga.isPresent()) {
			Conta conta = contaAntiga.get();
			if (saque.getSaldo() > 500) {
				return new ResponseEntity<>("Operação de transferência tem um limite máximo de 500 por operação.",
						HttpStatus.NOT_FOUND);
			} else {
				conta.setSaldo(conta.getSaldo() - saque.getSaldo());
				_contaRepository.save(conta);
				return new ResponseEntity<>("Saque realizado com sucesso!", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
