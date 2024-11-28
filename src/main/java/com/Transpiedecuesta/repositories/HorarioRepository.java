package com.Transpiedecuesta.repositories;

import com.Transpiedecuesta.entities.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HorarioRepository extends MongoRepository<Horario, String> {}
