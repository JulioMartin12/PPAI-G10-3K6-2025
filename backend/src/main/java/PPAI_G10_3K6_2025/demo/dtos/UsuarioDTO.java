package PPAI_G10_3K6_2025.demo.dtos;

public class UsuarioDTO {
    private String nombreUsuario;
    private String empleadoNombre;  // Solo el nombre o algún dato relevante del empleado

    public UsuarioDTO() {
    }


    public UsuarioDTO(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }
}