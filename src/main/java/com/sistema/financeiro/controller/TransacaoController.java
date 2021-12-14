package com.sistema.financeiro.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.financeiro.model.BalancoDto;
import com.sistema.financeiro.model.Transacao;
import com.sistema.financeiro.service.TransacaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("transacao")
@Api(value = "Transações")
public class TransacaoController {
	@Autowired
	private TransacaoService transacaoService;

	@PostMapping
	@ApiOperation (value = "EndPoint para Cadastro Transação")
	public ResponseEntity<String> cadastrarTransacao(@RequestBody Transacao transacao){
		return ResponseEntity.ok(transacaoService.inserir(transacao));
	}
	
	@GetMapping
	public ResponseEntity<List<Transacao>> buscarTodos() {
		return ResponseEntity.ok(transacaoService.findAll());
	}
	
	@GetMapping (path = "/{dia}")
	public ResponseEntity<List<Transacao>> buscaPorDia(@PathVariable(value = "dia") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dia){
		return ResponseEntity.ok(transacaoService.findByDate(dia)); 
	}
	
	@GetMapping (path = "/mes/{mes}")
	public ResponseEntity<List<Transacao>> buscaPorMes(@PathVariable(value = "mes") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate mes){
		return ResponseEntity.ok(transacaoService.findByDate(mes)); 
	}
	
	@GetMapping (path = "/balanco")
	public ResponseEntity<BalancoDto> buscaBalanco(){
		return ResponseEntity.ok(transacaoService.gerarRelario());
	}
}
