import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PantallaCierreOrdenInspeccionComponent } from './pantalla-cierre-orden-inspeccion/pantalla-cierre-orden-inspeccion.component';

const routes: Routes = [{ path: 'cerrar-orden', component : PantallaCierreOrdenInspeccionComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
