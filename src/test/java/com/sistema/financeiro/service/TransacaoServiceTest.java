package com.sistema.financeiro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.sistema.financeiro.model.Transacao;
import com.sistema.financeiro.util.enums.ReceitaDespesaEnum;



@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_METHOD)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class TransacaoServiceTest {
	@Autowired
	private TransacaoService transacaoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Test
	public void testeInserir() {
		Transacao transacao = new Transacao();
		transacao.setValor(BigDecimal.valueOf(100.00));
		transacao.setReceitaDespesa(ReceitaDespesaEnum.DESPESA);		
		Categoria categoria = new Categoria();
		categoria.setDescricao("BELEZA");
		categoria.setLimiteGasto(BigDecimal.valueOf(500.00));	
		transacao.setCategoria(categoriaService.salvar(categoria));
		assertEquals("Transação efetivada.", transacaoService.inserir(transacao));		
	}
	
}
