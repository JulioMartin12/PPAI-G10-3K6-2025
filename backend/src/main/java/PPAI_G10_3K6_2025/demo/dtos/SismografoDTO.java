package PPAI_G10_3K6_2025.demo.dtos;

import PPAI_G10_3K6_2025.demo.models.CambioEstado;
import PPAI_G10_3K6_2025.demo.models.EstacionSismologica;
import PPAI_G10_3K6_2025.demo.models.Estado;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.List;

public class SismografoDTO {
    private long nroSerie;
    private LocalDateTime fechaAdquisicion;
    private int identificadorSismografo;

   //private List<CambioEstado> cambioEstado;

    private EstacionSismologica estacionSismologica;

   private Estado estado;

    public SismografoDTO() {
        this.estacionSismologica = new EstacionSismologica();
        this.estado = new Estado();
    }

    public long getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(long nroSerie) {
        this.nroSerie = nroSerie;
    }

    public LocalDateTime getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDateTime fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getIdentificadorSismografo() {
        return identificadorSismografo;
    }

    public void setIdentificadorSismografo(int identificadorSismografo) {
        this.identificadorSismografo = identificadorSismografo;
    }

    public EstacionSismologica getEstacionSismologica() {
        return estacionSismologica;
    }

    public void setEstacionSismologica(EstacionSismologica estacionSismologica) {
        this.estacionSismologica = estacionSismologica;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
