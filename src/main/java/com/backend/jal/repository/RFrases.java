package com.backend.jal.repository;

import com.backend.jal.entity.Frases;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RFrases extends JpaRepository<Frases, Integer> {

    public Optional<Frases> findByFrases(String frases);

    public boolean existsByFrases(String frases);

    public List<Frases> findByUsuarioId(int usuarioId);

    public List<Frases> findByFrases(int usuarioId);
    
    public void deleteByUsuarioId(int usuarioId);    
}
