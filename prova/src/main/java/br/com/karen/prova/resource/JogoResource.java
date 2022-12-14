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

import br.com.karen.prova.model.Jogo;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/jogos")
@AllArgsConstructor
public class JogoResource {
	
	private AbstractService<Jogo> jogoService;
	
	@PostMapping()
	ResponseEntity<Jogo> salvar(@RequestBody Jogo jogo) {
		return new ResponseEntity<Jogo>(jogoService.salvar(jogo), HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<Jogo>> listarTodos() {
		return new ResponseEntity<List<Jogo>>(jogoService.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Jogo> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Jogo>(jogoService.buscarPorId(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Jogo> atualizar(@RequestBody Jogo jogo,  @PathVariable Long id) {
		return new ResponseEntity<Jogo>(jogoService.atualizar(jogo, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deletar(@PathVariable Long id) {
		jogoService.deletar(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
