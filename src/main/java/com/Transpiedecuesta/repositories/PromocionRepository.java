package com.Transpiedecuesta.repositories;

import com.Transpiedecuesta.entities.Promocion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PromocionRepository extends MongoRepository<Promocion, String> {
}
