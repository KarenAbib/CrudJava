package br.com.karen.prova.service;

import java.util.List;

public interface AbstractService<T> {
	T salvar(T entidade);
	
	T buscarPorId(Long id);
	
	T atualizar(T entidade,  Long id);
	
	void deletar(Long id);
	
	List<T> listarTodos();
}
