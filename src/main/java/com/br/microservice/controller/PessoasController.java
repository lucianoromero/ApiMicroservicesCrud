package com.br.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	@GetMapping
	public void lista() {

	}

	@PostMapping
	public void cadastrar() {

	}

	public void detalhar() {

	}

	public void atualizar() {

	}

	public void remover() {

	}

}
