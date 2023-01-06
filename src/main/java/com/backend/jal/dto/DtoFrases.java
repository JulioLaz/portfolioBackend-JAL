package com.backend.jal.dto;

public class DtoFrases {

    private String autor;
    private String frases;

    public DtoFrases() {
    }

    public DtoFrases(String autor, String frases) {
        this.autor = autor;
        this.frases = frases;
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
