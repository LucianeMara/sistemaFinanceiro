package com.sistema.financeiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.financeiro.model.Categoria;
import com.sistema.financeiro.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria salvar(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	public Categoria findyById(Integer categoria) {
		return categoriaRepository.getOne(categoria);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
