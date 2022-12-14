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

import br.com.karen.prova.model.Cidade;
import br.com.karen.prova.service.AbstractService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/cidades")
@AllArgsConstructor
public class CidadeResource {
	
	private AbstractService<Cidade> cidadeService;
	
	@PostMapping()
	ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade) {
		return new ResponseEntity<Cidade>(cidadeService.salvar(cidade), HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<Cidade>> listarTodos() {
		return new ResponseEntity<List<Cidade>>(cidadeService.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Cidade> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Cidade>(cidadeService.buscarPorId(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Cidade> atualizar(@RequestBody Cidade cidade,  @PathVariable Long id) {
		return new ResponseEntity<Cidade>(cidadeService.atualizar(cidade, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deletar(@PathVariable Long id) {
		cidadeService.deletar(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
