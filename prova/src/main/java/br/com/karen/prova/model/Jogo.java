package br.com.karen.prova.model;

import java.time.LocalDate;

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
public class Jogo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idJogo;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Equipe equipeCasa;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Equipe equipeVisitante;
	
	private int pontosCasa;
	private int pontosVisitante;
	private LocalDate data;
}
