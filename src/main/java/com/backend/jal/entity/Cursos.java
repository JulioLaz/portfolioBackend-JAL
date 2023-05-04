package com.backend.jal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cursos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cursos;
    private String descripcion;
    private String imgCurso;
    private int usuarioId;

    public Cursos() {
    }

    public Cursos(String cursos, String descripcion, String imgCurso, int usuarioId) {
        this.cursos = cursos;
        this.descripcion = descripcion;
        this.imgCurso = imgCurso;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return cursos;
    }

    public void setCurso(String cursos) {
        this.cursos = cursos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgCurso() {
        return imgCurso;
    }

    public void setImgCurso(String imgCurso) {
        this.imgCurso = imgCurso;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
}

