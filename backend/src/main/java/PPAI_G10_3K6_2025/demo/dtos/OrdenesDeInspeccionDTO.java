package PPAI_G10_3K6_2025.demo.dtos;

import PPAI_G10_3K6_2025.demo.models.Empleado;
import PPAI_G10_3K6_2025.demo.models.EstacionSismologica;
import PPAI_G10_3K6_2025.demo.models.Estado;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class OrdenesDeInspeccionDTO {

    private long numeroOrden;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinalizacion;
    private String observacionCierre;
    private  EstacionSismologicaDTO estacionSismologicaDTO;
    private int identificadorSismografico;
    private  EmpleadoDTO empleadoDTO;
    private EstadoDTO estadoDTO;

    public OrdenesDeInspeccionDTO() {
        this.numeroOrden = 0;
        this.fechaHoraInicio = null;
        this.fechaHoraFinalizacion = null;
        this.observacionCierre = " ";
        this.estacionSismologicaDTO = new EstacionSismologicaDTO();
        this.identificadorSismografico = 0;
        this.empleadoDTO = new EmpleadoDTO();
        this.estadoDTO = new EstadoDTO();
    }

    public OrdenesDeInspeccionDTO(long numeroOrden, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinalizacion, String observacionCierre, EstacionSismologicaDTO estacionSismologicaDTO, int identificadorSismografico, EmpleadoDTO empleadoDTO, EstadoDTO estadoDTO) {
        this.numeroOrden = numeroOrden;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.observacionCierre = observacionCierre;
        this.estacionSismologicaDTO = estacionSismologicaDTO;
        this.identificadorSismografico = identificadorSismografico;
        this.empleadoDTO = empleadoDTO;
        this.estadoDTO = estadoDTO;
    }

    public long getNumeroOrden() {
        return numeroOrden;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public String getObservacionCierre() {
        return observacionCierre;
    }

    public  EstacionSismologicaDTO getEstacionSismologica() {
        return  estacionSismologicaDTO;
    }

    public int getIdentificadorSismografico() {
        return identificadorSismografico;
    }

    public void setNumeroOrden(long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public void setFechaHoraFinalizacion(LocalDateTime fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public void setObservacionCierre(String observacionCierre) {
        this.observacionCierre = observacionCierre;
    }

    public void setEstacionSismologica(EstacionSismologicaDTO estacionSismologicaDTO) {
        this.estacionSismologicaDTO = estacionSismologicaDTO;
    }

    public void setIdentificadorSismografico(int identificadorSismografico) {
        this.identificadorSismografico = identificadorSismografico;
    }

    public EstacionSismologicaDTO getEstacionSismologicaDTO() {
        return estacionSismologicaDTO;
    }

    public void setEstacionSismologicaDTO(EstacionSismologicaDTO estacionSismologicaDTO) {
        this.estacionSismologicaDTO = estacionSismologicaDTO;
    }

    public EmpleadoDTO getEmpleadoDTO() {
        return empleadoDTO;
    }

    public void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {
        this.empleadoDTO = empleadoDTO;
    }

    public EstadoDTO getEstadoDTO() {
        return estadoDTO;
    }

    public void setEstadoDTO(EstadoDTO estadoDTO) {
        this.estadoDTO = estadoDTO;
    }

    @Override
    public String toString() {
        return "OrdenesDeInspeccionDTO{" +
                "numeroOrden=" + numeroOrden +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", fechaHoraFinalizacion=" + fechaHoraFinalizacion +
                ", observacionCierre='" + observacionCierre + '\'' +
                ", estacionSismologicaDTO=" + estacionSismologicaDTO +
                ", identificadorSismografico=" + identificadorSismografico +
                '}';
    }
}
