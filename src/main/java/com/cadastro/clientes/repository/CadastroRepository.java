package com.cadastro.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.clientes.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	
	Cadastro findById(long id);

}
