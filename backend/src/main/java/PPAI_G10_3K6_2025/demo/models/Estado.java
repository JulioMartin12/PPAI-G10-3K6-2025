package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Estado {

    @Id
    private String nombre;
    private String ambito;
    private String descripcion;


    public Estado() {
    }

    public Estado(String nombre, String descripcion) {
        this.nombre =nombre;
        this.descripcion = descripcion;
    }

    public Estado(String nombre, String descripcion , String ambito) {
        this.nombre = nombre;
        this.ambito = ambito;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nombre='" + nombre + '\'' +
                ", ambito='" + ambito + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public boolean sosCompletamenteRealizada() {
        return (this.getNombre().equals("Completamente Realizada"));
    }

    public boolean sosFueraDeServicio() {
        return (this.getNombre().equals("Fuera de Servicio"));
    }

    public  boolean esAmbitoSismografo(Sismografo sismografo){
        return this.getAmbito().equals(sismografo);
    }

    public boolean esCerrado(){
        return this.getNombre().equals("Cerrado");
    }

}

