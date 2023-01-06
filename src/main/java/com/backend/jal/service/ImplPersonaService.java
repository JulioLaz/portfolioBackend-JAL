package com.backend.jal.service;

import com.backend.jal.entity.Persona;
import com.backend.jal.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImplPersonaService {

    @Autowired
    IPersonaRepository iPersonaRepository;

    public List<Persona> list() {
        return iPersonaRepository.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return iPersonaRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return iPersonaRepository.findByNombre(nombre);
    }

    public void save(Persona persona) {
        iPersonaRepository.save(persona);
    }

    public void delete(int id) {
        iPersonaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iPersonaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iPersonaRepository.existsByNombre(nombre);
    }
}
