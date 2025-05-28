import { EstacionSismologica } from "./estacion-sismologica.model";
import { Estado } from "./estado.model";

export class Sismografo {

    nroSerie!: number;
    fechaAdquisicion?: string ;
    identificadorSismografo?: number;

    /* private List<CambioEstado> cambioEstado; */
    estacionSismologica?:EstacionSismologica ;
     estado?: Estado;
}
