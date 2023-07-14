package com.backend.jal.controller;

import com.backend.jal.dto.DtoHardAndSSkills;
import com.backend.jal.entity.HardAndSSkills;
import com.backend.jal.security.controller.Mensaje;
import com.backend.jal.service.SHardAndSSkills;
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
@RequestMapping("/skill")
@CrossOrigin(origins = {"http://localhost:4200", "https://julio-lazarte-cv.web.app"})

public class CHardAndSSkills {

    @Autowired
    SHardAndSSkills shss;

    @GetMapping("/lista")
    public ResponseEntity<List<HardAndSSkills>> list() {

        List<HardAndSSkills> list = shss.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HardAndSSkills> getById(@PathVariable("id") int id) {
        if (!shss.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HardAndSSkills hss = shss.getOne(id).get();
        return new ResponseEntity(hss, HttpStatus.OK);
    }

        @GetMapping("/usuarioId/{usuarioId}")
        public ResponseEntity<List<HardAndSSkills>> getIdiomasByUsuarioId(@PathVariable("usuarioId") int usuarioId){
//            List<HardAndSSkills> hss = shss.findByUsuarioId(usuarioId);
              List<HardAndSSkills> hss= shss.findByUsuarioId(usuarioId);
            return new ResponseEntity(hss, HttpStatus.OK);
    } 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shss.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        shss.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuarioId/{usuarioId}")
    public ResponseEntity<?> deleteUsuarioId(@PathVariable("usuarioId") int usuarioId){
        shss.deleteUsuarioId(usuarioId);
        return new ResponseEntity(new Mensaje("Educacion eliminada por usuarioId"), HttpStatus.OK);
    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHardAndSSkills dtohss) {
//        if (StringUtils.isBlank(dtohss.getNombre())) {
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if (shss.existsByNombre(dtohss.getNombre())) {
//            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
//        }

        HardAndSSkills hss = new HardAndSSkills(dtohss.getNombre(),dtohss.getPorcentaje(), dtohss.getImgURL(), dtohss.getUsuarioId());
        shss.save(hss);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHardAndSSkills dtohss) {
        //Validamos si existe el ID
        if (!shss.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (shss.existsByNombre(dtohss.getNombre()) && shss.getByNombre(dtohss.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohss.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        HardAndSSkills hss = shss.getOne(id).get();
        hss.setNombre(dtohss.getNombre());
        hss.setPorcentaje(dtohss.getPorcentaje());
        hss.setImgURL(dtohss.getImgURL());
        shss.save(hss);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
