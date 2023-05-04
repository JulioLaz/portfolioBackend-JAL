package com.backend.jal.service;

import com.backend.jal.entity.Idiomas;
import com.backend.jal.repository.RIdiomas;
import java.util.List;
import java.util.Optional;
//import org.springframework.data.domain.Sort;
//import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SIdiomas {

    @Autowired
    RIdiomas ridiomas;

    public List<Idiomas> list() {
        return ridiomas.findAllByOrderByNombreAsc();
    }

//       public List<Idiomas> list() {
//        return ridiomas.findAll();
//    }

       public Optional<Idiomas> getOne(int id) {
        return ridiomas.findById(id);
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

    public Optional<Idiomas> getByNombre(String nombre) {
        return ridiomas.findByNombre(nombre);
    }
    
    public boolean existsByNombre(String nombre) {
        return ridiomas.existsByNombre(nombre);
    }
    
    public List<Idiomas> findByUsuarioId(int usuarioId){
        return ridiomas.findByUsuarioId( usuarioId);
    }
    
    public List<Idiomas> findAllByOrderByNombreAsc(){
        return ridiomas.findAllByOrderByNombreAsc();
    }

    public void deleteUsuarioId(int usuarioId){
        ridiomas.deleteByUsuarioId(usuarioId);
    }      
//    public List<Idiomas> findAll() {
//        return ridiomas.findAll(sortByIdAsc());
//    }
//    public List<Idiomas> findAll(Sort nombre) {
//        return ridiomas.findAll( nombre);
//    }

}