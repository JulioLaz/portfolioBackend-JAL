package com.backend.jal.repository;

import com.backend.jal.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUser extends JpaRepository<User, Integer>{
        public Optional<User> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);

//    public List<Persona> findAllByOrderById();

    public List<User> findAllByOrderByIdDesc();

    public List<User> findAll();

    public Optional<User> findById(int id);

    public void deleteById(int id);

    public boolean existsById(int id);
}
