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
import com.desafiobanco.desafiobanco.models.Transferencia;
import com.desafiobanco.desafiobanco.repository.ContaRepository;

@RestController
public class TransferControl {
	@Autowired
	private ContaRepository _contaRepository;

	@RequestMapping(value = "/conta/transferencia", method = RequestMethod.PUT)
	public ResponseEntity<String> Put(@Valid @RequestBody Transferencia transferencia, Conta novaConta) {

		Long numConta = transferencia.getContaSolicitante();
		Long numToConta = transferencia.getContaBeneficiario();

		Optional<Conta> contaAntiga = _contaRepository.findById(numConta);
		Optional<Conta> contaAntigaTo = _contaRepository.findById(numToConta);

		if (contaAntiga.isPresent() && contaAntigaTo.isPresent()) {
			Conta conta = contaAntiga.get();
			Conta contaTo = contaAntigaTo.get();

			if (transferencia.getSaldo() > 500) {
				// Tranferencia maior que 500
				return new ResponseEntity<>("Operação de transferência tem um limite máximo de 500 por operação.",
						HttpStatus.NOT_FOUND);
			} else if (conta.getSaldo() > transferencia.getSaldo()) {
				conta.setSaldo(conta.getSaldo() - transferencia.getSaldo());
				contaTo.setSaldo(contaTo.getSaldo() + transferencia.getSaldo());
				_contaRepository.save(conta);
				_contaRepository.save(contaTo);
				// Tranferencia ocorrida com sucesso
				return new ResponseEntity<>("Transferência realizada com sucesso!", HttpStatus.OK);
			} else if (conta.getSaldo() < transferencia.getSaldo()) {
				// Saldo insuficiente
				return new ResponseEntity<>("Saldo insuficiente para a operação.", HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<>("Sem informações", HttpStatus.NOT_FOUND);
	}
}
