package com.Transpiedecuesta.repositories;

import com.Transpiedecuesta.entities.Contacto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactoRepository extends MongoRepository<Contacto, String> {
}
