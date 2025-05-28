package PPAI_G10_3K6_2025.demo.repository;

import PPAI_G10_3K6_2025.demo.models.OrdenDeInspeccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenDeInspeccionRepository extends JpaRepository<OrdenDeInspeccion, Long> {

    @Override
    List<OrdenDeInspeccion> findAll();

    List<OrdenDeInspeccion> findOrdenDeInspeccionsByEmpleado_Id(Long id);

    OrdenDeInspeccion findOrdenDeInspeccionsByNumeroOrden(Long id);


}
