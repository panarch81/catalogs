package com.globant.semisenior.repositories;

import com.globant.semisenior.entitities.ContinentEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepo extends JpaRepository<ContinentEntity, Long> {

  Optional<ContinentEntity> findByName(String name);
  Optional<ContinentEntity> findById(Long name);
}
