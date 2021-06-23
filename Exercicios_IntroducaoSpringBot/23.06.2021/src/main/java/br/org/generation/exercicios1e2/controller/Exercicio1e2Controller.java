package br.org.generation.exercicios1e2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio1e2Controller {

	@RequestMapping("/exercicio1")	
	public String exercicio1() {
		return "Mentalidade Persistência e Habilidade de Proatividade!";
	}
	
	@RequestMapping("/exercicio2")
	public String exercicio2() {
		return "Entender o conceito de Spring para facilitar o meu trabalho e sanar todas as dúvidas, pois ainda estou confuso e quero muito entender!";
		
		// lembrar de perguntar ao professor em um momento oportuno como criar outra estação/projeto caso eu queria individualizar meus projetos.
	}
	
}
