package br.com.karen.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.karen.prova.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	
}
