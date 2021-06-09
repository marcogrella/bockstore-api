package com.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.dto.CategoriaDTO;
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

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
		
		
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		/* verifica-se se o objeto existe na base de dados*/
		Categoria obj = findById(id);
		/* define os dados encontrados no banco para o objeto DTO que será retornado já com os dados salvos. */
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj); /*salva já com os dados atualizados. */
	}
	
}
