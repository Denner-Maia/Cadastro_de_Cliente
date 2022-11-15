package br.com.denner.controllers;

import java.util.List;

import javax.print.attribute.standard.Media;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.denner.data.vo.v1.EnderecoVO;
import br.com.denner.model.Endereco;
import br.com.denner.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController{
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EnderecoVO> findAll(){
		return service.findAll();
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EnderecoVO findById(@PathVariable(value = "id") Long id) {
		return service.findbyId(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public EnderecoVO create(@RequestBody EnderecoVO endereco) {
		return service.create(endereco);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public EnderecoVO update(@RequestBody EnderecoVO endereco) {
		
		return service.update(endereco);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
