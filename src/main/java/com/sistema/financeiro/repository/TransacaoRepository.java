package com.sistema.financeiro.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.financeiro.model.Transacao;
import com.sistema.financeiro.util.enums.ReceitaDespesaEnum;


@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
	
	@Query(value = "SELECT SUM(valor) FROM transacao WHERE categoria = :id", nativeQuery = true)
	BigDecimal buscaValorPorCategoria(Integer id);
	
	List<Transacao> findByDataPedido(LocalDate dataPedido);
	
	@Query(value = "SELECT t.* FROM transacao t WHERE LEFT(t.dataPedido,7) = LEFT(:mes,7)" , nativeQuery = true)
	List<Transacao> findByMes(LocalDate mes);
	
	List<Transacao> findByReceitaDespesa(ReceitaDespesaEnum receitaDespesa);
}



