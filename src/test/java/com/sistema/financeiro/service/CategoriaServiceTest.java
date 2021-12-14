package com.sistema.financeiro.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistema.financeiro.model.Categoria;



@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CategoriaServiceTest {
	@Autowired
	private CategoriaService categoriaService;
	
	@Test
	public void testeInserir() {
		Categoria categoria = new Categoria();
		categoria.setDescricao("Lazer");
		categoria.setLimiteGasto(BigDecimal.valueOf(300.00));
		categoria = categoriaService.salvar(categoria);
		assertNotNull(categoria.getId());		
	}
	
}
