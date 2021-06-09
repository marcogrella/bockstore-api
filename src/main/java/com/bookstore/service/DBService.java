package com.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.domain.Livro;
import com.bookstore.repositories.CategoriaRepository;
import com.bookstore.repositories.LivroRepository;


@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		
		Categoria c1 = new Categoria(null, "Informatica", "livro de TI");
		Categoria c2 = new Categoria(null, "Programação", "Linguagens de Programação");
		Categoria c3 = new Categoria(null, "Idiomas", "Linguagens e Idiomas");
		
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Pipe", "Lorem Ipsum", c1);
		Livro l2 = new Livro(null, "PHP", "Robert Jefferson", "Lorem Ipsum", c1);
		Livro l3 = new Livro(null, "HTML", "Guanabara", "Lorem Ipsum", c2);
		Livro l4 = new Livro(null, "Ingles", "Andrew", "Lorem Ipsum", c3);
		Livro l5 = new Livro(null, "Espanho", "Hernandes", "Lorem Ipsum", c3);
		Livro l6 = new Livro(null, "Oracle", "Robert Pipe", "Lorem Ipsum", c1);

		c1.getLivros().addAll(Arrays.asList(l1, l2, l6));
		c2.getLivros().addAll(Arrays.asList(l3));
		c3.getLivros().addAll(Arrays.asList(l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
		
		
	}
	
	
}
