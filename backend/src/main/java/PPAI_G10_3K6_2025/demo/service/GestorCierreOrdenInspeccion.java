package PPAI_G10_3K6_2025.demo.service;

import PPAI_G10_3K6_2025.demo.models.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GestorCierreOrdenInspeccion {
    private  CargasDatos cargarDatos;
    private LocalDateTime fechaActual;
    private OrdenDeInspeccion ordenSeleccionada;
    private Empleado empleadoLogueado;
    private String notificacionMail;
    private String comentarioMotivos;
    private  Sismografo sismografoElegido;
    private String observacion;
    private  Sesion sesionLogueado;
    private  Usuario usuarioLogueado;
    private List<OrdenDeInspeccion> ordenes = new ArrayList<>();
    private Estado estadoRealizado;
    private List<MotivoTipo> motivosSeleccionados = new ArrayList<>();







	public GestorCierreOrdenInspeccion() {
       }
	
    public List<OrdenDeInspeccion> getOrdenes() {
		return ordenes;
	}


	public void setOrdenes(List<OrdenDeInspeccion> ordenes) {
		this.ordenes = ordenes;
	}


    public LocalDateTime getFechaActual() {
        return fechaActual;
    }
    
	public Estado getEstadoRealizado() {
		return estadoRealizado;
	}

	public void setEstadoRealizado(Estado estadoRealizado) {
		this.estadoRealizado = estadoRealizado;
	}



    public OrdenDeInspeccion getOrdenSeleccionada() {
        return ordenSeleccionada;
    }

    public void setOrdenSeleccionada(OrdenDeInspeccion ordenSeleccionada) {
        this.ordenSeleccionada = ordenSeleccionada;
    }

    public boolean opcionCerrarOrdenInspeccion() {
        return this.buscarEmpleadoLogueado();
    }


    public boolean buscarEmpleadoLogueado(){
      /*  for (Sesion sesion : this.cargarDatos.getSesiones()){
            if(sesion.sosSesionActual(this.cargarDatos.enElsistema())!=null) {
                this.sesionLogueado = sesion;
                this.usuarioLogueado = sesion.getUsuario();
                this.empleadoLogueado = this.usuarioLogueado.getEmpleado();
             return true;
            }
        }*/
        return false;
    }

    public void buscarOrdenes(){
           for (Estado estado: this.cargarDatos.getEstados() ) {
            if (estado.sosCompletamenteRealizada()) {
                this.estadoRealizado = estado;
            }
        }
        for (OrdenDeInspeccion ordenDeInspeccion : this.cargarDatos.getOrdenesDeInspeccion() ) {

            if (ordenDeInspeccion.getEmpleado().equals(this.empleadoLogueado )&& estadoRealizado != null) {
                if ( ordenDeInspeccion.getEstado().equals(estadoRealizado)) {
                 /*   OrdenDeInspeccion orden = new OrdenDeInspeccion();
                    orden.setNumeroOrden(ordenDeInspeccion.getNumeroOrden());*/
                    ordenes.add(ordenDeInspeccion);
    			}

                }
    		}

    } 

    public void tomarOrdenSelec(int indice){
        indice = indice - 1;
        for (int i = 0; i < getOrdenes().size(); i++) {
            if(indice == i){
                this.setOrdenSeleccionada(ordenes.get(i));
                System.out.println("Orden seleccionada " + ordenes.get(i));
            }

        }
    }

    public void tomarObservacion(String observacion){
        this.getOrdenSeleccionada().setObservacionCierre(observacion);
        System.out.println(getOrdenSeleccionada());
        System.out.println(getOrdenes());
        this.buscarOrdenSelect();

    }

    public void buscarOrdenSelect(){

        for (OrdenDeInspeccion ordenDeInspeccion : this.getOrdenes()) {
            if(ordenDeInspeccion.equals(this.getOrdenSeleccionada())){
                ordenDeInspeccion.setObservacionCierre(this.getOrdenSeleccionada().getObservacionCierre());
            }
        }
    }

//    public void habilitarBajaSismografo(){
//        pantallaCierreOrdenInspeccion.mostrarMotivosTipo();
//    }

    public void tomarConfirmacion(){}

    public void tomarSeleccionMotivoTipo(){}

    public void tomarComentario(){}

    public void validaDatos(){}

    public void actualizarOrden(){}

    public void actualizarEstadoSismogrado(){}

    public void buscarNotificables(){}

    public void generarNotificacion(){}

    public void notificarResponsable(){}

    public void ordenarXFechaDeFinalizacion(){
        if(!getOrdenes().isEmpty()){
            getOrdenes().sort(Comparator.comparing(OrdenDeInspeccion::getFechaHoraFinalizacion));
            int indice=1;
            System.out.println("---Seleccione una Opcion----");
            for (OrdenDeInspeccion ordenDeInspeccion : getOrdenes()) {
                System.out.println("Opcion "+indice+") Número de orden: "+ordenDeInspeccion.getNumeroOrden()+" Fecha Finalización:"+ordenDeInspeccion.getFechaHoraFinalizacion() + " Nombre Estacion: " + ordenDeInspeccion.getEstacionSismologica().getNombre() + " Identificador Sismografo: " + ordenDeInspeccion.getEstacionSismologica().getSismografo().getIdentificadorSismografo());
             indice ++;
            }
            System.out.println("Opcion 0) Salir.");
        }
    }

    public  void finCU(){}




}
