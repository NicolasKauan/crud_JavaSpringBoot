package com.bn.crud.repositories;

import com.bn.crud.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositories extends JpaRepository<LivroModel, Long> {
}

