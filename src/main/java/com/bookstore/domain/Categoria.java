package com.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;



@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max = 80, message = "O campo NOME deve possuir entre 3 e 80 caractéres.")
    private String nome;
    
    @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve possuir entre 3 e 200 caractéres.")
    private String descricao;


    @OneToMany(mappedBy = "categoria") /* orphanRemoval=true irá apagar a categoria e seus dependentes (livros) */
    private List<Livro> livros = new ArrayList<>();



    public Categoria(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria() {
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(getId(), categoria.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

