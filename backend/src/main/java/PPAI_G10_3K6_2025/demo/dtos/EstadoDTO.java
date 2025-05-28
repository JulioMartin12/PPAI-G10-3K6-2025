package PPAI_G10_3K6_2025.demo.dtos;

public class EstadoDTO {
    private String nombre;
    private String ambito;
    private String descripcion;

    public EstadoDTO() {
    }


    public EstadoDTO(String nombre, String ambito, String descripcion) {
        this.nombre = nombre;
        this.ambito = ambito;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
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


}
