package com.generation.blogPessoal.repositories;

import com.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem,Long> {
    public List<Postagem> findAllByTituloContainsIgnoreCase(String titulo);
}
