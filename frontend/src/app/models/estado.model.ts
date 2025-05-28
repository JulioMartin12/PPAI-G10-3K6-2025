export class Estado {

    nombre!: string;
    ambito?: string;
    descripcion!: string;

    constructor(init?: Partial<Estado>){
        Object.assign(this,init);
    }
    
}
