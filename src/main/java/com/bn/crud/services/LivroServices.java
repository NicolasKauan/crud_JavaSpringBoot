package com.bn.crud.services;


import com.bn.crud.model.LivroModel;
import org.springframework.stereotype.Service;
import com.bn.crud.repositories.LivroRepositories;

import java.util.List;

@Service
public class LivroServices {
    private final LivroRepositories repositories;

    public LivroServices(LivroRepositories repositories) {
        this.repositories = repositories;
    }

    public LivroModel salvar(LivroModel livro){
        return repositories.save(livro);
    }

    public List<LivroModel> listar(){
        return repositories.findAll();
    }

    public LivroModel buscar(Long id){
        return repositories.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repositories.deleteById(id);
    }

}
