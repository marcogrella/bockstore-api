package com.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.bookstore.domain.Livro;

public class LivroDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo TÍTULO é requerido")
	@Length(min = 3, max = 80, message = "O campo TÍTULO deve possuir entre 3 e 60 caractéres.")
	private String titulo;
	
	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	
	
}
