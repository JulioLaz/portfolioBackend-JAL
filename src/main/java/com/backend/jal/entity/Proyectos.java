package com.backend.jal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String proyectos;
    private String descripcion;
    private String fecha;
    private String imgProyecto;
    private String imgLenguajes;
    private String urlProyecto;


    public Proyectos() {
    }

    public Proyectos(String proyectos, String descripcion, String fecha, String imgProyecto, String imgLenguajes, String urlProyecto) {
        this.proyectos = proyectos;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.imgProyecto = imgProyecto;
        this.imgLenguajes = imgLenguajes;
        this.urlProyecto = urlProyecto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
