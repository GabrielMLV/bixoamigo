package com.brasil.bixoamigo.repository;

import com.brasil.bixoamigo.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PetRepository extends JpaRepository<Pet, Long> {
}
