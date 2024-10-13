package org.example.actividad;

public class Equipo {
    private int idEquipo;
    private String nombreEquipo;
    private String edad;
    private String categoria;

    public Equipo(String nombreEquipo, String edad, String categoria) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.edad = edad;
        this.categoria = categoria;
    }

    public Equipo() {

    }


    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = String.valueOf(edad);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
