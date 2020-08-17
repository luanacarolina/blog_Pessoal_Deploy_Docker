package com.generation.blogPessoal.controllers;

import com.generation.blogPessoal.model.Tema;
import com.generation.blogPessoal.repositories.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){
        return ResponseEntity.ok(temaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable  long id){
        return temaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Tema>> getByName(@PathVariable String nome){
        return ResponseEntity.ok(temaRepository.findAllByDescricaoContainsIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Tema> post (@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
    }

    @PutMapping
    public ResponseEntity<Tema> put (@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(tema));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        temaRepository.deleteById(id);
    }
}
