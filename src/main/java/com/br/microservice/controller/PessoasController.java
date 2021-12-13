package com.br.microservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.microservice.dto.PessoaDTO;
import com.br.microservice.model.PessoaModel;
import com.br.microservice.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public List<PessoaModel> listar() {
		return pessoaRepository.findAll();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaDTO pessoaDTO, UriComponentsBuilder uriBuilder) {
		PessoaModel pessoaModelCadastro = pessoaDTO.converte();
		pessoaRepository.save(pessoaModelCadastro);
		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoaModelCadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoaModelCadastro);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaModel> detalhar(@PathVariable Long id) {
		Optional<PessoaModel> pessoaModel = pessoaRepository.findById(id);
		if (pessoaModel.isPresent()) {
			return ResponseEntity.ok(pessoaModel.get());
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaModel> atualizar(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
		Optional<PessoaModel> pessoaModel = pessoaRepository.findById(id);
		if (pessoaModel.isPresent()) {
			PessoaModel pessoaModelAtualizada = pessoaDTO.atualizar(id, pessoaRepository);
			return ResponseEntity.ok(pessoaModelAtualizada);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaModel> remover(@PathVariable Long id) {
		Optional<PessoaModel> pessoaModel = pessoaRepository.findById(id);
		if (pessoaModel.isPresent()) {
			pessoaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
