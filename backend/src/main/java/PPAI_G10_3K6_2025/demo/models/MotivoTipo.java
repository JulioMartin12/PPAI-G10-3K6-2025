package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.*;

@Entity
public class MotivoTipo {

     @Id
    private String nombre;
    private String descripcion;


    public MotivoTipo() {
    }

    public MotivoTipo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean sosMotivo(String motivo){
        return this.getNombre().equals(motivo);
    }

    @Override
    public String toString() {
        return "MotivoTipo{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}