package com.Transpiedecuesta.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(collection = "tarifas")
public class Tarifa {

    @Id
    private String id;
    private String rutaId; // ID de la ruta asociada
    private BigDecimal precio; // Precio de la tarifa en BigDecimal

    public Tarifa() {}

    public Tarifa(String rutaId, BigDecimal precio) {
        this.rutaId = rutaId;
        this.precio = precio;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRutaId() {
        return rutaId;
    }

    public void setRutaId(String rutaId) {
        this.rutaId = rutaId;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
