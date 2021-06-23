package aula_1_Spring_HelloTurma25.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

			
			@RequestMapping("/hello")
			public String hello() {
				return "Hello Turma 25!";
				
			}
				
}

