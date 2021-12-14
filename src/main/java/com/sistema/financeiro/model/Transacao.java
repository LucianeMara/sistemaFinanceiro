package com.sistema.financeiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sistema.financeiro.util.enums.ReceitaDespesaEnum;

@Entity
public class Transacao extends Entidade{

	private String descricao;
	@Column(name = "DATAPEDIDO")
	private LocalDate dataPedido = LocalDate.now();
	private BigDecimal valor;
	@Column(name = "RECEITADESPESA")
	private ReceitaDespesaEnum receitaDespesa;
	@ManyToOne (fetch = FetchType.EAGER) 
	@JoinColumn(name = "CATEGORIA")
	private Categoria categoria;

	public Transacao() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ReceitaDespesaEnum getReceitaDespesa() {
		return receitaDespesa;
	}

	public void setReceitaDespesa(ReceitaDespesaEnum receitaDespesa) {
		this.receitaDespesa = receitaDespesa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

		
}
