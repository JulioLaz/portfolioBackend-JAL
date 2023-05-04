package com.backend.jal.dto;

public class DtoProyectos {

    private String proyectos;
    private String descripcion;
    private String fecha;
    private String imgProyecto;
    private String imgLenguajes;
    private String urlProyecto;
    private int usuarioId;
    
    public DtoProyectos() {
    }

    public DtoProyectos(String proyectos, String descripcion, String fecha, String imgProyecto, String imgLenguajes, String urlProyecto, int usuarioId) {
        this.proyectos = proyectos;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.imgProyecto = imgProyecto;
        this.imgLenguajes = imgLenguajes;
        this.urlProyecto = urlProyecto;
        this.usuarioId = usuarioId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }



    public String getProyectos() {
        return proyectos;
    }

    public void setProyectos(String proyectos) {
        this.proyectos = proyectos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }

    public String getImgLenguajes() {
        return imgLenguajes;
    }

    public void setImgLenguajes(String imgLenguajes) {
        this.imgLenguajes = imgLenguajes;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }

    
}
