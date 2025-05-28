export class MotivoTipo {

    nombre!: string;

    constructor(init?: Partial<MotivoTipo>){
        Object.assign(this,init);
    }
}
