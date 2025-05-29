package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sismografo {

    @Id
    private long nroSerie;
    private LocalDateTime fechaAdquisicion;
    private int identificadorSismografo;

    @OneToMany(mappedBy = "sismografo", cascade = CascadeType.ALL)
    private List<CambioEstado> cambioEstado;

    @OneToOne
    private EstacionSismologica estacionSismologica;

    @ManyToOne
    private Estado estado;


    public Sismografo() {
    }

    public Sismografo(LocalDateTime fechaAdquisicion, int identificadorSismografo, long nroSerie,  List<CambioEstado> cambioEstado, EstacionSismologica estacionSismologica, Estado estado) {
        this.fechaAdquisicion = fechaAdquisicion;
        this.identificadorSismografo = identificadorSismografo;
        this.nroSerie = nroSerie;
        this.cambioEstado = cambioEstado;
        this.estacionSismologica = estacionSismologica;
        this.estado = estado;
    }

    public Sismografo(LocalDateTime fechaAdquisicion, int identificadorSismografo, long nroSerie) {
        this.fechaAdquisicion = fechaAdquisicion;
        this.identificadorSismografo = identificadorSismografo;
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

    public double getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(long nroSerie) {
        this.nroSerie = nroSerie;
    }

    public EstacionSismologica getEstacionSismologica() {
        return estacionSismologica;
    }

    public void setEstacionSismologica(EstacionSismologica estacionSismologica) {
        this.estacionSismologica = estacionSismologica;
    }

    public Estado getestado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void conocerEstacionSismologica() {}

    public void conocerCambioEstado() {}

    public void conocerestado() {}

    public  void actualizarEstado(Estado estado) {
        this.setEstado(estado) ;
    }

    public  int sosMiSismografo(String codigoStacion, String codigoEstacionMiSismografo){
        if(this.getEstacionSismologica().getCodigoEstacion().equals(codigoStacion))
            return this.getIdentificadorSismografo();
        return 0;
    }

    public List<CambioEstado> getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(List<CambioEstado> cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    @Override
    public String toString() {
        return "Sismografo{" +
                "fechaAdquisicion=" + fechaAdquisicion +
                ", identificadorSismografo=" + identificadorSismografo +
                ", nroSerie=" + nroSerie +
                ", cambioEstado=" + cambioEstado +
                ", estacionSismologica=" + estacionSismologica +
                ", estado=" + estado +
                '}';
    }
}


