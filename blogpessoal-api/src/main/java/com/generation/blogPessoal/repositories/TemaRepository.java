package com.generation.blogPessoal.repositories;

import com.generation.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long> {

    public List<Tema> findAllByDescricaoContainsIgnoreCase(String descricao);

}
