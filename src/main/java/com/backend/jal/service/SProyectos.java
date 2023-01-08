package com.backend.jal.service;

import com.backend.jal.entity.Proyectos;
import com.backend.jal.repository.RProyectos;
import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SProyectos {

    @Autowired
    RProyectos rProyectos;

    public List<Proyectos> list() {
        return rProyectos.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return rProyectos.findById(id);
    }

    public Optional<Proyectos> getByProyectos(String proyectos) {
        return rProyectos.findByProyectos(proyectos);
    }

    public void save(Proyectos proyectos) {
        rProyectos.save(proyectos);
    }

    public void delete(int id) {
        rProyectos.deleteById(id);
    }

    public boolean existsById(int id) {
        return rProyectos.existsById(id);
    }

    public boolean existsByProyectos(String proyectos) {
        return rProyectos.existsByProyectos(proyectos);
    }
}
