import { Component, OnInit } from '@angular/core';
import { SesionService } from '../services/sesion.service';
import { Sesion } from '../models/sesion.model';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
 
 constructor(private sesionService: SesionService){}
   sesion?: Sesion;
  
   ngOnInit(): void {
    this.conocerUsuario();
  
  }

   conocerUsuario(): void {
    this.sesionService.getSesionPorId(2).subscribe((data) => {
      this.sesion = data;
    });
  }

}
