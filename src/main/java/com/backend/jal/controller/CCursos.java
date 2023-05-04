package com.backend.jal.controller;
import com.backend.jal.dto.DtoCursos;
import com.backend.jal.entity.Cursos;
import com.backend.jal.security.controller.Mensaje;
import com.backend.jal.service.SCursos;
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
@RequestMapping("/cursos")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-julio-lazarte.web.app"})
public class CCursos {
@Autowired
    SCursos sCursos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Cursos>> list(){
        List<Cursos> list = sCursos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/usuarioId/{usuarioId}")
    public ResponseEntity<List<Cursos>> getIdiomasByUsuarioId(@PathVariable("usuarioId") int usuarioId){
            List<Cursos> idioma = sCursos.findByUsuarioId(usuarioId);
            return new ResponseEntity(idioma, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Cursos> getById(@PathVariable("id")int id){
        if(!sCursos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Cursos cursos = sCursos.getOne(id).get();
        return new ResponseEntity(cursos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sCursos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sCursos.delete(id);
        return new ResponseEntity(new Mensaje("Cursos eliminada"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuarioId/{usuarioId}")
    public ResponseEntity<?> deleteUsuarioId(@PathVariable("usuarioId") int usuarioId){
        sCursos.deleteUsuarioId(usuarioId);
        return new ResponseEntity(new Mensaje("Curso eliminado por usuarioId"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoCursos dtocursos){
//        if(StringUtils.isBlank(dtocursos.getImgProyecto())){
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if(sCursos.existsBySchoolE(dtocursos.getProyecto())){
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        }
        
        Cursos cursos = new Cursos(dtocursos.getCurso(),dtocursos.getDescripcion(),dtocursos.getImgCurso(),dtocursos.getUsuarioId()
            );
            sCursos.save(cursos);
        return new ResponseEntity(new Mensaje("Curso creado"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoCursos dtocursos){
        if(!sCursos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sCursos.existsByCursos(dtocursos.getCurso()) && sCursos.getByCursos(dtocursos.getCurso()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtocursos.getCurso())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Cursos cursos = sCursos.getOne(id).get();
        
        cursos.setCurso(dtocursos.getCurso());
        cursos.setDescripcion(dtocursos.getDescripcion());
        cursos.setImgCurso(dtocursos.getImgCurso());
        
        sCursos.save(cursos);
        
        return new ResponseEntity(new Mensaje("Cursos actualizada"), HttpStatus.OK);
    }    
}
