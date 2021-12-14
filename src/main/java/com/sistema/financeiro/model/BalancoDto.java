package com.sistema.financeiro.model;

public class BalancoDto {
	
	private EntradaSaidaDto creditos;
	private EntradaSaidaDto debitos;
	
	
	public EntradaSaidaDto getCreditos() {
		return creditos;
	}
	
	public void setCreditos(EntradaSaidaDto creditos) {
		this.creditos = creditos;
	}
	
	public EntradaSaidaDto getDebitos() {
		return debitos;
	}
	
	public void setDebitos(EntradaSaidaDto debitos) {
		this.debitos = debitos;
	}
	
	
}
