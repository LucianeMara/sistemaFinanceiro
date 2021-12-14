package com.sistema.financeiro.model;

import java.util.List;

public class EntradaSaidaDto {

	private List<Transacao> transacoes;
	private Double valorTotal;


	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void calcularValorTotal() {
		Double valor = 0.0;
		for (Transacao transacao:transacoes) {
			valor += transacao.getValor().doubleValue();
		}
		setValorTotal(valor);		
	}
}
