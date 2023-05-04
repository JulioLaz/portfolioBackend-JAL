package com.backend.jal.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String nombre;
    
//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String apellido;

//    @NotNull
//    @Size(min = 1, max = 300,message = "No cumple con especificaciones")
    private String img;

//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String title;

//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String edad;
    
//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String city;

//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String titleAbout;
    
//    @NotNull
//    @Size(min = 1, max = 500,message = "No cumple con especificaciones")
    private String about;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String img, String title, String edad, String city, String titleAbout, String about) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.title = title;
        this.edad = edad;
        this.city = city;
        this.titleAbout = titleAbout;
        this.about = about;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitleAbout() {
        return titleAbout;
    }

    public void setTitleAbout(String titleAbout) {
        this.titleAbout = titleAbout;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

   
    
}
