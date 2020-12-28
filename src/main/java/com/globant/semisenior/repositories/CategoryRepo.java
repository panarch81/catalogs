package com.globant.semisenior.repositories;

import com.globant.semisenior.entitities.CategoryEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {

  Optional<CategoryEntity> findByName(String name);
}
