package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CambioEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    @ManyToOne
    private Empleado responsable;

    @ManyToOne
    private Estado estado;

    @ManyToOne
    private MotivoFueraServicio  motivoFueraServicio;

    @ManyToOne
    private  Sismografo sismografo;

    public CambioEstado() {
    }

    public CambioEstado(MotivoFueraServicio motivoFueraServicio, Empleado responsable, LocalDateTime fechaHoraFin, LocalDateTime fechaHoraInicio) {
        this.motivoFueraServicio = motivoFueraServicio;
        this.responsable = responsable;
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public CambioEstado(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Empleado responsable, Estado estado,MotivoFueraServicio motivoFueraServicio) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.responsable = responsable;
        this.estado = estado;
        this.motivoFueraServicio = motivoFueraServicio;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MotivoFueraServicio getMotivoFueraServicio() {
        return motivoFueraServicio;
    }



    @Override
    public String toString() {
        return "CambioEstado{" +
                "fechaHoraInicio=" + fechaHoraInicio +
                ", fechaHoraFin=" + fechaHoraFin +
                ", responsable=" + responsable +
                ", estado=" + estado +
                ", motivoFueraServicio=" + motivoFueraServicio +
                '}';
    }


    public void setMotivoFueraServicio(MotivoFueraServicio motivoFueraServicio) {
        this.motivoFueraServicio = motivoFueraServicio;
    }

    public long getId() {
        return id;
    }

    public void conoceEstado() {}
    public void conoceMotivoFueraServicio() {}

    public boolean esEstadoActual(){
        return this.getFechaHoraFin() != null;
    }
}
