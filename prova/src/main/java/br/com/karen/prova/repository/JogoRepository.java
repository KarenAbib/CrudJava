package br.com.karen.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.karen.prova.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
	
}
