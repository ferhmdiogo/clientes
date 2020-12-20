package com.cadastro.clientes;




import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.cadastro.clientes.models.Cadastro;
import com.cadastro.clientes.repository.CadastroRepository;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class CadastroTest {
	
	@Autowired
	private Cadastro cadastro;
	
	@MockBean
	private CadastroRepository cadastroRepository;
	
	public void setup() {
		standaloneSetup(this.cadastro);
	}
	
	@Test
	public void deveRetornarSucesso_listaCadastros() {
		
		
		given()
		     .accept(ContentType.JSON)
		.when()
		     .get("/cadastro")
		.then()
		     .statusCode(HttpStatus.OK.value());
		
		
	}

}
