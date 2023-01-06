package com.backend.jal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Idiomas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String nombre;

//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String porcentaje;

//    @NotNull
//    @Size(min = 1, max = 300,message = "No cumple con especificaciones")
    private String imgURL;

    public Idiomas() {
    }

    public Idiomas(String nombre, String porcentaje, String imgURL) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imgURL = imgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

}
