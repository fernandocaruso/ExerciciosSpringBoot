package br.org.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.farmacia.model.ProdutosFarmacia;
import br.org.generation.farmacia.repository.ProdutosRepository;

@RestController
@RequestMapping ("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {


	@Autowired
	private ProdutosRepository repository;

	@GetMapping
	public ResponseEntity <List <ProdutosFarmacia>> getAll () {
	return ResponseEntity.ok(repository.findAll());
	
														}

		@GetMapping ("/{id}")
			public ResponseEntity<ProdutosFarmacia> GetById(@PathVariable long id) {
			return repository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
			
}

		@GetMapping ("/titulo/{titulo}")
		public ResponseEntity<List<ProdutosFarmacia>> getByTitulo (@PathVariable String titulo) {
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		}
		
		@PostMapping
		public ResponseEntity <ProdutosFarmacia> produtos (@RequestBody ProdutosFarmacia titulo) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(titulo));
		}
		
		@PutMapping
		public ResponseEntity <ProdutosFarmacia> put (@RequestBody ProdutosFarmacia titulo) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(titulo));
		}
		
		@DeleteMapping("{id}")
		public void delete (@PathVariable long id) {
			repository.deleteById(id);
		}


}