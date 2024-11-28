package com.Transpiedecuesta.controllers;

import com.Transpiedecuesta.entities.Bus;
import com.Transpiedecuesta.repositories.BusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BusController {

    @Autowired
    private BusRepository busRepository;

    // Listar todos los buses
    @GetMapping("/buses")
    public String listarBuses(Model model) {
        List<Bus> buses = busRepository.findAll();
        model.addAttribute("buses", buses);
        return "buses";
    }

    // Mostrar formulario para crear un nuevo bus
    @GetMapping("/buses/crear")
    public String crearBus(Model model) {
        model.addAttribute("bus", new Bus());
        return "formBus";
    }

    // Mostrar formulario para editar un bus existente
    @GetMapping("/buses/editar/{id}")
    public String editarBus(@PathVariable String id, Model model) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("bus", bus);
        return "formBus";
    }

    // Guardar un bus (nuevo o editado)
    @PostMapping("/buses/guardar")
    public String guardarBus(Bus bus) {
        // Se guarda el bus con todos sus atributos, incluida la URL de la imagen
        busRepository.save(bus);
        return "redirect:/buses";
    }

    // Eliminar un bus por su ID
    @GetMapping("/buses/eliminar/{id}")
    public String eliminarBus(@PathVariable String id) {
        busRepository.deleteById(id);
        return "redirect:/buses";
    }
}
