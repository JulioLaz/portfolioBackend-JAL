package com.backend.jal.repository;

import com.backend.jal.entity.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {

    public Optional<Persona> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);

//    public List<Persona> findAllByOrderById();

    public List<Persona> findAllByOrderByIdDesc();
    
    
}
