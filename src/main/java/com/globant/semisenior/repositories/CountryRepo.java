package com.globant.semisenior.repositories;

import com.globant.semisenior.entitities.CountryEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<CountryEntity, Long> {

  Optional<CountryEntity> findByName(String name);
}
