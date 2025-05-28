package PPAI_G10_3K6_2025.demo.repository;

import PPAI_G10_3K6_2025.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByNombreUsuario(String nombreUsuario);
}
