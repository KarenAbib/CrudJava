package br.com.karen.prova.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.karen.prova.model.Jogo;
import br.com.karen.prova.repository.JogoRepository;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JogoServiceImpl implements AbstractService<Jogo> {

	private JogoRepository jogoRepository;
	
	@Override
	public Jogo salvar(Jogo Jogo) {
		return jogoRepository.save(Jogo);
	}

	@Override
	public Jogo buscarPorId(Long id) {
		Optional<Jogo> op = jogoRepository.findById(id);
		
		if (op.isPresent()) {
			return op.get();
		}
		
		throw new RuntimeException("Entidade não encontrada");
	}

	@Override
	public Jogo atualizar(Jogo Jogo, Long id) {
		Jogo JogoBanco = this.buscarPorId(id);
		
		if(!Jogo.getIdJogo().equals(id)) {
			throw new RuntimeException("Id informado pertence à outra entidade");
		}
		
		return this.jogoRepository.save(Jogo);		
	}

	@Override
	public void deletar(Long id) {
		this.jogoRepository.deleteById(id);
	}

	@Override
	public List<Jogo> listarTodos() {
		return this.jogoRepository.findAll();
	}

}
