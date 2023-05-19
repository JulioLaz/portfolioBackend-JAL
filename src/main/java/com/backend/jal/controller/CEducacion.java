package com.backend.jal.controller;

import com.backend.jal.dto.DtoEducacion;
import com.backend.jal.entity.Educacion;
import com.backend.jal.security.controller.Mensaje;
import com.backend.jal.service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-julio-lazarte.web.app"})
public class CEducacion {

private final SEducacion sEducacion;

@Autowired
        public CEducacion(SEducacion sEducacion) {
    this.sEducacion = sEducacion;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.listOrderByEndEDesc();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/usuarioId/{usuarioId}")
    public ResponseEntity<List<Educacion>> getIdiomasByUsuarioId(@PathVariable("usuarioId") int usuarioId) {
        List<Educacion> idioma = sEducacion.findByUsuarioId(usuarioId);
        return new ResponseEntity(idioma, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuarioId/{usuarioId}")
    public ResponseEntity<?> deleteUsuarioId(@PathVariable("usuarioId") int usuarioId) {
        sEducacion.deleteUsuarioId(usuarioId);
        return new ResponseEntity(new Mensaje("Educacion eliminada por usuarioId"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoeducacion) {
        if (StringUtils.isBlank(dtoeducacion.getSchoolE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
//        if(sEducacion.existsBySchoolE(dtoeducacion.getSchoolE())){
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        }

        Educacion educacion = new Educacion(dtoeducacion.getSchoolE(), dtoeducacion.getTitleE(), dtoeducacion.getTimeE(), dtoeducacion.getStartE(), dtoeducacion.getEndE(), dtoeducacion.getEstadoE(), dtoeducacion.getCityE(), dtoeducacion.getImgE(), dtoeducacion.getUsuarioId()
        );
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoeducacion) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (sEducacion.existsBySchoolE(dtoeducacion.getSchoolE()) && sEducacion.getBySchoolE(dtoeducacion.getSchoolE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getSchoolE())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();

        educacion.setSchoolE(dtoeducacion.getSchoolE());
        educacion.setTitleE(dtoeducacion.getTitleE());
        educacion.setTimeE(dtoeducacion.getTimeE());
        educacion.setStartE(dtoeducacion.getStartE());
        educacion.setEndE(dtoeducacion.getEndE());
        educacion.setEstadoE(dtoeducacion.getEstadoE());
        educacion.setCityE(dtoeducacion.getCityE());
        educacion.setImgE(dtoeducacion.getImgE());

        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
