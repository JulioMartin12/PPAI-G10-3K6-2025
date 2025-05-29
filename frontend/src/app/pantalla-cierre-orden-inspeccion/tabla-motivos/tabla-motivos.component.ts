import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { PantallaCierreOrdenInspeccionService } from 'src/app/services/pantalla-cierre-orden-inspeccion.service';


@Component({
  selector: 'app-tabla-motivos',
  templateUrl: './tabla-motivos.component.html',
  styleUrls: ['./tabla-motivos.component.css']
})
export class TablaMotivosComponent {
  
  motivoSeleccionado: string = '';
  comentario: string = '';
  indiceSeleccionado: number | null = null; 
  finalizar : boolean = true;

  @Input( ) lista : string [] = [];
  
 @Input() mapa: Map<string, string> = new Map();
 
  @Output() mapaModificado = new EventEmitter<Map<string, string>>();




constructor(private pantallaCierreOrdenInspeccionService: PantallaCierreOrdenInspeccionService) {
    
  }


  agregarElemento(clave: string, valor: string) {
    this.mapa.set(clave, valor);
    this.mapaModificado.emit(this.mapa);
  }


  motivoCheck(motivo: string, index: number) {
  this.motivoSeleccionado = motivo;
  this.indiceSeleccionado = index;
   
}






  

  enviarComentario() {
  if (this.motivoSeleccionado && this.comentario.trim() !== '') {
    // Agregamos al mapa
    this.mapa.set(this.motivoSeleccionado, this.comentario.trim());

    // Eliminamos el motivo de la lista
    this.lista = this.lista.filter(motivo => motivo !== this.motivoSeleccionado);

    // Limpiamos selección y comentario
    this.motivoSeleccionado = '';
    this.comentario = '';
  } else {
    alert('Debe seleccionar un motivo y escribir un comentario.');
  }

  // Opcional: imprimir el mapa en consola
  console.log("MAPA ACTUAL:");
  this.mapa.forEach((coment, motivo) => {
    console.log(`${motivo} => ${coment}`);
  });

  if(this.lista.length == 0){
  const datos = Object.fromEntries(this.mapa);
   this.pantallaCierreOrdenInspeccionService.enviarMotivosConComentarios(datos).subscribe({
  next: (res) => {
    console.log('Enviado correctamente', res);
    alert('Los motivos fueron enviados al backend con éxito.');
  },
  error: (err) => {
    console.error('Error al enviar motivos', err);
    alert('Error al enviar motivos al backend.');
  }
});

  }

}


finalizarSeleccion(){
 const datos = Object.fromEntries(this.mapa);
  this.pantallaCierreOrdenInspeccionService.enviarMotivosConComentarios(datos).subscribe({
  next: (res) => {
    console.log('Enviado correctamente', res);
    alert('Los motivos fueron enviados al backend con éxito.');
  },
  error: (err) => {
    console.error('Error al enviar motivos', err);
    alert('Error al enviar motivos al backend.');
  }
});
}

}
