package com.Transpiedecuesta.repositories;

import com.Transpiedecuesta.entities.Tarifa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarifaRepository extends MongoRepository<Tarifa, String> {}
