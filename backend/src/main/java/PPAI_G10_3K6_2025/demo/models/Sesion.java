package PPAI_G10_3K6_2025.demo.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime fechaHoraDesde;
    private LocalDateTime fechaHoraHasta;

    @OneToOne
    private Usuario usuario;


    public Sesion() {
    }

    public Sesion(LocalDateTime fechaHoraDesde, Usuario usuario) {
        this.fechaHoraDesde = fechaHoraDesde;
        this.usuario = usuario;
    }

    public Sesion(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Usuario usuario) {
        this.fechaHoraDesde = fechaHoraDesde;
        this.fechaHoraHasta = fechaHoraHasta;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario sosSesionActual(Sesion sesion) {
        if( sesion.getUsuario().equals(this.getUsuario()) && sesion.getFechaHoraHasta() == null ) {
            return sesion.getUsuario();
        }
        return null;
    }

    public  Usuario conocerUsuario(Sesion sesion) {
        if( sesion.getUsuario().equals(this.getUsuario()) && sesion.getFechaHoraHasta() == null ) {
            return sesion.getUsuario();
        }
        return null;
    }
}


