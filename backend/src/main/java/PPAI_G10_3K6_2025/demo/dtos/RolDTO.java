package PPAI_G10_3K6_2025.demo.dtos;

public class RolDTO {
    private String nombre;
    private String descripcionRol;

    public RolDTO() {
    }

    public RolDTO(String nombre, String descripcionRol) {
        this.nombre = nombre;
        this.descripcionRol = descripcionRol;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }
}
