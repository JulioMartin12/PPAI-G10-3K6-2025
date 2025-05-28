import { Usuario } from "./usuario.model";

export class Sesion {
    private _id?: number | undefined;
    public get id(): number | undefined {
        return this._id;
    }
    public set id(value: number | undefined) {
        this._id = value;
    }
    private _fechaHoraDesde!: string;
    public get fechaHoraDesde(): string {
        return this._fechaHoraDesde;
    }
    public set fechaHoraDesde(value: string) {
        this._fechaHoraDesde = value;
    }
    private _fechaHoraHasta?: string | null | undefined;
    public get fechaHoraHasta(): string | null | undefined {
        return this._fechaHoraHasta;
    }
    public set fechaHoraHasta(value: string | null | undefined) {
        this._fechaHoraHasta = value;
    }
    private _usuario?: Usuario | undefined;
    public get usuario(): Usuario | undefined {
        return this._usuario;
    }
    public set usuario(value: Usuario | undefined) {
        this._usuario = value;
    }

    constructor(init?: Partial<Sesion>){
        Object.assign(this, init);
    }

   

}
