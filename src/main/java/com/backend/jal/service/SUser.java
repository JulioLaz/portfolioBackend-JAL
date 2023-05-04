package com.backend.jal.service;

import com.backend.jal.entity.User;
import com.backend.jal.repository.RUser;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SUser {
     @Autowired
    RUser rUser;

    public List<User> list() {
        return rUser.findAll();
    }

    public Optional<User> getOne(int id) {
        return rUser.findById(id);
    }

    public Optional<User> getByNombre(String nombre) {
        return rUser.findByNombre(nombre);
    }

    public void save(User persona) {
        rUser.save(persona);
    }

    public void delete(int id) {
        rUser.deleteById(id);
    }

    public boolean existsById(int id) {
        return rUser.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return rUser.existsByNombre(nombre);
    }
    
          public List<User> listOrderBy(){
         return rUser.findAllByOrderByIdDesc();
     }   

    public List<User> findAll() {
    return rUser.findAll();
    }
}
