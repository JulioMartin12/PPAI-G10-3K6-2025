package PPAI_G10_3K6_2025.demo.repository;

import PPAI_G10_3K6_2025.demo.models.EstacionSismologica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstacionSismologicaRepository  extends JpaRepository<EstacionSismologica, String> {

    List<EstacionSismologica> findByNombre(String nombre);
}
