package com.backend.jal.service;

import com.backend.jal.entity.HardAndSSkills;
import com.backend.jal.entity.Idiomas;
import com.backend.jal.repository.RHardAndSSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SHardAndSSkills {

    @Autowired
    RHardAndSSkills rhss;

    public List<HardAndSSkills> list() {
        return rhss.findAll();
    }

    public Optional<HardAndSSkills> getOne(int id) {
        return rhss.findById(id);
    }

    public Optional<HardAndSSkills> getByNombre(String nombre) {
        return rhss.findByNombre(nombre);
    }

    public void save(HardAndSSkills hardsskill) {
        rhss.save(hardsskill);
    }

    public void delete(int id) {
        rhss.deleteById(id);
    }

    public boolean existsById(int id) {
        return rhss.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return rhss.existsByNombre(nombre);
    }
    
    public List<HardAndSSkills> findByUsuarioId(int usuarioId){
        return rhss.findByUsuarioId( usuarioId);
    }
    
    public void deleteUsuarioId(int usuarioId){
        rhss.deleteByUsuarioId(usuarioId);
    }      
}
