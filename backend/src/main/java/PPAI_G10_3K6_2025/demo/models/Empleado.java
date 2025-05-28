package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.*;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;

    @ManyToOne
    private Rol rol;


    public Empleado() {
    }

    public Empleado(String nombre,
                    String apellido,
                    String mail,
                    String telefono,
                    Rol rol) {
        this.nombre   = nombre;
        this.apellido = apellido;
        this.mail     = mail;
        this.telefono = telefono;
        this.rol      = rol;
    }

    public Empleado(String nombre, String apellido, String mail, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol=" + rol +
                '}';
    }

    public  void conoceRol(){}

    public long getId() {
        return id;
    }

}
