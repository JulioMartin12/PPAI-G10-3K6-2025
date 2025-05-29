package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
	private String nombreUsuario;
	private String contrasena;
	@OneToOne
	private Empleado empleado;


	public Usuario() {
	}

	public Usuario(String contrasena, String nombreUsuario, Empleado empleado) {
		this.contrasena = contrasena;
		this.nombreUsuario = nombreUsuario;
		this.empleado = empleado;
	}

	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void conocerEmpleado(){}

	public long getRILogueado(Empleado empleado){
		return empleado.getId();
		}

	@Override
	public String toString() {
		return "Usuario{" + "contrasena='" + contrasena + '\'' + ", nombreUsuario='" + nombreUsuario + '\'' + ", empleado=" + empleado + '}';
	}
}
