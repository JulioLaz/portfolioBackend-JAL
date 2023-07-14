package com.backend.jal.controller;

import com.backend.jal.dto.DtoFrases;
import com.backend.jal.entity.Frases;
import com.backend.jal.security.controller.Mensaje;
import com.backend.jal.service.SFrases;
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
@RequestMapping("/frases")
@CrossOrigin(origins = {"http://localhost:4200", "https://julio-lazarte-cv.web.app"})

public class CFrases {
    @Autowired
    SFrases sfrases;

    @GetMapping("/lista")
    public ResponseEntity<List<Frases>> list() {

        List<Frases> list = sfrases.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Frases> getById(@PathVariable("id") int id) {
        if (!sfrases.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Frases hss = sfrases.getOne(id).get();
        return new ResponseEntity(hss, HttpStatus.OK);
    }

        @GetMapping("/usuarioId/{usuarioId}")
        public ResponseEntity<List<Frases>> getIdiomasByUsuarioId(@PathVariable("usuarioId") int usuarioId){
            List<Frases> idioma = sfrases.findByUsuarioId(usuarioId);
            return new ResponseEntity(idioma, HttpStatus.OK);
    }
        
        @GetMapping("/frasesUsuarioId/{usuarioId}")
        public ResponseEntity<List<Frases>> getIdiomasByFrases(@PathVariable("usuarioId") int usuarioId){
            List<Frases> idioma = sfrases.findByFrases(usuarioId);
            return new ResponseEntity(idioma, HttpStatus.OK);
    }    
        
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sfrases.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sfrases.delete(id);
        return new ResponseEntity(new Mensaje("Frases eliminado"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuarioId/{usuarioId}")
    public ResponseEntity<?> deleteUsuarioId(@PathVariable("usuarioId") int usuarioId){
        sfrases.deleteUsuarioId(usuarioId);
        return new ResponseEntity(new Mensaje("Educacion eliminada por usuarioId"), HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoFrases dtofrases) {
        if (StringUtils.isBlank(dtofrases.getAutor())) {
            return new ResponseEntity(new Mensaje("El nombre del autor es obligatorio"), HttpStatus.BAD_REQUEST);
        }
//        if (sfrases.existsByFrases(dtofrases.getAutor())) {
//            return new ResponseEntity(new Mensaje("Esa Frases ya existe"), HttpStatus.BAD_REQUEST);
//        }

        Frases hss = new Frases(dtofrases.getAutor(),dtofrases.getFrases(),dtofrases.getSeccionId(),dtofrases.getUsuarioId());
        sfrases.save(hss);

        return new ResponseEntity(new Mensaje("Frases agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoFrases dtofrases) {
        //Validamos si existe el ID
        if (!sfrases.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de frases
        if (sfrases.existsByFrases(dtofrases.getAutor()) && sfrases.getByFrases(dtofrases.getAutor()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Frases ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtofrases.getAutor())) {
            return new ResponseEntity(new Mensaje("Campo autor no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        Frases frases = sfrases.getOne(id).get();
        frases.setAutor(dtofrases.getAutor());
        frases.setFrases(dtofrases.getFrases());
        sfrases.save(frases);
        return new ResponseEntity(new Mensaje("Frase actualizada"), HttpStatus.OK);

    }
}