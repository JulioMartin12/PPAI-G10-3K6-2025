package PPAI_G10_3K6_2025.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MotivoFueraServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comentario;

    @ManyToOne
    private MotivoTipo motivoTipo;

    @OneToMany(mappedBy = "motivoFueraServicio")
    private List<CambioEstado> cambioEstados = new ArrayList<>();




    public MotivoFueraServicio() {
    }

    public MotivoFueraServicio(MotivoTipo motivoTipo, String comentario, List<CambioEstado> cambioEstados) {
        this.motivoTipo = motivoTipo;
        this.comentario = comentario;
        this.cambioEstados = cambioEstados;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public MotivoTipo getMotivoTipo() {
        return motivoTipo;
    }

    public void setMotivoTipo(MotivoTipo motivoTipo) {
        this.motivoTipo = motivoTipo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CambioEstado> getCambioEstados() {
        return cambioEstados;
    }

    public void setCambioEstados(List<CambioEstado> cambioEstados) {
        this.cambioEstados = cambioEstados;
    }

    @Override
    public String toString() {
        return "MotivoFueraServicio{" +
                "comentario='" + comentario + '\'' +
                ", motivoTipo=" + motivoTipo +
                '}';
    }

    public long getId() {
        return id;
    }

    public void conoceMotivoTipo(){}

}