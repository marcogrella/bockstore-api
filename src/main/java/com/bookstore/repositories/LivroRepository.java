package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
