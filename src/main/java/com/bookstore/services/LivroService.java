package com.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.domain.Livro;
import com.bookstore.repositories.LivroRepository;
import com.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired 
	CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Livro.class.getName()));
		
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
		
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setCategoria(obj.getCategoria());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
		newObj.setTitulo(obj.getTitulo());
		
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null); /* seta o id do objeto para null para evitar problema. */
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return livroRepository.save(obj);

	}
	
}
