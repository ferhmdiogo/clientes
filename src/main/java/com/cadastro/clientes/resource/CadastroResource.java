package com.cadastro.clientes.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.clientes.models.Cadastro;
import com.cadastro.clientes.repository.CadastroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST cadastro")
@CrossOrigin(origins="*")
public class CadastroResource {
	
	Cadastro cadastro;
	
	@Autowired
	public void Cadastro (Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	@Autowired
	CadastroRepository cadastroRepository;
	
	@GetMapping("/cadastro")
	@ApiOperation(value="Retorna uma lista de cadastros")
	public List<Cadastro> listaCadastros(){
		return cadastroRepository.findAll();
	}
	
	@GetMapping("/cadastro/{id}")
	@ApiOperation(value="Retorna um cadastro")
	public Cadastro listaCadastroUnico(@PathVariable(value="id") long id){
		return cadastroRepository.findById(id);
		
	}
	
	@PostMapping("/cadastro")
	@ApiOperation(value="Salva um novo cadastro")
	public Cadastro salvaCadastro(@RequestBody Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
	@DeleteMapping("/cadastro")
	@ApiOperation(value="Exclui um cadastro")
	public void deletaCadastro (@RequestBody Cadastro cadastro) {
		cadastroRepository.delete(cadastro);
		
	}
	
	@PutMapping("/cadastro")
	@ApiOperation(value="Atualiza um cadastro")
	public Cadastro atualizaCadastro (@RequestBody Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
		
	}

}

