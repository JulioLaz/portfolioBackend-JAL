package com.backend.jal.dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String cargoE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private int startE;
    @NotBlank
    private int endE;
    @NotBlank
    private String cityE;
    @NotBlank
    private int usuarioId;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String cargoE, String descripcionE, int startE, int endE, String cityE, int usuarioId) {
        this.nombreE = nombreE;
        this.cargoE = cargoE;
        this.descripcionE = descripcionE;
        this.startE = startE;
        this.endE = endE;
        this.cityE = cityE;
        this.usuarioId = usuarioId;
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
