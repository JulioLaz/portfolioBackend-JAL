package com.backend.jal.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String schoolE;
    private String titleE;
    private String timeE;
    private int startE;
    private int endE;
    private String estadoE;
    private String cityE;
    private String imgE;
    private int usuarioId;

  
    public Educacion() {
    }

    public Educacion(String schoolE, String titleE, String timeE, int startE, int endE, String estadoE, String cityE, String imgE, int usuarioId) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
