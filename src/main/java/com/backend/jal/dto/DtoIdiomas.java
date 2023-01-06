package com.backend.jal.dto;

public class DtoIdiomas {
    //    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String nombre;
    
//    @NotNull
//    @Size(min = 1, max = 50,message = "No cumple con especificaciones")
    private String porcentaje;
    
//    @NotNull
//    @Size(min = 1, max = 300,message = "No cumple con especificaciones")
    private String imgURL;

    public DtoIdiomas() {
    }

    public DtoIdiomas(String nombre, String porcentaje, String imgURL) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imgURL = imgURL;
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
    
    
}
