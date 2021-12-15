package com.br.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.microservice.model.PessoaModel;

public interface PessoaRepository extends JpaRepository <PessoaModel, Long> {

}
