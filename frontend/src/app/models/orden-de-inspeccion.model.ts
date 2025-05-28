import { Empleado } from "./empleado.model";
import { EstacionSismologica } from "./estacion-sismologica.model";
import { Estado } from "./estado.model";

export class OrdenDeInspeccion {
    numeroOrden?: number ;
    fechaHoraInicio?: string ;
    fechaHoraFinalizacion?: string 
    observacionCierre!: string;
    empleado?: Empleado ;
    estacionSismologica?: EstacionSismologica;
    estado?:Estado;
   
    constructor(init?: Partial<OrdenDeInspeccion>){
        Object.assign(this, init);
    }


}
