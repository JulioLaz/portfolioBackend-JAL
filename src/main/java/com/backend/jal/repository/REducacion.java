package com.backend.jal.repository;

import com.backend.jal.entity.Educacion;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {

    public Optional<Educacion> findBySchoolE(String schoolE);

    public boolean existsBySchoolE(String schoolE);

    List<Educacion> findAllByOrderByEndEDesc();

    public List<Educacion> findByUsuarioId(int usuarioId);

    public void deleteByUsuarioId(int usuarioId);

    public List<Educacion> findByUsuarioIdOrderByEndEDesc(int usuarioId);
}
