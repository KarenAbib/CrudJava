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

import br.com.karen.prova.model.Equipe;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/equipes")
@AllArgsConstructor
public class EquipeResource {
	
	private AbstractService<Equipe> equipeService;
	
	@PostMapping()
	ResponseEntity<Equipe> salvar(@RequestBody Equipe Equipe) {
		return new ResponseEntity<Equipe>(equipeService.salvar(Equipe), HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<Equipe>> listarTodos() {
		return new ResponseEntity<List<Equipe>>(equipeService.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Equipe> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Equipe>(equipeService.buscarPorId(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Equipe> atualizar(@RequestBody Equipe Equipe,  @PathVariable Long id) {
		return new ResponseEntity<Equipe>(equipeService.atualizar(Equipe, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deletar(@PathVariable Long id) {
		equipeService.deletar(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
