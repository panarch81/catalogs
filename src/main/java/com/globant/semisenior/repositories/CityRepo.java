package com.globant.semisenior.repositories;

import com.globant.semisenior.entitities.CityEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<CityEntity, Long> {

  Optional<CityEntity> findByName(String name);
}
