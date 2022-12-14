package br.com.karen.prova.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.karen.prova.model.Jogador;
import br.com.karen.prova.repository.JogadorRepository;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JogadorServiceImpl implements AbstractService<Jogador> {

	private JogadorRepository jogadorRepository;
	
	@Override
	public Jogador salvar(Jogador Jogador) {
		return jogadorRepository.save(Jogador);
	}

	@Override
	public Jogador buscarPorId(Long id) {
		Optional<Jogador> op = jogadorRepository.findById(id);
		
		if (op.isPresent()) {
			return op.get();
		}
		
		throw new RuntimeException("Entidade não encontrada");
	}

	@Override
	public Jogador atualizar(Jogador Jogador, Long id) {
		Jogador JogadorBanco = this.buscarPorId(id);
		
		if(!Jogador.getIdJogador().equals(id)) {
			throw new RuntimeException("Id informado pertence à outra entidade");
		}
		
		return this.jogadorRepository.save(Jogador);		
	}

	@Override
	public void deletar(Long id) {
		this.jogadorRepository.deleteById(id);
	}

	@Override
	public List<Jogador> listarTodos() {
		return this.jogadorRepository.findAll();
	}

}
