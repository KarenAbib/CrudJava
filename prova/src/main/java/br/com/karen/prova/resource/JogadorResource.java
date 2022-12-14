package br.com.karen.prova.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.karen.prova.model.Jogador;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/jogadores")
@AllArgsConstructor
public class JogadorResource {
	
	private AbstractService<Jogador> jogadorService;
	
	@PostMapping()
	ResponseEntity<Jogador> salvar(@RequestBody Jogador jogador) {
		return new ResponseEntity<Jogador>(jogadorService.salvar(jogador), HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<Jogador>> listarTodos() {
		return new ResponseEntity<List<Jogador>>(jogadorService.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Jogador> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Jogador>(jogadorService.buscarPorId(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Jogador> atualizar(@RequestBody Jogador jogador,  @PathVariable Long id) {
		return new ResponseEntity<Jogador>(jogadorService.atualizar(jogador, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deletar(@PathVariable Long id) {
		jogadorService.deletar(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
