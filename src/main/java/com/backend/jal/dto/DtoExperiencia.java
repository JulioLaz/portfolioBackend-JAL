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
    private String startE;
    @NotBlank
    private String endE;
    @NotBlank
    private String cityE;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String cargoE, String descripcionE, String startE, String endE, String cityE) {
        this.nombreE = nombreE;
        this.cargoE = cargoE;
        this.descripcionE = descripcionE;
        this.startE = startE;
        this.endE = endE;
        this.cityE = cityE;
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

    public String getStartE() {
        return startE;
    }

    public void setStartE(String startE) {
        this.startE = startE;
    }

    public String getEndE() {
        return endE;
    }

    public void setEndE(String endE) {
        this.endE = endE;
    }

    public String getCityE() {
        return cityE;
    }

    public void setCityE(String cityE) {
        this.cityE = cityE;
    }


}
