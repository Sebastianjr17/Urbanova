package com.Transpiedecuesta.controllers;

import com.Transpiedecuesta.entities.Promocion;
import com.Transpiedecuesta.repositories.PromocionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PromocionController {

    @Autowired
    private PromocionRepository promocionRepository;

    @GetMapping("/promociones")
    public String listarPromociones(Model model) {
        List<Promocion> promociones = promocionRepository.findAll();
        model.addAttribute("promociones", promociones);
        return "promociones";
    }

    @GetMapping("/promociones/crear")
    public String crearPromocion(Model model) {
        model.addAttribute("promocion", new Promocion());
        return "formPromocion";
    }

    @GetMapping("/promociones/editar/{id}")
    public String editarPromocion(@PathVariable String id, Model model) {
        Promocion promocion = promocionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("promocion", promocion);
        return "formPromocion";
    }

    @PostMapping("/promociones/guardar")
    public String guardarPromocion(Promocion promocion) {
        promocionRepository.save(promocion);
        return "redirect:/promociones";
    }

    @GetMapping("/promociones/eliminar/{id}")
    public String eliminarPromocion(@PathVariable String id) {
        promocionRepository.deleteById(id);
        return "redirect:/promociones";
    }
}
