package com.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.repositories.CategoriaRepository;
import com.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
	
		return categoria
				.orElseThrow(
						() -> new ObjectNotFoundException("Objeto não encontrado. Id: " 
				+ id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
}
