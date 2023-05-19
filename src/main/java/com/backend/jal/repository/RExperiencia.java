package com.backend.jal.repository;

import com.backend.jal.entity.Experiencia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {

    public Optional<Experiencia> findByNombreE(String nombreE);

    public boolean existsByNombreE(String nombreE);

    List<Experiencia> findAllByOrderByEndEDesc();

    public List<Experiencia> findByUsuarioId(int usuarioId);

    public void deleteByUsuarioId(int usuarioId);

    public List<Experiencia> findByUsuarioIdOrderByEndEDesc(int usuarioId);
}
