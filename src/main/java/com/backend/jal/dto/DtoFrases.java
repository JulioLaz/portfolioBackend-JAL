package com.backend.jal.dto;

public class DtoFrases {

    private String autor;
    private String frases;
    private int seccionId;
    private int usuarioId;
    
    public DtoFrases() {
    }

    public DtoFrases(String autor, String frases, int seccionId, int usuarioId) {
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
