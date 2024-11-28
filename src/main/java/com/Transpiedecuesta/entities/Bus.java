package com.Transpiedecuesta.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "buses_disponibles")
public class Bus {

    @Id
    private String id;
    private String placa;      // Placa del bus
    private String modelo;     // Modelo del bus
    private int capacidad;     // Capacidad de pasajeros
    private boolean disponible; // Estado de disponibilidad del bus
    private String imagenUrl;  // URL de la imagen del bus

    public Bus() {}

    public Bus(String placa, String modelo, int capacidad, boolean disponible, String imagenUrl) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.disponible = disponible;
        this.imagenUrl = imagenUrl;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
