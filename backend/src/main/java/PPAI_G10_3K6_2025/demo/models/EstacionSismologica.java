package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Optional;


@Entity
public class EstacionSismologica {

    @Id
    private String codigoEstacion;
    private String documentoCertificacionAdq;
    private LocalDateTime fechaSolicitudCertificacion;
    private double latitud;
    private double longitud;
    private String nombre;
    private double nroCertificacionAdquisicion;
    private Sismografo sismografo;

    public EstacionSismologica() {
    }



    public EstacionSismologica(String codigoEstacion, String documentoCertificacionAdq, LocalDateTime fechaSolicitudCertificacion, double latitud, double longitud, String nombre, double nroCertificacionAdquisicion) {
        this.codigoEstacion = codigoEstacion;
        this.documentoCertificacionAdq = documentoCertificacionAdq;
        this.fechaSolicitudCertificacion = fechaSolicitudCertificacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.nroCertificacionAdquisicion = nroCertificacionAdquisicion;

    }

    public Sismografo getSismografo() {
        return sismografo;
    }

    public void setSismografo(Sismografo sismografo) {
        this.sismografo = sismografo;
    }
    public String getCodigoEstacion() {
        return codigoEstacion;
    }

    public void setCodigoEstacion(String codigoEstacion) {
        this.codigoEstacion = codigoEstacion;
    }

    public String getDocumentoCertificacionAdq() {
        return documentoCertificacionAdq;
    }

    public void setDocumentoCertificacionAdq(String documentoCertificacionAdq) {
        this.documentoCertificacionAdq = documentoCertificacionAdq;
    }

    public LocalDateTime getFechaSolicitudCertificacion() {
        return fechaSolicitudCertificacion;
    }

    public void setFechaSolicitudCertificacion(LocalDateTime fechaSolicitudCertificacion) {
        this.fechaSolicitudCertificacion = fechaSolicitudCertificacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNroCertificacionAdquisicion() {
        return nroCertificacionAdquisicion;
    }

    public void setNroCertificacionAdquisicion(double nroCertificacionAdquisicion) {
        this.nroCertificacionAdquisicion = nroCertificacionAdquisicion;
    }


    @Override
    public String toString() {
        return "EstacionSismologica{" +
                "codigoEstacion='" + codigoEstacion + '\'' +
                ", documentoCertificacionAdq='" + documentoCertificacionAdq + '\'' +
                ", fechaSolicitudCertificacion=" + fechaSolicitudCertificacion +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", nombre='" + nombre + '\'' +
                ", nroCertificacionAdquisicion=" + nroCertificacionAdquisicion +
                '}';
    }

    public void conocerSismografo() {}

    public int obtenerIdentificadorSismografo(Sismografo sismografo) {
          return sismografo.sosMiSismografo(this.getCodigoEstacion(), sismografo.getEstacionSismologica().getCodigoEstacion());
              }
}
