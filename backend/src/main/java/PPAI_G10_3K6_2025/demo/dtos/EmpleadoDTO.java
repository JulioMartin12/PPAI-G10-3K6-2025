package PPAI_G10_3K6_2025.demo.dtos;

import PPAI_G10_3K6_2025.demo.models.Rol;
import jakarta.persistence.ManyToOne;

public class EmpleadoDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private Rol rol;

    public EmpleadoDTO(long id, String nombre, String apellido, String mail, String telefono, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.rol = rol;
    }

    public EmpleadoDTO() {
    }


    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
