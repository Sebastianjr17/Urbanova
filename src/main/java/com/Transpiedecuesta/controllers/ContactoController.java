package com.Transpiedecuesta.controllers;

import com.Transpiedecuesta.entities.Contacto;
import com.Transpiedecuesta.repositories.ContactoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping("/contacto")
    public String mostrarFormularioContacto(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formContacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarMensaje(Contacto contacto) {
        contactoRepository.save(contacto);
        return "redirect:/contacto/gracias";
    }

    @GetMapping("/contacto/gracias")
    public String mostrarPaginaGracias() {
        return "graciasContacto";
    }

    @GetMapping("/contacto/mensajes")
    public String listarMensajes(Model model) {
        model.addAttribute("mensajes", contactoRepository.findAll());
        return "mensajesContacto";
    }

    @GetMapping("/contacto/eliminar/{id}")
    public String eliminarMensaje(@PathVariable String id) {
        contactoRepository.deleteById(id);
        return "redirect:/contacto/mensajes";
    }
}

