package com.Transpiedecuesta.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "horarios")
public class Horario {

    @Id
    private String id;

    private Ruta ruta; // Ruta como subdocumento

    private String horaSalida;
    private String horaLlegada;

    public Horario() {}

    public Horario(Ruta ruta, String horaSalida, String horaLlegada) {
        this.ruta = ruta;
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

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
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

    @Override
    public String toString() {
        return "Horario{" +
               "id='" + id + '\'' +
               ", ruta=" + (ruta != null ? ruta.getNombre() : "Desconocida") +
               ", horaSalida='" + horaSalida + '\'' +
               ", horaLlegada='" + horaLlegada + '\'' +
               '}';
    }
}

