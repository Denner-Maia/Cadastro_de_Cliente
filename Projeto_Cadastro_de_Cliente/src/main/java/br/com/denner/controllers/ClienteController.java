package br.com.denner.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.denner.data.vo.v1.ClienteVO;
import br.com.denner.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteVO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	/*
	@GetMapping(value = "nomeCliente/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO findByNome(@PathVariable(value = "nome") String nome) {
		return service.findByNome(nome);
	}*/
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO create(@RequestBody ClienteVO cliente){
		return service.create(cliente);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO update(@RequestBody ClienteVO cliente) {
		return service.update(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

