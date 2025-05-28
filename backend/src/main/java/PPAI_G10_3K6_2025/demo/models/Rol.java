package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Rol {


	@Id
	private String nombre;
	private String descripcionRol;




	public Rol() {

	}

	public Rol(String descripcionRol, String nombre) {
		this.descripcionRol = descripcionRol;
		this.nombre = nombre;
	}



	public String getDescripcionRol() {
		return descripcionRol;
	}
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol{" +
				"descripcionRol='" + descripcionRol + '\'' +
				", nombre='" + nombre + '\'' +
				'}';
	}

	public void esResponsableDeReparacion(){}


}
