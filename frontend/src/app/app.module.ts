import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { from } from 'rxjs';
import { PantallaCierreOrdenInspeccionComponent } from './pantalla-cierre-orden-inspeccion/pantalla-cierre-orden-inspeccion.component';
import { FormsModule } from '@angular/forms';
import { TablaMotivosComponent } from './pantalla-cierre-orden-inspeccion/tabla-motivos/tabla-motivos.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PantallaCierreOrdenInspeccionComponent,
    TablaMotivosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
