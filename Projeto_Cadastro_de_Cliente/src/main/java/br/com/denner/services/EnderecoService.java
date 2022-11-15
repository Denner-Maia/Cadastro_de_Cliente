package br.com.denner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.denner.data.vo.v1.EnderecoVO;
import br.com.denner.exceptions.CustomExceptionHandler;
import br.com.denner.mapper.DozerMapper;
import br.com.denner.model.Endereco;
import br.com.denner.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;

	public List<EnderecoVO> findAll() {
		return DozerMapper.parseListObject(repository.findAll(), EnderecoVO.class);
	}

	public EnderecoVO findbyId(Long id) {
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new CustomExceptionHandler("Id não Encontrado"));
		
		return DozerMapper.parsecObject(entity, EnderecoVO.class);
		
	}

	public EnderecoVO create(EnderecoVO endereco) {

		var entity =  DozerMapper.parsecObject(endereco, Endereco.class);
		var vo = DozerMapper.parsecObject(repository.save(entity), EnderecoVO.class);
		
		return vo;
	}

	public EnderecoVO update(EnderecoVO endereco) {
		
		var entity = repository.findById(endereco.getId())
				.orElseThrow(() -> new CustomExceptionHandler("Id não encontrado"));
			
		entity.setRua(endereco.getRua());
		entity.setBairro(endereco.getBairro());
		entity.setCidade(endereco.getCidade());
		entity.setEstado(endereco.getEstado());
		
		return DozerMapper.parsecObject(repository.save(entity), EnderecoVO.class);
	}

	public void delete(Long id) {
		
		var entity = repository.findById(id)
						  .orElseThrow(() -> new CustomExceptionHandler("Id não encontrado"));
		
		repository.delete(entity);
		
	}
	
	
}
