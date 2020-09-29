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
import com.desafiobanco.desafiobanco.models.Deposito;
import com.desafiobanco.desafiobanco.repository.ContaRepository;

@RestController
public class DepositoControl {

	@Autowired
	private ContaRepository _contaRepository;

	@RequestMapping(value = "/conta/deposito", method = RequestMethod.PUT)
	public ResponseEntity<String> Put(@Valid @RequestBody Deposito deposito) {
		Long numConta = deposito.getNumConta();

		Optional<Conta> contaAntiga = _contaRepository.findById(numConta);
		if (contaAntiga.isPresent()) {
			Conta conta = contaAntiga.get();
			conta.setSaldo(conta.getSaldo() + deposito.getSaldo());
			_contaRepository.save(conta);
			return new ResponseEntity<>("Depósito realizado com sucesso!", HttpStatus.OK);
		} else
			return new ResponseEntity<>("Depósito realizado com sucesso!", HttpStatus.NOT_FOUND);
	}
}
