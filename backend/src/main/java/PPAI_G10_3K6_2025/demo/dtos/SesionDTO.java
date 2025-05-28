package PPAI_G10_3K6_2025.demo.dtos;

import java.time.LocalDateTime;

public class SesionDTO {
    private LocalDateTime fechaHoraDesde;
    private LocalDateTime fechaHoraHasta;
    private String nombreUsuario;


    public SesionDTO() {
    }

    public SesionDTO(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta) {
        this.fechaHoraDesde = fechaHoraDesde;
        this.fechaHoraHasta = fechaHoraHasta;
    }


    public LocalDateTime getFechaHoraDesde() {
        return fechaHoraDesde;
    }

    public void setFechaHoraDesde(LocalDateTime fechaHoraDesde) {
        this.fechaHoraDesde = fechaHoraDesde;
    }

    public LocalDateTime getFechaHoraHasta() {
        return fechaHoraHasta;
    }

    public void setFechaHoraHasta(LocalDateTime fechaHoraHasta) {
        this.fechaHoraHasta = fechaHoraHasta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
