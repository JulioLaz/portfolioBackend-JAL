package com.backend.jal.controller;

import com.backend.jal.dto.DtoExperiencia;
import com.backend.jal.entity.Experiencia;
import com.backend.jal.security.controller.Mensaje;
import com.backend.jal.service.SExperiencia;
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
@RequestMapping("/explab")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-julio-lazarte.web.app"})

public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.listOrderByEndEDesc();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/usuarioId/{usuarioId}")
    public ResponseEntity<List<Experiencia>> getEducacionesByUsuarioId(@PathVariable("usuarioId") int usuarioId) {
        List<Experiencia> exp = sExperiencia.findByUsuarioIdOrderByEndEDesc(usuarioId);
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuarioId/{usuarioId}")
    public ResponseEntity<?> deleteUsuarioId(@PathVariable("usuarioId") int usuarioId) {
        sExperiencia.deleteUsuarioId(usuarioId);
        return new ResponseEntity(new Mensaje("Experiencia eliminada por usuarioId"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

//        if (sExperiencia.existsByNombreE(dtoexp.getNombreE())) {
//            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
//        }
        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getCargoE(), dtoexp.getDescripcionE(), dtoexp.getStartE(), dtoexp.getEndE(), dtoexp.getCityE(), dtoexp.getUsuarioId());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp) {
        //Validamos si existe el ID
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias

//        if (sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id) {
//            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
//        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setCargoE(dtoexp.getCargoE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        experiencia.setStartE(dtoexp.getStartE());
        experiencia.setEndE(dtoexp.getEndE());
        experiencia.setCityE(dtoexp.getCityE());

        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}
