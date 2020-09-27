package com.globant.semisenior.repositories;

import com.globant.semisenior.entitities.ElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepo extends JpaRepository<ElementEntity, Long> {

}
