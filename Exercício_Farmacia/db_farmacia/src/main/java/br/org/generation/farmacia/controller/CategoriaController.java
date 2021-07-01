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

import br.org.generation.farmacia.model.CategoriaFarmacia;
import br.org.generation.farmacia.repository.CategoriaRepository;



	@RestController
	@RequestMapping ("/categoria")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class CategoriaController {
	
	
		@Autowired
		private CategoriaRepository catRepository;
	
		@GetMapping
		public ResponseEntity <List <CategoriaFarmacia>> getAll () {
		return ResponseEntity.ok(catRepository.findAll());
		
															}
	
			@GetMapping ("/{id}")
				public ResponseEntity<CategoriaFarmacia> GetById(@PathVariable long id) {
				return catRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
				
	}
	
			@GetMapping ("/nome/{nome}")
			public ResponseEntity<List<CategoriaFarmacia>> GetByTitulo (@PathVariable String nome) {
				return ResponseEntity.ok(catRepository.findAllByNomeContainingIgnoreCase(nome));
			}
			
			@PostMapping
			public ResponseEntity <CategoriaFarmacia> categorias (@RequestBody CategoriaFarmacia categoria) {
				return ResponseEntity.status(HttpStatus.CREATED).body(catRepository.save(categoria));
			}
			
			@PutMapping
			public ResponseEntity <CategoriaFarmacia> put (@RequestBody CategoriaFarmacia categoria) {
				return ResponseEntity.status(HttpStatus.OK).body(catRepository.save(categoria));
			}
			
			@DeleteMapping("{id}")
			public void delete (@PathVariable long id) {
				catRepository.deleteById(id);
			}
	
	
}