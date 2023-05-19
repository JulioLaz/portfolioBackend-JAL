package com.backend.jal.service;

import com.backend.jal.entity.Experiencia;
import com.backend.jal.repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {

    @Autowired
    RExperiencia rExperiencia;

    public List<Experiencia> list() {
        return rExperiencia.findAll();
    }

//    public List<Experiencia> listOrderBy() {
//        return rExperiencia.findAllByOrderByEndEDesc();
//    }
    public List<Experiencia> listOrderByEndEDesc() {
        return rExperiencia.findAllByOrderByEndEDesc();
    }

    public List<Experiencia> findByUsuarioId(int usuarioId) {
        return rExperiencia.findByUsuarioId(usuarioId);
    }

    public Optional<Experiencia> getOne(int id) {
        return rExperiencia.findById(id);
    }

    public Optional<Experiencia> getByNombreE(String nombreE) {
        return rExperiencia.findByNombreE(nombreE);
    }

    public void save(Experiencia expe) {
        rExperiencia.save(expe);
    }

    public void delete(int id) {
        rExperiencia.deleteById(id);
    }

    public boolean existsById(int id) {
        return rExperiencia.existsById(id);
    }

    public boolean existsByNombreE(String nombreE) {
        return rExperiencia.existsByNombreE(nombreE);
    }

    public void deleteUsuarioId(int usuarioId) {
        rExperiencia.deleteByUsuarioId(usuarioId);
    }

    public List<Experiencia> findByUsuarioIdOrderByEndEDesc(int usuarioId) {
        return rExperiencia.findByUsuarioIdOrderByEndEDesc(usuarioId);
    }

}
