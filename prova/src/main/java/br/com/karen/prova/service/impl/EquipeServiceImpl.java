package br.com.karen.prova.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.karen.prova.model.Equipe;
import br.com.karen.prova.repository.EquipeRepository;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements AbstractService<Equipe> {

	private EquipeRepository equipeRepository;
	
	@Override
	public Equipe salvar(Equipe Equipe) {
		return equipeRepository.save(Equipe);
	}

	@Override
	public Equipe buscarPorId(Long id) {
		Optional<Equipe> op = equipeRepository.findById(id);
		
		if (op.isPresent()) {
			return op.get();
		}
		
		throw new RuntimeException("Entidade não encontrada");
	}

	@Override
	public Equipe atualizar(Equipe Equipe, Long id) {
		Equipe EquipeBanco = this.buscarPorId(id);
		
		if(!Equipe.getIdEquipe().equals(id)) {
			throw new RuntimeException("Id informado pertence à outra entidade");
		}
		
		return this.equipeRepository.save(Equipe);		
	}

	@Override
	public void deletar(Long id) {
		this.equipeRepository.deleteById(id);
	}

	@Override
	public List<Equipe> listarTodos() {
		return this.equipeRepository.findAll();
	}

}
