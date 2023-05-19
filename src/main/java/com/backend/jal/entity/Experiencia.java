package com.backend.jal.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String cargoE;
    private String descripcionE;
    private int startE;
    private int endE;
    private String cityE;
    private int usuarioId;
    
    public Experiencia() {
    }

    public Experiencia(String nombreE, String cargoE, String descripcionE, int startE, int endE, String cityE, int usuarioId) {
        this.nombreE = nombreE;
        this.cargoE = cargoE;
        this.descripcionE = descripcionE;
        this.startE = startE;
        this.endE = endE;
        this.cityE = cityE;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getCargoE() {
        return cargoE;
    }

    public void setCargoE(String cargoE) {
        this.cargoE = cargoE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public int getStartE() {
        return startE;
    }

    public void setStartE(int startE) {
        this.startE = startE;
    }

    public int getEndE() {
        return endE;
    }

    public void setEndE(int endE) {
        this.endE = endE;
    }

    public String getCityE() {
        return cityE;
    }

    public void setCityE(String cityE) {
        this.cityE = cityE;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
   


}
