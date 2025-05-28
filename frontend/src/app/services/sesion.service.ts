import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sesion } from '../models/sesion.model';

@Injectable({
  providedIn: 'root'
})
export class SesionService {
 
  private apiUrl = 'http://localhost:8081/api/sesiones';
 
  constructor(private http: HttpClient) { }

   getSesionPorId(id: number): Observable<Sesion> {
    return this.http.get<Sesion>(`${this.apiUrl}/${id}`);
  }
}
