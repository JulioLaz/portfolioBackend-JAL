package com.backend.jal.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class DtoHardAndSSkills {
    @NotNull
    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String porcentaje;
    
    @Size(min = 1, max = 300,message = "No cumple con especificaciones")
    private String imgURL;

    private int usuarioId;
    
    public DtoHardAndSSkills() {
    }

    public DtoHardAndSSkills(String nombre, String porcentaje, String imgURL, int usuarioId) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imgURL = imgURL;
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

}
