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
    private String startE;
    @NotBlank
    private String endE;
    @NotBlank
    private String estadoE;
    @NotBlank
    private String cityE;
    @NotBlank
    private String imgE;

    public DtoEducacion() {
    }

    public DtoEducacion(String schoolE, String titleE, String timeE, String startE, String endE, String estadoE, String cityE, String imgE) {
        this.schoolE = schoolE;
        this.titleE = titleE;
        this.timeE = timeE;
        this.startE = startE;
        this.endE = endE;
        this.estadoE = estadoE;
        this.cityE = cityE;
        this.imgE = imgE;
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

}
