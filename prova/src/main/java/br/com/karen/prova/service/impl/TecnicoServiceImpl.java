package br.com.karen.prova.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.karen.prova.model.Tecnico;
import br.com.karen.prova.repository.TecnicoRepository;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TecnicoServiceImpl implements AbstractService<Tecnico> {

	private TecnicoRepository tecnicoRepository;
	
	@Override
	public Tecnico salvar(Tecnico tecnico) {
		return tecnicoRepository.save(tecnico);
	}

	@Override
	public Tecnico buscarPorId(Long id) {
		Optional<Tecnico> op = tecnicoRepository.findById(id);
		
		if (op.isPresent()) {
			return op.get();
		}
		
		throw new RuntimeException("Entidade não encontrada");
	}

	@Override
	public Tecnico atualizar(Tecnico tecnico, Long id) {
		Tecnico tecnicoBanco = this.buscarPorId(id);
		
		if(!tecnico.getIdTecnico().equals(id)) {
			throw new RuntimeException("Id informado pertence à outra entidade");
		}
		
		return this.tecnicoRepository.save(tecnico);		
	}

	@Override
	public void deletar(Long id) {
		this.tecnicoRepository.deleteById(id);
	}

	@Override
	public List<Tecnico> listarTodos() {
		return this.tecnicoRepository.findAll();
	}

}
