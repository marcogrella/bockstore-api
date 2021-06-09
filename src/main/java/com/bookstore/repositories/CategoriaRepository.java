package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
