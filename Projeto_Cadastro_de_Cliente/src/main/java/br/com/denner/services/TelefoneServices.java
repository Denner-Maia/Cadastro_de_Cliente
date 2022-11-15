package br.com.denner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.denner.data.vo.v1.TelefoneVO;
import br.com.denner.exceptions.CustomExceptionHandler;
import br.com.denner.mapper.DozerMapper;
import br.com.denner.model.Telefone;
import br.com.denner.repositories.TelefoneRepository;

@Service
public class TelefoneServices {
	
	@Autowired
	private TelefoneRepository repository;

	public List<TelefoneVO> findAll() {
		return DozerMapper.parseListObject(repository.findAll(), TelefoneVO.class);
	}

	public TelefoneVO findById(Long id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new CustomExceptionHandler("Id não encontrado"));
		
		return DozerMapper.parsecObject(entity, TelefoneVO.class);
	}

	public TelefoneVO create(TelefoneVO telefone) {
		
		var entity = DozerMapper.parsecObject(telefone, Telefone.class);
		var vo = DozerMapper.parsecObject(repository.save(entity), TelefoneVO.class);
		
		return vo;
	}

	public TelefoneVO update(TelefoneVO telefone) {
		
		var entity = repository.findById(telefone.getId())
						  .orElseThrow(() -> new CustomExceptionHandler("Id não encontrado"));
		entity.setNumero(telefone.getNumero());
		entity.setTipo(telefone.getTipo());
		
		
		
		var vo = DozerMapper.parsecObject(repository.save(entity), TelefoneVO.class);
		
		return vo;
	}

	public void delete(Long id) {
		
		Telefone entity = repository.findById(id)
							.orElseThrow(() -> new CustomExceptionHandler("Id não encontrado"));
		
		repository.delete(entity);
	}

}
