package com.sistema.financeiro.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Categoria extends Entidade {

	private String descricao;
	@Column(name = "LIMITEGASTO")
	private BigDecimal limiteGasto;

	public Categoria() {
	}

	public Categoria(String descricao, BigDecimal limiteGasto) {
		this.descricao = descricao;
		this.limiteGasto = limiteGasto;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public BigDecimal getLimiteGasto() {
		return limiteGasto;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setLimiteGasto(BigDecimal limiteGasto) {
		this.limiteGasto = limiteGasto;
	}

		
}
