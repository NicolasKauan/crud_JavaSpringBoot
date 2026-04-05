package repositories;

import model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositories extends JpaRepository<LivroModel, Long> {
}

