//package com.desafiobanco.desafiobanco.resources;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.desafiobanco.desafiobanco.repository.ContaRepository;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//import com.desafiobanco.desafiobanco.models.Conta;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping(value = "/api")
//@Api(value = "API REST BANCO")
//public class ContaResource {
//
//	@Autowired
//	ContaRepository contaRepository;
//	
//	@ApiOperation(value = "Retorna uma lista de contas")
//	@GetMapping("/contas")
//	public List<Conta> listaContas() {
//		return contaRepository.findAll();
//	}
//
//	@ApiOperation(value = "Retorna uma única conta no banco")
//	@GetMapping("/conta/{numConta}")
//	public Conta listaConta(@PathVariable(value = "numConta") long numConta) {
//		return contaRepository.findByNumConta(numConta);
//	}
//
//	@ApiOperation(value = "Cria uma conta no banco")
//	@PostMapping("/conta")
//	public Conta criarConta(@RequestBody Conta conta) {
//		return contaRepository.save(conta);
//	}
//
//	@ApiOperation(value = "Deleta uma conta no banco")
//	@DeleteMapping("/conta")
//	public void deletarConta(@RequestBody Conta conta) {
//		contaRepository.delete(conta);
//	}
//
//	@ApiOperation(value = "Atualiza uma conta no banco")
//	@PutMapping("/conta")
//	public Conta atualizarConta(@RequestBody Conta conta) {
//		return contaRepository.save(conta);
//	}
//	
//	
//}
