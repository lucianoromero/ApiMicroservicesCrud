package com.br.microservice.dto;

import java.util.Date;

public class PessoaDto {

	private String nome;
	private Date DatadeCadastro;
			
	public PessoaDto(String nome) {
		this.nome = nome;
		DatadeCadastro  = new Date();
	}

	public String getNome() {
		return nome;
	}
	
	public Date getDatadeCadastro() {
		return DatadeCadastro;
	}
	
}
