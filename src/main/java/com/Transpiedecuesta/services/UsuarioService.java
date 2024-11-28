package com.Transpiedecuesta.services;

import com.Transpiedecuesta.entities.Usuario;
import com.Transpiedecuesta.repositories.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private HttpSession session;

	public boolean autenticarUsuario(String correo, String clave) {
		Usuario usuario = usuarioRepository.findByCorreoAndClave(correo, clave);
		if (usuario != null) {
			// Almacena el rol del usuario en la sesión
			session.setAttribute("rolUsuario", usuario.getRol());
			return true;
		}
		return false;
	}

	public String obtenerRolUsuarioActual() {
		return (String) session.getAttribute("rolUsuario");
	}
}
