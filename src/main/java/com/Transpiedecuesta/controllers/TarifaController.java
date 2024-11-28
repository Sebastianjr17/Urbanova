package com.Transpiedecuesta.controllers;

import com.Transpiedecuesta.entities.Tarifa;
import com.Transpiedecuesta.entities.TarifaDTO;
import com.Transpiedecuesta.repositories.RutaRepository;
import com.Transpiedecuesta.repositories.TarifaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class TarifaController {

    @Autowired
    private TarifaRepository tarifaRepository;

    @Autowired
    private RutaRepository rutaRepository;

    // Listar tarifas con nombres de rutas
    @GetMapping("/tarifas")
    public String listarTarifas(Model model) {
        List<Tarifa> tarifas = tarifaRepository.findAll();

        // Mapa de IDs de rutas a nombres de rutas
        Map<String, String> rutaNombres = rutaRepository.findAll().stream()
                .collect(Collectors.toMap(ruta -> ruta.getId(), ruta -> ruta.getNombre()));

        // Convertir Tarifa a TarifaDTO
        List<TarifaDTO> tarifasDTO = tarifas.stream()
                .map(tarifa -> new TarifaDTO(
                        tarifa.getId(),
                        tarifa.getRutaId(),
                        rutaNombres.getOrDefault(tarifa.getRutaId(), "Ruta desconocida"),
                        tarifa.getPrecio()))
                .toList();

        model.addAttribute("tarifas", tarifasDTO);
        return "tarifas";
    }

    // Mostrar el formulario para crear una nueva tarifa
    @GetMapping("/formTarifas")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tarifa", new Tarifa());
        model.addAttribute("rutas", rutaRepository.findAll());
        return "formTarifas";
    }

    // Mostrar el formulario para editar una tarifa
    @GetMapping("/tarifas/editar/{id}")
    public String editarTarifa(@PathVariable String id, Model model) {
        Tarifa tarifa = tarifaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID no válido: " + id));
        model.addAttribute("tarifa", tarifa);
        model.addAttribute("rutas", rutaRepository.findAll());
        return "formTarifas";
    }

    // Guardar o actualizar una tarifa
    @PostMapping("/formTarifas/guardar")
    public String guardarTarifa(@Valid Tarifa tarifa, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rutas", rutaRepository.findAll());
            return "formTarifas";
        }
        tarifaRepository.save(tarifa);
        return "redirect:/tarifas";
    }

    // Eliminar una tarifa
    @GetMapping("/tarifas/eliminar/{id}")
    public String eliminarTarifa(@PathVariable String id) {
        tarifaRepository.deleteById(id);
        return "redirect:/tarifas";
    }
}

