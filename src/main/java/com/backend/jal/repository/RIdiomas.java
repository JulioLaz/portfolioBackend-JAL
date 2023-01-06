package com.backend.jal.repository;

import com.backend.jal.entity.Idiomas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RIdiomas extends JpaRepository<Idiomas, Integer> {

    Optional<Idiomas> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
