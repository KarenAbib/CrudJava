package br.com.karen.prova.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idJogador;
	private String nome;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Equipe equipe;
	
}	
