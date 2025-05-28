package PPAI_G10_3K6_2025.demo.service;



import PPAI_G10_3K6_2025.demo.models.*;

import java.time.LocalDateTime;
import java.util.*;

public class CargasDatos {
    List<Rol> roles = new ArrayList<>();
    List<Empleado> empleados = new ArrayList<>();
    List<MotivoTipo> motivos = new ArrayList<>();
    List<Estado> estados = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    List<Sesion> sesiones = new ArrayList<>();
    List<EstacionSismologica> estaciones = new ArrayList<>();
    List<Sismografo> sismografos = new ArrayList<>();
    List<CambioEstado> cambioEstados = new ArrayList<>();
    List<OrdenDeInspeccion> ordenesDeInspeccion = new ArrayList<>();


    public CargasDatos() {

        iniciarDatos();
    }


    private void iniciarDatos() {
        crearTodo();

    }

    private void crearTodo() {
    }
}

/*












        EstacionSismologica estacion1 = new EstacionSismologica("est001", "Documento certificacion nro 2550", LocalDateTime.of(2025, 5, 30, 11, 0), -32.89084, -68.82717, "Estacion Mendoza", 2550);
        EstacionSismologica estacion2 = new EstacionSismologica("est002", "Documento certificacion nro 2551", LocalDateTime.of(2025, 6, 30, 11, 0), -31.4135, -64.18105, "Estacion Cordoba", 2551);
        EstacionSismologica estacion3 = new EstacionSismologica("est003", "Documento certificacion nro 2552", LocalDateTime.of(2025, 7, 30, 11, 0), -33.29501, -66.33563, "Estacion San Luis", 2552);
        EstacionSismologica estacion4 = new EstacionSismologica("est004", "Documento certificacion nro 2553", LocalDateTime.of(2025, 8, 30, 11, 0), -29.41105, -66.85067, "Estacion La Rioja", 2553);
        EstacionSismologica estacion5 = new EstacionSismologica("est005", "Documento certificacion nro 2554", LocalDateTime.of(2025, 9, 30, 11, 0), -28.46957, -65.78524, "Estacion Catamarca", 2554);

        estaciones.add(estacion1);
        estaciones.add(estacion2);
        estaciones.add(estacion3);
        estaciones.add(estacion4);
        estaciones.add(estacion5);

        OrdenDeInspeccion ordInspeccion1 = new OrdenDeInspeccion(001, LocalDateTime.of(2025, 5, 20, 9, 0), LocalDateTime.of(2025, 5, 20, 11, 0), "", silvia, estacion1, completamenteRealizada);
        OrdenDeInspeccion ordInspeccion2 = new OrdenDeInspeccion(002, LocalDateTime.of(2025, 5, 20, 10, 0), LocalDateTime.of(2025, 4, 20, 11, 0), "", silvia, estacion2, completamenteRealizada);
        OrdenDeInspeccion ordInspeccion3 = new OrdenDeInspeccion(003, LocalDateTime.of(2025, 5, 23, 20, 0), LocalDateTime.of(2025, 5, 20, 22, 0), "", carlos, estacion2, enAnalisis);
        OrdenDeInspeccion ordInspeccion4 = new OrdenDeInspeccion(004, LocalDateTime.of(2025, 5, 22, 7, 0), LocalDateTime.of(2025, 5, 20, 11, 0), "", carlos, estacion2, enAnalisis);
        OrdenDeInspeccion ordInspeccion5 = new OrdenDeInspeccion(005, LocalDateTime.of(2025, 5, 23, 15, 0), LocalDateTime.of(2025, 5, 20, 11, 0), "", silvia, estacion2, enAnalisis);

        ordenesDeInspeccion.add(ordInspeccion1);
        ordenesDeInspeccion.add(ordInspeccion2);
        ordenesDeInspeccion.add(ordInspeccion3);
        ordenesDeInspeccion.add(ordInspeccion4);
        ordenesDeInspeccion.add(ordInspeccion5);

        Sismografo sismografo1 = new Sismografo(LocalDateTime.of(2025, 4, 19, 20, 0), 1, 1002003, new CambioEstado(LocalDateTime.of(2025, 4, 19, 20, 0), null, silvia, fueraDeServicio, new MotivoFueraServicio(falloAlimentacion, "Se rompio la fuente de energia")), estacion1, fueraDeServicio);
        Sismografo sismografo2 = new Sismografo(LocalDateTime.of(2025, 4, 19, 19, 0), 2, 1002004, new CambioEstado(LocalDateTime.of(2025, 4, 19, 20, 0), null, silvia, fueraDeServicio, new MotivoFueraServicio(falloAlimentacion, "Se rompio el transformador")), estacion1, fueraDeServicio);
        Sismografo sismografo3 = new Sismografo(LocalDateTime.of(2025, 4, 19, 18, 0), 3, 1002005, new CambioEstado(LocalDateTime.of(2025, 4, 19, 20, 0), null, silvia, fueraDeServicio, new MotivoFueraServicio(falloAlimentacion, "Se corto la luz")), estacion1, fueraDeServicio);
        Sismografo sismografo4 = new Sismografo(LocalDateTime.of(2025, 4, 19, 17, 0), 4, 1002006, new CambioEstado(LocalDateTime.of(2025, 4, 19, 20, 0), null, silvia, fueraDeServicio, new MotivoFueraServicio(falloAlimentacion, "Se corto el cable de alimentacion")), estacion1, fueraDeServicio);
        Sismografo sismografo5 = new Sismografo(LocalDateTime.of(2025, 4, 19, 16, 0), 5, 1002007, new CambioEstado(LocalDateTime.of(2025, 4, 19, 20, 0), null, silvia, fueraDeServicio, new MotivoFueraServicio(falloAlimentacion, "Se prendio fuego toda la estacion")), estacion1, fueraDeServicio);

        sismografos.add(sismografo1);
        sismografos.add(sismografo2);
        sismografos.add(sismografo3);
        sismografos.add(sismografo4);
        sismografos.add(sismografo5);

        estacion1.setSismografo(sismografo1);
        estacion2.setSismografo(sismografo2);
        estacion3.setSismografo(sismografo3);
        estacion4.setSismografo(sismografo4);
        estacion5.setSismografo(sismografo5);
        */
