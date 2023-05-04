package com.backend.jal.service;

import com.backend.jal.entity.Cursos;
import com.backend.jal.repository.RCursos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCursos {
    
    @Autowired
    RCursos rCursos;

    public List<Cursos> list() {
        return rCursos.findAll();
    }

    public Optional<Cursos> getOne(int id) {
        return rCursos.findById(id);
    }

    public Optional<Cursos> getByCursos(String cursos) {
        return rCursos.findByCursos(cursos);
    }

    public void save(Cursos cursos) {
        rCursos.save(cursos);
    }

    public void delete(int id) {
        rCursos.deleteById(id);
    }

    public boolean existsById(int id) {
        return rCursos.existsById(id);
    }

    public boolean existsByCursos(String cursos) {
        return rCursos.existsByCursos(cursos);
    }
    
    public List<Cursos> findByUsuarioId(int usuarioId){
        return rCursos.findByUsuarioId( usuarioId);
    }
    
    public void deleteUsuarioId(int usuarioId){
        rCursos.deleteByUsuarioId(usuarioId);
    } 
}
