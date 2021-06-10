package com.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Livro implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty(message = "Campo TÍTULO é requerido")
    @Length(min = 3, max = 80, message = "O campo TÍTULO deve possuir entre 3 e 60 caractéres.")
    private String titulo;
    
    @NotEmpty(message = "Campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 80, message = "O campo AUTOR deve possuir entre 3 e 80 caractéres.")
    private String nome_autor;
    
    @NotEmpty(message = "Campo TEXTO é requerido")
    @Length(min = 10, max = 2000000, message = "O campo TEXTO deve possuir entre 3 e 2000000 caractéres.")
    private String texto;

    @JsonIgnore /* evita que se crie um loop infinito no qual as duas classes ficam se chamando repetidas vezes */
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro(){
        super();
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
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

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return Objects.equals(getId(), livro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}