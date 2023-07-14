package com.backend.jal.controller;

import com.backend.jal.dto.DtoIdiomas;
import com.backend.jal.entity.Idiomas;
import com.backend.jal.security.controller.Mensaje;
import com.backend.jal.service.SIdiomas;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idiomas")
@CrossOrigin(origins = {"http://localhost:4200", "https://julio-lazarte-cv.web.app"})

public class CIdiomas {
    @Autowired
    SIdiomas sidiomas;
//    RIdiomas ridiomas;

    @GetMapping("/lista")
    public ResponseEntity<List<Idiomas>> list() {
//        this.findAll();
        sidiomas.findAllByOrderByNombreAsc();
        List<Idiomas> lista = sidiomas.list();
        
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Idiomas> getById(@PathVariable("id") int id) {
        if (!sidiomas.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Idiomas idioma = sidiomas.getOne(id).get();
        return new ResponseEntity(idioma, HttpStatus.OK);
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<Idiomas>> getIdiomasByNombre(@RequestParam String nombre){
            Optional<Idiomas> idioma = sidiomas.getByNombre(nombre);
            return new ResponseEntity(idioma, HttpStatus.OK);
    }

    @GetMapping("/usuarioId/{usuarioId}")
        public ResponseEntity<List<Idiomas>> getIdiomasByUsuarioId(@PathVariable("usuarioId") int usuarioId){
            List<Idiomas> idioma = sidiomas.findByUsuarioId(usuarioId);
            return new ResponseEntity(idioma, HttpStatus.OK);
    }
        
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sidiomas.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sidiomas.delete(id);
        return new ResponseEntity(new Mensaje("Idioma eliminado"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuarioId/{usuarioId}")
    public ResponseEntity<?> deleteUsuarioId(@PathVariable("usuarioId") int usuarioId){
        sidiomas.deleteUsuarioId(usuarioId);
        return new ResponseEntity(new Mensaje("Educacion eliminada por usuarioId"), HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoIdiomas dtoIdioma) {
//        if (StringUtils.isBlank(dtoIdioma.getNombre())) {
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if (sidiomas.existsByNombre(dtoIdioma.getNombre())) {
//            return new ResponseEntity(new Mensaje("Esa idioma ya existe"), HttpStatus.BAD_REQUEST);
//        }

        Idiomas idioma = new Idiomas(dtoIdioma.getNombre(),dtoIdioma.getPorcentaje(), dtoIdioma.getImgURL(),dtoIdioma.getUsuarioId());
        sidiomas.save(idioma);
        return new ResponseEntity(new Mensaje("Idioma agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoIdiomas dtoIdioma) {
        //Validamos si existe el ID
        if (!sidiomas.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre
        if (sidiomas.existsByNombre(dtoIdioma.getNombre()) && sidiomas.getByNombre(dtoIdioma.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Este idioma ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoIdioma.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Idiomas idiomas = sidiomas.getOne(id).get();
        idiomas.setNombre(dtoIdioma.getNombre());
        idiomas.setPorcentaje(dtoIdioma.getPorcentaje());
        idiomas.setImgURL(dtoIdioma.getImgURL());
        sidiomas.save(idiomas);
        return new ResponseEntity(new Mensaje("Idioma actualizado"), HttpStatus.OK);

    }
}