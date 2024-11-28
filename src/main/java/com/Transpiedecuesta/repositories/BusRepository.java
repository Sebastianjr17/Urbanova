package com.Transpiedecuesta.repositories;

import com.Transpiedecuesta.entities.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends MongoRepository<Bus, String> {

    // Buscar buses disponibles
    List<Bus> findByDisponible(boolean disponible);

    // Buscar bus por placa
    Bus findByPlaca(String placa);
}
