import { Sismografo } from "./sismografo.model";

export class EstacionSismologica {

     codigoEstacion!: string;
     documentoCertificacionAdq!: string;
     fechaSolicitudCertificacion!: string;
     latitud!: number;
     longitud!: number;
     nombre!: string;
     nroCertificacionAdquisicion!: number;
     sismografo?: Sismografo;

     constructor(init?: Partial<EstacionSismologica>){
        Object.assign(this, init);
     }
}
