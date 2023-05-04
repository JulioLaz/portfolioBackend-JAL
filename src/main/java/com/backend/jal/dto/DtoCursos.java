package com.backend.jal.dto;

public class DtoCursos {
    private String cursos;
    private String descripcion;
    private String imgCurso;
    private int usuarioId;

    public DtoCursos() {
    }

    public DtoCursos(String cursos, String descripcion, String imgCurso, int usuarioId) {
        this.cursos = cursos;
        this.descripcion = descripcion;
        this.imgCurso = imgCurso;
        this.usuarioId = usuarioId;
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
