package com.sistema.financeiro.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.financeiro.model.BalancoDto;
import com.sistema.financeiro.model.Categoria;
import com.sistema.financeiro.model.EntradaSaidaDto;
import com.sistema.financeiro.model.Transacao;
import com.sistema.financeiro.repository.TransacaoRepository;
import com.sistema.financeiro.util.enums.ReceitaDespesaEnum;

@Service
public class TransacaoService {
	@Autowired
	private TransacaoRepository transacaoRepository;
	@Autowired
	private CategoriaService categoriaService;
	
	public String inserir(Transacao transacao) {
		if (transacaoInvalida(transacao)) {
			return "Valor máximo excedido.";
		}
		transacaoRepository.save(transacao);
		return "Transação efetivada.";
	}

	private boolean transacaoInvalida(Transacao transacao) {
		Categoria categoria;
		if (transacao.getCategoria().getLimiteGasto()==null) {
			categoria = categoriaService.findyById(transacao.getCategoria().getId());
		}
		else {
			categoria = transacao.getCategoria();
		}
		BigDecimal somaPorCategoria = transacaoRepository.buscaValorPorCategoria(categoria.getId());
		
		return getDouble(somaPorCategoria) + getDouble(transacao.getValor()) > getDouble(categoria.getLimiteGasto());
	}

	public List<Transacao> findAll() {
		return transacaoRepository.findAll();
	}

	private double getDouble(BigDecimal valor) {
		if (valor == null) {
			return 0.0;
		}
		return valor.doubleValue();
	}
	
	public List<Transacao> findByDate(LocalDate data){
		return transacaoRepository.findByDataPedido(data);
	}

	public List<Transacao> findByMes(LocalDate mes){
		return transacaoRepository.findByMes(mes);
	}
	
	public BalancoDto gerarRelario() {
		BalancoDto balanco = new BalancoDto();
		EntradaSaidaDto creditos = new EntradaSaidaDto();
		EntradaSaidaDto debitos = new EntradaSaidaDto();
		
		creditos.setTransacoes(transacaoRepository.findByReceitaDespesa(ReceitaDespesaEnum.RECEITA));
		creditos.calcularValorTotal();
		
		debitos.setTransacoes(transacaoRepository.findByReceitaDespesa(ReceitaDespesaEnum.DESPESA));
		debitos.calcularValorTotal();	
		
		balanco.setCreditos(creditos);
		balanco.setDebitos(debitos);
		
		return balanco;
		
	}
}
