package com.bn.crud.controllers;


import com.bn.crud.model.LivroModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bn.crud.services.LivroServices;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private  final LivroServices service;

    public LivroController(LivroServices service) {
        this.service = service;
    }

    //Padrão 201: Recurso criado com sucesso
    @PostMapping
    public ResponseEntity<LivroModel> criar(@RequestBody LivroModel livro) {
        LivroModel salvo = service.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    //Padrão 200: Sucesso ao retornar lista
    @GetMapping
    public ResponseEntity<List<LivroModel>> listar(){
        List<LivroModel> livros = service.listar();
        return  ResponseEntity.ok(livros);
    }

    //Padrão 200 para sucesso ou 404 para não encontrado
    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscar(@PathVariable Long id){
        LivroModel livro = service.buscar(id);
        if(livro != null){
            return ResponseEntity.ok(livro);
        }
        return ResponseEntity.notFound().build();
    }

    //Padrão 204: Sucesso na deleção (Sem conteúdo no corpo da resposta)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
