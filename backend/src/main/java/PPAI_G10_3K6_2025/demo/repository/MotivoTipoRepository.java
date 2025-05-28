package PPAI_G10_3K6_2025.demo.repository;

import PPAI_G10_3K6_2025.demo.models.MotivoTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotivoTipoRepository extends JpaRepository<MotivoTipo, String> {

   // List<MotivoTipo> findBy(String tipo);
}
