import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { EntityService } from '../EntityService';

@Injectable({
    providedIn: 'root'
})
export class MaterialService extends EntityService<Material> {
    public subject = new Subject();

    constructor(protected http: HttpClient) {
        super(http, `${environment.urlBackend}/material`);
    }

    publicados(): Observable<RetornoMaterial> {
        return this.http.get<RetornoMaterial>(`${environment.urlBackend}/material/publicados`);
    }

    paraAprovar(): Observable<RetornoMaterial> {
        return this.http.get<RetornoMaterial>(`${environment.urlBackend}/material/admin`);
    }

    getById(id: string): Observable<Material>{
        return this.http.get<Material>(`${environment.urlBackend}/material/admin/${id}`);
    }

    novo(body): Observable<Material> {
        return this.http.post<Material>(`${environment.urlBackend}/material/novo`, body);
    }

    limparVencidos(): Observable<String> {
        return this.http.delete<String>(`${environment.urlBackend}/material`);
    }
}

export interface RetornoMaterial {
    conteudo: Material[];

    totalElementos: number;

    totalPaginas: number;
}

export interface Material {
    id: string;
    titulo: string;
    idioma: string
    descricao: string;
    colaborador: string
    ano: number;
    tipo: string;
    link: string;
    editar: boolean;
    aprovado: boolean;
    autoresRetornoDtos: Autor[];
    palavraRetornoDtos: Palavra[];
    temaRetornoDtos: Tema[];
}

export interface Autor {
    id: string;
    nome: string;
}

export interface Palavra {
    id: string;
    palavra: string;
}

export interface Tema {
    id: string;
    tema: string;
}
