import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { EntityService } from '../EntityService';
import { Endereco } from '../usuario/usuario.service';

@Injectable({
    providedIn: 'root'
})
export class EnderecoService extends EntityService<Endereco> {
    public subject = new Subject();

    constructor(protected http: HttpClient) {
        super(http, `${environment.urlBackend}/endereco`);
    }

    buscar(cep: String) {
        return this.http.get(`https://viacep.com.br/ws/${cep}/json/`);
    }

    getAll(): Observable<Endereco[]> {
        return this.http.get<Endereco[]>(`${environment.urlBackend}/endereco/findAll`);
    }

    findByPais(pais): Observable<Endereco[]> {
        return this.http.get<Endereco[]>(`${environment.urlBackend}/endereco/findAll/${pais}`);
    }

    findByEstado(estado): Observable<Endereco[]> {
        return this.http.get<Endereco[]>(
            `${environment.urlBackend}/endereco/findAll/estado/${estado}`
        );
    }

    cadastrar(body: CreateEndereco): Observable<Endereco> {
        return this.http.post<Endereco>(`${environment.urlBackend}/endereco`,  body );
    }
}

export interface CreateEndereco {
    cidade: string;
    estadoOuProvincia: string;
    pais: string;
}
