import { Component, OnInit, OnDestroy } from '@angular/core';
import { PantallaCierreOrdenInspeccionService } from '../services/pantalla-cierre-orden-inspeccion.service';
import { OrdenDeInspeccion } from '../models/orden-de-inspeccion.model';

import { BehaviorSubject, Subscription } from 'rxjs';



import { MotivoTipo } from '../models/motivo-tipo.model';

@Component({
  selector: 'app-pantalla-cierre-orden-inspeccion',
  templateUrl: './pantalla-cierre-orden-inspeccion.component.html',
  styleUrls: ['./pantalla-cierre-orden-inspeccion.component.css']
})
export class PantallaCierreOrdenInspeccionComponent implements OnInit, OnDestroy {

  mapa: Map<string, string> = new Map();

  tablaMotivo = false;
  
  ordenesDeInspeccion: OrdenDeInspeccion[] = [];
  ordenesSeleccionadas: OrdenDeInspeccion[] = [];
  ordenesBackup: OrdenDeInspeccion[] = [];  

  motivoTipoLista: string[] = [];  
  cargando = true;
  errorCarga = false;
  observacionesGuardadas: boolean = false;
  observacionesGuardadasLista: any[] = [];
  btnVisible= false;

  modoObservacion: boolean = false;
  private subscriptions: Subscription = new Subscription();
  constructor(private pantallaCierreOrdenInspeccionService: PantallaCierreOrdenInspeccionService) {
    
  }


  

 recibirMapaActualizado(mapaActualizado: Map<string, string>) {
    this.mapa = mapaActualizado;
    console.log("Mapa recibido del hijo:", this.mapa);
  }


    
   alternarMotivos() {
   this.tablaMotivo = !this.tablaMotivo
   }

  ngOnInit(): void {
   this.mostrarOrdenesOrdenadas();
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
   
   
  }

  mostrarOrdenesOrdenadas(): void {
    this.cargando = true;
    this.errorCarga = false;
    const sub = this.
    pantallaCierreOrdenInspeccionService.getAllOrdenesInspeccion(2).subscribe({
      next: (data: OrdenDeInspeccion[]) => {
        this.ordenesDeInspeccion = data;
        this.ordenesBackup= data;
        console.log(data)
        this.cargando = false;
      },
      error: (err) => {
        console.error('Error al obtener órdenes:', err);
        this.errorCarga = true;
        this.cargando = false;
      }
    });
    
    this.subscriptions.add(sub);
  }

  estaSeleccionada(orden: OrdenDeInspeccion): boolean {
    return this.ordenesSeleccionadas.some(o => o.numeroOrden === orden.numeroOrden);
  }

  // onCheckboxChange(orden: OrdenDeInspeccion, event: Event): void {
  //   const target = event.target as HTMLInputElement;
  //   const isChecked = target.checked;
    
  //   if (isChecked) {
  //     if (!this.estaSeleccionada(orden)) {
  //       this.ordenesSeleccionadas.push(orden);
  //     }
  //   } else {
  //     this.ordenesSeleccionadas = this.ordenesSeleccionadas.filter(
  //       o => o.numeroOrden !== orden.numeroOrden
  //     );
  //   }
  // } Comentado por Alvaro, lo reescribi para solo permitir seleccionar una orden.
  onCheckboxChange(orden: OrdenDeInspeccion, event: Event): void {
    const target = event.target as HTMLInputElement;
    const isChecked = target.checked;
  
    if (isChecked) {
      // Si se selecciona una nueva, limpiar el array y agregar solo esta
      this.ordenesSeleccionadas = [orden];
    } else {
      // Si se desmarca, limpiar el array
      this.ordenesSeleccionadas = [];
    }
  }
  limpiarSeleccion(): void {
    this.ordenesSeleccionadas = [];
  }

  procesarSeleccionadas(): void {
    if (this.ordenesSeleccionadas.length === 0) return;
       console.log('Órdenes seleccionadas:', this.ordenesSeleccionadas);
     
  }

  aceptarSeleccion() {
    this.ordenesDeInspeccion =  this.ordenesSeleccionadas;
  this.modoObservacion = true;
  this.btnVisible=true;

}

guardarObservaciones() {
  console.log("Enviando órdenes seleccionadas:", this.ordenesSeleccionadas);
  this.motivoTipoLista = [];
  this.pantallaCierreOrdenInspeccionService.tomarOrdenSelec(this.ordenesSeleccionadas).subscribe({
    next: (res: { [key: string]: string[] }) => {
       this.motivoTipoLista = [];
      for (let grupo in res) {
        this.motivoTipoLista.push(...res[grupo]); 
        
      }
      
      console.log (this.motivoTipoLista); 
      this.ordenesSeleccionadas = [];
      this.limpiarSeleccion();
    },
    error: (err) => {
      console.error("Error al enviar las órdenes:", err);
      alert("Ocurrió un error al guardar las observaciones.");
    }
  });

  this.observacionesGuardadasLista = this.ordenesSeleccionadas
    .filter(orden => orden.observacionCierre)
    .map(orden => ({
      id: orden.numeroOrden,
      motivo: orden.observacionCierre,
      seleccionada: false
    }));


  this.btnVisible=false;
  this.alternarMotivos();  
}

cancelarObservacion() {
  this.modoObservacion = false;
  this.ordenesDeInspeccion = this.ordenesBackup;
  this.limpiarSeleccion();
}

mostrarMotivosTiposParaSeleccion() {
}


// Modifica tu método guardarObservaciones()
//guardarObservaciones() {
  // 1. Guardar las observaciones (tu lógica actual)
  // ...
  
  // 2. Preparar datos para la tabla de observaciones
  
  // 3. Cambiar estados
 


// Métodos para las nuevas acciones
exportarObservaciones() {
  const seleccionadas = this.observacionesGuardadasLista.filter(obs => obs.seleccionada);
  console.log('Exportando:', seleccionadas);
  // Tu lógica para exportar
}

eliminarObservaciones() {
  this.observacionesGuardadasLista = this.observacionesGuardadasLista
    .filter(obs => !obs.seleccionada);
  
  if (this.observacionesGuardadasLista.length === 0) {
    this.observacionesGuardadas = false;
  }
}


}