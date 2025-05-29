import { Injectable } from '@angular/core';
import { OrdenDeInspeccion } from '../models/orden-de-inspeccion.model';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PantallaCierreOrdenInspeccionService {
   
  private apiUrl = 'http://localhost:8081/api';

   constructor(private http: HttpClient) { 
   
   }
   
     getAllOrdenesInspeccion(id:number): Observable<OrdenDeInspeccion[]> {
      return this.http.get<OrdenDeInspeccion[]>(`${this.apiUrl}/ordenes/sesion/${id}`);
    }

   
  tomarOrdenSelec(ordenes: OrdenDeInspeccion[]): Observable<any> {
   
  if (!ordenes || ordenes.length === 0) {
    return throwError(() => new Error('El array de órdenes está vacío'));
  }

  return this.http.post(`${this.apiUrl}/ordenes`, ordenes).pipe(
    catchError(error => {
      console.error('Error en la solicitud:', error);
      return throwError(() => new Error('Error al enviar las órdenes'));
    })
  );
}

enviarMotivosConComentarios(data: { [key: string]: string }) {
  return this.http.post(`${this.apiUrl}/motivosTipo`, data);
}

}
