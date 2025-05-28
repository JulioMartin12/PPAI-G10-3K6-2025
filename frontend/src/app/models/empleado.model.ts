export class Empleado {
   id?: number ;
   nombre!: string;
   apellido!: string;
   mail!: string;
   telefono!: string;



   constructor(init?: Partial<Empleado>) {
      Object.assign(this, init)
   }

}
