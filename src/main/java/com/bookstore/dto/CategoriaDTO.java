package com.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max = 80, message = "O campo NOME deve possuir entre 3 e 80 caractéres.")
    private String nome;
    
    @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve possuir entre 3 e 200 caractéres.")
    private String descricao;
	
	public CategoriaDTO() {
		super();
	}
	
	/* recebe um objeto do tipo Categoria e converte para um DTO */

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
