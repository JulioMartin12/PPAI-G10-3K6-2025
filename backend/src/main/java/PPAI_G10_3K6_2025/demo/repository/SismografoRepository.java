package PPAI_G10_3K6_2025.demo.repository;

import PPAI_G10_3K6_2025.demo.models.Sismografo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SismografoRepository extends JpaRepository<Sismografo, Long> {

   List<Sismografo> findAll();
}
