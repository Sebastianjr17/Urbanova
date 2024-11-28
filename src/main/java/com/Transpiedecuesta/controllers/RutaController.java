package com.Transpiedecuesta.controllers;

import com.Transpiedecuesta.entities.Ruta;
import com.Transpiedecuesta.repositories.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping
    public String listarRutas(Model model) {
        List<Ruta> rutas = rutaRepository.findAll();
        model.addAttribute("rutas", rutas);
        return "rutas";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("ruta", new Ruta());
        return "formRuta";
    }

    @PostMapping("/guardar")
    public String guardarRuta(@ModelAttribute Ruta ruta) {
        rutaRepository.save(ruta);
        return "redirect:/rutas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Ruta ruta = rutaRepository.findById(id).orElse(null);
        model.addAttribute("ruta", ruta);
        return "formRuta";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRuta(@PathVariable String id) {
        rutaRepository.deleteById(id);
        return "redirect:/rutas";
    }
}
