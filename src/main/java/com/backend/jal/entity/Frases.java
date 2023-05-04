package com.backend.jal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String autor;
    private String frases;
    private int seccionId;
    private int usuarioId;
    
    public Frases() {
    }

    public Frases(String autor, String frases, int seccionId, int usuarioId) {
        this.autor = autor;
        this.frases = frases;
        this.seccionId = seccionId;
        this.usuarioId = usuarioId;
    }

    public int getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFrases() {
        return frases;
    }

    public void setFrases(String frases) {
        this.frases = frases;
    }

}
