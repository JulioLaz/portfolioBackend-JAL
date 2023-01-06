package com.backend.jal.controller;

import com.backend.jal.dto.DtoIdiomas;
import com.backend.jal.entity.Idiomas;
import com.backend.jal.security.controller.Mensaje;
import com.backend.jal.service.SIdiomas;
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
@RequestMapping("/idiomas")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-julio-lazarte.web.app"})

public class CIdiomas {
    @Autowired
    SIdiomas sidiomas;

    @GetMapping("/lista")
    public ResponseEntity<List<Idiomas>> list() {

        List<Idiomas> list = sidiomas.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Idiomas> getById(@PathVariable("id") int id) {
        if (!sidiomas.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Idiomas hss = sidiomas.getOne(id).get();
        return new ResponseEntity(hss, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sidiomas.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sidiomas.delete(id);
        return new ResponseEntity(new Mensaje("Idioma eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoIdiomas dtohss) {
        if (StringUtils.isBlank(dtohss.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sidiomas.existsByNombre(dtohss.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa idioma ya existe"), HttpStatus.BAD_REQUEST);
        }

        Idiomas hss = new Idiomas(dtohss.getNombre(),dtohss.getPorcentaje(), dtohss.getImgURL());
        sidiomas.save(hss);

        
        
        return new ResponseEntity(new Mensaje("Idioma agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoIdiomas dtohss) {
        //Validamos si existe el ID
        if (!sidiomas.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre
        if (sidiomas.existsByNombre(dtohss.getNombre()) && sidiomas.getByNombre(dtohss.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Este idioma ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohss.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Idiomas idiomas = sidiomas.getOne(id).get();
        idiomas.setNombre(dtohss.getNombre());
        idiomas.setPorcentaje(dtohss.getPorcentaje());
        idiomas.setImgURL(dtohss.getImgURL());
        sidiomas.save(idiomas);
        return new ResponseEntity(new Mensaje("Idioma actualizado"), HttpStatus.OK);

    }
}