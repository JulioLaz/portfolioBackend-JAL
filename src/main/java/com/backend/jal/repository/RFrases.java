package com.backend.jal.repository;

import com.backend.jal.entity.Frases;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RFrases extends JpaRepository<Frases, Integer> {

    public Optional<Frases> findByFrases(String frases);

    public boolean existsByFrases(String frases);
}
