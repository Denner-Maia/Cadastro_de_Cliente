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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.denner.data.vo.v1.TelefoneVO;
import br.com.denner.model.Telefone;
import br.com.denner.services.TelefoneServices;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

		@Autowired
		private TelefoneServices services;
		
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public List<TelefoneVO> findAll(){
			return services.findAll();
		}
		
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public TelefoneVO findById(@PathVariable(value = "id") Long id) {
			return services.findById(id);
		}
		
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
					 produces = MediaType.APPLICATION_JSON_VALUE)
		public TelefoneVO create(@RequestBody TelefoneVO telefone) {
			return services.create(telefone);
		}
		
		@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
		public TelefoneVO update(@RequestBody TelefoneVO telefone) {
			return services.update(telefone);
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
			services.delete(id);
			
			return ResponseEntity.noContent().build();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