/*
/**
         *     private LocalDateTime fechaAdquisicion;
         *     private int identificadorSismografo;
         *     private double nroSerie;
         *     private CambioEstado cambioEstado;
         *     private EstacionSismologica estacionSismologica;
         *     private Estado estado;
         *
         *     private LocalDateTime fechaHoraInicio;
         *     private LocalDateTime fechaHoraFin;
         *     private Empleado responsable;
         *     private Estado estado;
         *     private MotivoFueraServicio motivoFueraServicio;
         *//*


    }

    public List<OrdenDeInspeccion> getOrdenesDeInspeccion() {
        return ordenesDeInspeccion;
    }

    public void setOrdenesDeInspeccion(List<OrdenDeInspeccion> ordenesDeInspeccion) {
        this.ordenesDeInspeccion = ordenesDeInspeccion;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<MotivoTipo> getMotivos() {
        return motivos;
    }

    public void setMotivos(List<MotivoTipo> motivos) {
        this.motivos = motivos;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Sesion> sesiones) {
        this.sesiones = sesiones;
    }


    public Sesion enElsistema() {
        for (Sesion sesion : sesiones) {
            if (sesion.getFechaHoraHasta() == null)
                return sesion;

        }
        return null;
    }

    public List<MotivoTipo> crearListaDeSeleccionados(List<MotivoTipo> motivosTipoParaSeleccion) {
        if (motivos == null || motivos.isEmpty()) {
            return motivosTipoParaSeleccion;
        }

        Random random = new Random();
        int cantidadAleatoria = random.nextInt(motivos.size()) + 1;
        Set<MotivoTipo> seleccionados = new HashSet<>();
        while (seleccionados.size() < cantidadAleatoria) {
            MotivoTipo motivoSeleccionado = motivos.get(random.nextInt(motivos.size()));
            seleccionados.add(motivoSeleccionado);
        }
            motivosTipoParaSeleccion.addAll(seleccionados);
            return motivosTipoParaSeleccion;
        }
    }


*/
