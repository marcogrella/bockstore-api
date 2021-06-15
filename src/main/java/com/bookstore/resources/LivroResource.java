package com.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.domain.Livro;
import com.bookstore.dto.LivroDTO;
import com.bookstore.services.LivroService;

@CrossOrigin(origins="*") /* habilita requisições vindas de diversas outras fontes. Para uso posterior no Front Angular */
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro obj = livroService.findById(id);
		return ResponseEntity.ok().body(obj);
			
	}
	
	/* Irá arepsentar os livros e a categoria. */
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
		List<Livro> list = livroService.findAll(id_cat);
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id,@Valid @RequestBody Livro obj){
		Livro newObj = livroService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	/* Normalmente o patch é para atualizar somente uma informação (título por exemplo) */
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id,@Valid @RequestBody Livro obj){
		Livro newObj = livroService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping()
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@Valid @RequestBody Livro obj){
	
		Livro newObj = livroService.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}




