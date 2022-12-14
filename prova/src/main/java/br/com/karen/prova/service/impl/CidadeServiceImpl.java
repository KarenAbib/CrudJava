package br.com.karen.prova.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.karen.prova.model.Cidade;
import br.com.karen.prova.repository.CidadeRepository;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CidadeServiceImpl implements AbstractService<Cidade> {

	private CidadeRepository cidadeRepository;
	
	@Override
	public Cidade salvar(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	@Override
	public Cidade buscarPorId(Long id) {
		Optional<Cidade> op = cidadeRepository.findById(id);
		
		if (!op.isPresent()) {
			throw new RuntimeException("Entidade não encontrada");
		}
		
		return op.get();
		
	}

	@Override
	public Cidade atualizar(Cidade cidade, Long id) {
		Cidade cidadeBanco = this.buscarPorId(id);
		
		if(!cidade.getIdCidade().equals(id)) {
			throw new RuntimeException("Id informado pertence à outra entidade");
		}
		
		return this.cidadeRepository.save(cidade);		
	}

	@Override
	public void deletar(Long id) {
		this.cidadeRepository.deleteById(id);
	}

	@Override
	public List<Cidade> listarTodos() {
		return this.cidadeRepository.findAll();
	}

}
