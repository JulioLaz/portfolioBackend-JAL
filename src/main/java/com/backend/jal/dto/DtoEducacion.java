package com.backend.jal.dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private String schoolE;
    @NotBlank
    private String titleE;
    @NotBlank
    private String timeE;
    @NotBlank
    private int startE;
    @NotBlank
    private int endE;
    @NotBlank
    private String estadoE;
    @NotBlank
    private String cityE;
    @NotBlank
    private String imgE;
    @NotBlank
    private int usuarioId;

    public DtoEducacion() {
    }

    public DtoEducacion(String schoolE, String titleE, String timeE, int startE, int endE, String estadoE, String cityE, String imgE, int usuarioId) {
        this.schoolE = schoolE;
        this.titleE = titleE;
        this.timeE = timeE;
        this.startE = startE;
        this.endE = endE;
        this.estadoE = estadoE;
        this.cityE = cityE;
        this.imgE = imgE;
        this.usuarioId = usuarioId;
    }

    public String getSchoolE() {
        return schoolE;
    }

    public void setSchoolE(String schoolE) {
        this.schoolE = schoolE;
    }

    public String getTitleE() {
        return titleE;
    }

    public void setTitleE(String titleE) {
        this.titleE = titleE;
    }

    public String getTimeE() {
        return timeE;
    }

    public void setTimeE(String timeE) {
        this.timeE = timeE;
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

    public String getEstadoE() {
        return estadoE;
    }

    public void setEstadoE(String estadoE) {
        this.estadoE = estadoE;
    }

    public String getCityE() {
        return cityE;
    }

    public void setCityE(String cityE) {
        this.cityE = cityE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

}
