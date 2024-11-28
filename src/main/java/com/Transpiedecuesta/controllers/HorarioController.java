package com.Transpiedecuesta.controllers;

import com.Transpiedecuesta.entities.HorarioDTO;
import com.Transpiedecuesta.entities.Horario;
import com.Transpiedecuesta.entities.Ruta;
import com.Transpiedecuesta.repositories.HorarioRepository;
import com.Transpiedecuesta.repositories.RutaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HorarioController {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping("/horarios")
    public String listarHorarios(Model model) {
        // Obtenemos todos los horarios desde la base de datos
        List<Horario> horarios = horarioRepository.findAll();

        // Convertimos los horarios a DTO para la vista
        List<HorarioDTO> horariosDTO = horarios.stream().map(h -> {
            Ruta ruta = h.getRuta(); // Obtenemos el objeto Ruta
            String nombreRuta = ruta != null ? ruta.getNombre() : "Desconocida"; // Nombre de la ruta o "Desconocida"
            return new HorarioDTO(h.getId(), nombreRuta, h.getHoraSalida(), h.getHoraLlegada());
        }).collect(Collectors.toList());

        model.addAttribute("horarios", horariosDTO); // Pasamos los DTOs a la vista
        return "horarios"; // Nombre de la vista Thymeleaf
    }

    @GetMapping("/horarios/crear")
    public String crearHorario(Model model) {
        model.addAttribute("horario", new Horario());
        model.addAttribute("rutas", rutaRepository.findAll()); // Listamos las rutas disponibles
        return "formHorario"; // Vista del formulario
    }

    @GetMapping("/horarios/editar/{id}")
    public String editarHorario(@PathVariable String id, Model model) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("horario", horario);
        model.addAttribute("rutas", rutaRepository.findAll()); // Listamos las rutas disponibles
        return "formHorario"; // Vista del formulario
    }

    @PostMapping("/horarios/guardar")
    public String guardarHorario(Horario horario) {
        horarioRepository.save(horario);
        return "redirect:/horarios"; // Redirige a la lista de horarios
    }

    @GetMapping("/horarios/eliminar/{id}")
    public String eliminarHorario(@PathVariable String id) {
        horarioRepository.deleteById(id);
        return "redirect:/horarios"; // Redirige a la lista de horarios
    }
}

