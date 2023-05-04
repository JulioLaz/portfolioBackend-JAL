package com.backend.jal.repository;

import com.backend.jal.entity.Cursos;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RCursos extends JpaRepository<Cursos, Integer> {

    public Optional<Cursos> findByCursos(String cursos);

    public boolean existsByCursos(String cursos);

    public List<Cursos> findByUsuarioId(int usuarioId);
    
    public void deleteByUsuarioId(int usuarioId);   
}
