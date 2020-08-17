package com.generation.blogPessoal.controllers;

import com.generation.blogPessoal.model.Postagem;
import com.generation.blogPessoal.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

    @Autowired
    private PostagemRepository repository;

    //retorna uma lista de objetos postagem...
    @GetMapping
    public ResponseEntity<List<Postagem>>  getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable  long id){
        return repository.findById(id)
                .map(resp ->ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>>getByTitulo(@PathVariable  String titulo){
        return ResponseEntity.ok(repository.findAllByTituloContainsIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }
}
