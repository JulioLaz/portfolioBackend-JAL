package com.backend.jal.repository;

import com.backend.jal.entity.Proyectos;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer> {

    public Optional<Proyectos> findByProyectos(String proyectos);

    public boolean existsByProyectos(String proyectos);

    public List<Proyectos> findByUsuarioId(int usuarioId);
    
    public void deleteByUsuarioId(int usuarioId);    
}
