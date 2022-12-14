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

import br.com.karen.prova.model.Tecnico;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/tecnicos")
@AllArgsConstructor
public class TecnicoResource {
	
	private AbstractService<Tecnico> TecnicoService;
	
	@PostMapping()
	ResponseEntity<Tecnico> salvar(@RequestBody Tecnico tecnico) {
		return new ResponseEntity<Tecnico>(TecnicoService.salvar(tecnico), HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<Tecnico>> listarTodos() {
		return new ResponseEntity<List<Tecnico>>(TecnicoService.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Tecnico> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Tecnico>(TecnicoService.buscarPorId(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Tecnico> atualizar(@RequestBody Tecnico tecnico,  @PathVariable Long id) {
		return new ResponseEntity<Tecnico>(TecnicoService.atualizar(tecnico, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deletar(@PathVariable Long id) {
		TecnicoService.deletar(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
