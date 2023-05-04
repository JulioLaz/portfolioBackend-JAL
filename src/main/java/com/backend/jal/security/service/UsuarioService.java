package com.backend.jal.security.service;

import com.backend.jal.security.entity.Usuario;
import com.backend.jal.security.repository.IUsuarioRepository;
import java.util.List;
import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    IUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public Optional<Usuario> getByNombreUsuarioOrEmail(String nombreOrEamil) {
        return iusuarioRepository.findByNombreUsuarioOrEmail(nombreOrEamil,nombreOrEamil);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
    
    //////////////nuevo//////////
    public Optional<Usuario> getOne(int id) {
        return iusuarioRepository.findById(id);
    }
        
        public boolean existsById(int id) {
        return iusuarioRepository.existsById(id);
    }

        public boolean existsByNombre(String usuario) {
        return iusuarioRepository.existsByNombre(usuario);
    }   
        
        public List<Usuario> list(){
        return iusuarioRepository.findAll();
    }
        
        public void delete(int id) {
        iusuarioRepository.deleteById(id);
    }

        public List<Usuario> findByNombre(String nombre){
        return iusuarioRepository.findByNombre( nombre);
    }

    public Optional<Usuario> getByTokenPassword(String tokenPassword) {
        return iusuarioRepository.findByTokenPassword(tokenPassword);
    }
}
