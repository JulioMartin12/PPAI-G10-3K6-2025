package PPAI_G10_3K6_2025.demo.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    @OneToOne()
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
}


