package com.br.microservice.dto;

import java.util.Date;

import com.br.microservice.model.PessoaModel;
import com.br.microservice.repository.PessoaRepository;

public class PessoaDTO {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PessoaModel converte() {
		PessoaModel model = new PessoaModel();
		model.setNome(nome);
		model.setDatadeCadastro(new Date());
		return model;
	}

	public PessoaModel atualizar(Long id, PessoaRepository pessoaRepository) {
		PessoaModel model = pessoaRepository.getOne(id);
		model.setNome(nome);
		return model;
	}

}
