package com.backend.jal.controller;

import com.backend.jal.dto.DtoProyectos;
import com.backend.jal.entity.Proyectos;
import com.backend.jal.security.controller.Mensaje;
import com.backend.jal.service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-julio-lazarte.web.app"})

public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/usuarioId/{usuarioId}")
    public ResponseEntity<List<Proyectos>> getIdiomasByUsuarioId(@PathVariable("usuarioId") int usuarioId){
            List<Proyectos> idioma = sProyectos.findByUsuarioId(usuarioId);
            return new ResponseEntity(idioma, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyectos eliminada"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuarioId/{usuarioId}")
    public ResponseEntity<?> deleteUsuarioId(@PathVariable("usuarioId") int usuarioId){
        sProyectos.deleteUsuarioId(usuarioId);
        return new ResponseEntity(new Mensaje("Proyecto eliminada por usuarioId"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoproyectos){
//        if(StringUtils.isBlank(dtoproyectos.getImgProyecto())){
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if(sProyectos.existsBySchoolE(dtoproyectos.getProyecto())){
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        }
        
        Proyectos proyectos = new Proyectos(dtoproyectos.getProyectos(),dtoproyectos.getDescripcion(),dtoproyectos.getFecha(),dtoproyectos.getImgProyecto(),dtoproyectos.getImgLenguajes(),dtoproyectos.getUrlProyecto(),dtoproyectos.getUsuarioId()
            );
            sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoproyectos){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sProyectos.existsByProyectos(dtoproyectos.getProyectos()) && sProyectos.getByProyectos(dtoproyectos.getProyectos()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getProyectos())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        
        proyectos.setProyectos(dtoproyectos.getProyectos());
        proyectos.setDescripcion(dtoproyectos.getDescripcion());
        proyectos.setFecha(dtoproyectos.getFecha());
        proyectos.setImgProyecto(dtoproyectos.getImgProyecto());
        proyectos.setImgLenguajes(dtoproyectos.getImgLenguajes());
        proyectos.setUrlProyecto(dtoproyectos.getUrlProyecto());
        
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyectos actualizada"), HttpStatus.OK);
    }
}
