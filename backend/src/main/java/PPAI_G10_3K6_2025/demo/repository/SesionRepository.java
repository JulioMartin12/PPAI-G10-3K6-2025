package PPAI_G10_3K6_2025.demo.repository;

import PPAI_G10_3K6_2025.demo.models.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion, Long> {

    Sesion findById(long id);
}
