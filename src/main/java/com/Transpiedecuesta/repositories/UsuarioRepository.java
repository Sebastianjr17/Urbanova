package com.Transpiedecuesta.repositories;

import com.Transpiedecuesta.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	// Método para encontrar un usuario por correo
	Usuario findByCorreo(String correo);

	// Método para encontrar un usuario por correo y clave
	Usuario findByCorreoAndClave(String correo, String clave);
}
