import { Empleado } from "./empleado.model";

export class Usuario {

   private _nombreUsuario!: string;
  public get nombreUsuario(): string {
    return this._nombreUsuario;
  }
  public set nombreUsuario(value: string) {
    this._nombreUsuario = value;
  }
   private _empleado ?: Empleado;
   
   constructor(init?: Partial<Usuario>){
  Object.assign(this,init);
   }

    public get empleado(): Empleado | undefined {
    return this._empleado;
  }


    public set empleado(emp: Empleado | undefined) {
    this._empleado = emp;
  }
}
