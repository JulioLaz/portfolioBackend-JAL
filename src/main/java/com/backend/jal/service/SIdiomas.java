package com.backend.jal.service;

import com.backend.jal.entity.Idiomas;
import com.backend.jal.repository.RIdiomas;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SIdiomas {

    @Autowired
    RIdiomas ridiomas;

    public List<Idiomas> list() {
        return ridiomas.findAll();
    }

    public Optional<Idiomas> getOne(int id) {
        return ridiomas.findById(id);
    }

    public Optional<Idiomas> getByNombre(String nombre) {
        return ridiomas.findByNombre(nombre);
    }

    public void save(Idiomas idiomas) {
        ridiomas.save(idiomas);
    }

    public void delete(int id) {
        ridiomas.deleteById(id);
    }

    public boolean existsById(int id) {
        return ridiomas.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return ridiomas.existsByNombre(nombre);
    }
}
