import { Component, OnInit, OnDestroy } from '@angular/core';
import { PantallaCierreOrdenInspeccionService } from '../services/pantalla-cierre-orden-inspeccion.service';
import { OrdenDeInspeccion } from '../models/orden-de-inspeccion.model';
import { Subscription } from 'rxjs';
import { MotivoTipo } from '../models/motivo-tipo.model';

@Component({
  selector: 'app-pantalla-cierre-orden-inspeccion',
  templateUrl: './pantalla-cierre-orden-inspeccion.component.html',
  styleUrls: ['./pantalla-cierre-orden-inspeccion.component.css']
})
export class PantallaCierreOrdenInspeccionComponent implements OnInit, OnDestroy {
  ordenesDeInspeccion: OrdenDeInspeccion[] = [];
  ordenesSeleccionadas: OrdenDeInspeccion[] = [];
  ordenesBackup: OrdenDeInspeccion[] = [];  
   motivoTipoLista: MotivoTipo[] = [];  
   cargando = true;
   errorCarga = false;
  modoObservacion: boolean = false;
  private subscriptions: Subscription = new Subscription();
  constructor(private pantallaCierreOrdenInspeccionService: PantallaCierreOrdenInspeccionService) {
    
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

}

guardarObservaciones() {
  console.log("Enviando órdenes seleccionadas:", this.ordenesSeleccionadas);

  this.pantallaCierreOrdenInspeccionService.tomarOrdenSelec(this.ordenesSeleccionadas).subscribe({
    next: (res) => {
      console.log("Respuesta:", res);

      // Luego de éxito:
      this.modoObservacion = false;
      this.ordenesSeleccionadas = [];
      this.ordenesDeInspeccion = this.ordenesBackup;
      this.limpiarSeleccion();
    },
    error: (err) => {
      console.error("Error al enviar las órdenes:", err);
      alert("Ocurrió un error al guardar las observaciones.");
    }
  });
}

cancelarObservacion() {
  this.modoObservacion = false;
  this.ordenesDeInspeccion = this.ordenesBackup;
  this.limpiarSeleccion();
}

mostrarMotivosTiposParaSeleccion() {
}


}