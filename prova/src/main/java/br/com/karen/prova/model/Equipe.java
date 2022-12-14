package br.com.karen.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEquipe;
	
	private String nome;
	
	@Transient
	@OneToOne(mappedBy = "equipe")
	private Cidade cidade;
	
	@Transient
	@OneToOne(mappedBy = "equipe")
	private Jogador jogador;
	
	@Transient
	@OneToOne(mappedBy = "equipe")
	private Tecnico tecnico;
	
	@Transient
	@OneToOne(mappedBy = "equipeCasa")
	private Jogo jogoCasa;
	
	@Transient
	@OneToOne(mappedBy = "equipeVisitante")
	private Jogo jogoVisitante;
}
