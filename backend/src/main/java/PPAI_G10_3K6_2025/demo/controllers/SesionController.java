package PPAI_G10_3K6_2025.demo.controllers;

import PPAI_G10_3K6_2025.demo.dtos.SesionDTO;
import PPAI_G10_3K6_2025.demo.models.Sesion;
import PPAI_G10_3K6_2025.demo.models.Usuario;
import PPAI_G10_3K6_2025.demo.repository.SesionRepository;
import PPAI_G10_3K6_2025.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/sesiones")
public class SesionController {

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public List<Sesion> getAllSesiones() {
        return sesionRepository.findAll();
    }


    @GetMapping("/{id}")
    public Sesion getSesionById(@PathVariable Long id) {
        return sesionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sesión no encontrada con ID: " + id));
    }


    @PostMapping
    public Sesion crearSesion(@RequestBody SesionDTO sesionDTO) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(sesionDTO.getNombreUsuario());
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado: " + sesionDTO.getNombreUsuario());
        }

        Sesion nuevaSesion = new Sesion(
                sesionDTO.getFechaHoraDesde(),
                sesionDTO.getFechaHoraHasta(),
                usuario
        );

        return sesionRepository.save(nuevaSesion);
    }


    @DeleteMapping("/{id}")
    public void eliminarSesion(@PathVariable Long id) {
        sesionRepository.deleteById(id);
    }
}
