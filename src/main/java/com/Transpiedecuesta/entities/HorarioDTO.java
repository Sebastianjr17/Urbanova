package com.Transpiedecuesta.entities;

public class HorarioDTO {

    private String id;
    private String nombreRuta;
    private String horaSalida;
    private String horaLlegada;

    // Constructor
    public HorarioDTO(String id, String nombreRuta, String horaSalida, String horaLlegada) {
        this.id = id;
        this.nombreRuta = nombreRuta;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}
