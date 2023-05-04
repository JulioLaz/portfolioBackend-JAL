package com.backend.jal.service;

import com.backend.jal.entity.Frases;
import com.backend.jal.repository.RFrases;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SFrases {

    @Autowired
    RFrases rfrases;

    public List<Frases> list() {
        return rfrases.findAll();
    }

    public Optional<Frases> getOne(int id) {
        return rfrases.findById(id);
    }

    public Optional<Frases> getByFrases(String frases) {
        return rfrases.findByFrases(frases);
    }

    public void save(Frases frases) {
        rfrases.save(frases);
    }

    public void delete(int id) {
        rfrases.deleteById(id);
    }

    public boolean existsById(int id) {
        return rfrases.existsById(id);
    }

    public boolean existsByFrases(String frases) {
        return rfrases.existsByFrases(frases);
    }
    
    public List<Frases> findByUsuarioId(int usuarioId){
        return rfrases.findByUsuarioId( usuarioId);
    }
    public List<Frases> findByFrases(int usuarioId){
        return rfrases.findByFrases( usuarioId);
    }

    public void deleteUsuarioId(int usuarioId){
        rfrases.deleteByUsuarioId(usuarioId);
    }     
}
//findByFrases

