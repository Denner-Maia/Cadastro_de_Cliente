package br.com.denner.services;

import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.AliasRegistry;
import org.springframework.stereotype.Service;

import br.com.denner.data.vo.v1.ClienteVO;
import br.com.denner.exceptions.CustomExceptionHandler;
import br.com.denner.mapper.DozerMapper;
import br.com.denner.model.Cliente;
import br.com.denner.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	private Logger logger = Logger.getLogger(ClienteService.class.getName());
	
	
	public List<ClienteVO> findAll() {
		
		logger.info("Listar todos os clientes!");
		
		return DozerMapper.parseListObject(repository.findAll(), ClienteVO.class);
	}

	
	public ClienteVO findById(Long id) {
		
		logger.info("Buscar Cliente");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new CustomExceptionHandler("ID não encontrado."));
		
		return DozerMapper.parsecObject(entity, ClienteVO.class);
	}
	/*public ClienteVO findByNome(String nome) {
		
		var entity = repository.findByNome(nome);
		
		if(entity == null) {
			throw new CustomExceptionHandler("Cliente Não encontrado");
		}
		
		return DozerMapper.parsecObject(entity, ClienteVO.class);
	}*/

	public ClienteVO create(ClienteVO cliente){
	
	
		if(!Operacoes.validaCpf(cliente.getCpf())){
	
			throw new CustomExceptionHandler("Cpf inválido");
		}
		if(!repository.existsByEmail(cliente.getEmail())) {
			
			throw new CustomExceptionHandler("Email ja cadastrado!");
		}
			
			var entity = DozerMapper.parsecObject(cliente, Cliente.class);
			var vo = DozerMapper.parsecObject(repository.save(entity), ClienteVO.class);
			
			return vo;
	
		
		
	}

	public ClienteVO update(ClienteVO cliente) {
		
		var entity = repository.findById(cliente.getId())
				.orElseThrow(() -> new CustomExceptionHandler("ID não encontrado."));
		
		
		entity.setNome(cliente.getNome());
		entity.setEmail(cliente.getEmail());
		entity.setCpf(cliente.getCpf());
		entity.setSexo(cliente.getSexo());
		
		var vo = DozerMapper.parsecObject(repository.save(entity), ClienteVO.class);
		return vo;
	}

	public void delete(Long id) {
		
		Cliente entity = repository.findById(id)
		.orElseThrow(() -> new CustomExceptionHandler("ID não encontrado."));
		
		repository.delete(entity);
	}
	
}
