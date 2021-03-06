package br.org.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.repository.PostagemRepository;
import br.org.generation.blogpessoal.model.Postagem;


@RestController
@RequestMapping("/postagem")	
@CrossOrigin("*")
public class ControllerPostagem {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll (){
		return ResponseEntity.ok(repository.findAll()); // OK = 200
	}
}