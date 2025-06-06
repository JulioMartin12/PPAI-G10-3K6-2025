package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class OrdenDeInspeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroOrden;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinalizacion;
    private String observacionCierre;
    private LocalDateTime fechaHoraCierre;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private EstacionSismologica estacionSismologica;

    @ManyToOne
    private Estado estado;


    public OrdenDeInspeccion() {

    }

    public OrdenDeInspeccion(long numeroOrden, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinalizacion, String observacionCierre) {
        this.numeroOrden = numeroOrden;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.observacionCierre = observacionCierre;
    }

    public OrdenDeInspeccion(long numeroOrden, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinalizacion, String observacionCierre, Empleado empleado, EstacionSismologica estacionSismologica, Estado estado, LocalDateTime fechaHoraCierre) {
        this.numeroOrden = numeroOrden;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.observacionCierre = observacionCierre;
        this.empleado = empleado;
        this.estacionSismologica = estacionSismologica;
        this.estado = estado;
        this.fechaHoraCierre = fechaHoraCierre;
    }

    public LocalDateTime getFechaHoraCierre() {
        return fechaHoraCierre;
    }

    public void setFechaHoraCierre(LocalDateTime fechaHoraCierre) {
        this.fechaHoraCierre = fechaHoraCierre;
    }

    public long getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(LocalDateTime fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public String getObservacionCierre() {
        return observacionCierre;
    }

    public void setObservacionCierre(String observacionCierre) {
        this.observacionCierre = observacionCierre;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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

    @Override
    public String toString() {
        return "OrdenDeInspeccion{" +
                "numeroOrden=" + numeroOrden +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", fechaHoraFinalizacion=" + fechaHoraFinalizacion +
                ", observacionCierre='" + observacionCierre + '\'' +
                ", empleado=" + empleado +
                ", estacionSismologica=" + estacionSismologica +
                ", estado=" + estado +
                '}';
    }


    public Estado validarEstado(Estado realizado){
    	if (this.estado.getNombre().compareTo(realizado.getNombre())==0)
    		return realizado;
    	else
    		return null;
    }

    public EstacionSismologica obtenerDatosEstacion(){
        return getEstacionSismologica();
    }

    public  void actualizarEstado(Estado estado){
        this.setEstado(estado);
    }

    public void conocerEmpleado(){}

    public void conocerEstacionSismologica(){}

    public void conocerEstado(){}


    public boolean sosEmpleadoLogueado(Empleado empleado){

        return this.empleado.equals(empleado);
    }


    public boolean sosOrdenSeleccionada(OrdenDeInspeccion orden){
        return this.numeroOrden == orden.getNumeroOrden();
    }
}
