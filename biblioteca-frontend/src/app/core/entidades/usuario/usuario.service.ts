import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable, EventEmitter } from '@angular/core';
import { environment } from 'src/environments/environment';
import { EntityService } from '../EntityService';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService extends EntityService<Usuario> {

  public subject = new Subject();

  constructor(
    protected http: HttpClient
  ) {
    super(http, `${environment.urlBackend}/usuarios`);
  }

  public buscarUsuarioLogado(): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.entityUrl}/logado`);
  }

  public login(usuario, senha): Observable<Authorization> {
    return this.http.post<Authorization>(`${environment.urlBackend}/login`, {
      usuario,
      senha
    });
  }

}

export interface Authorization {
  // eslint-disable-next-line @typescript-eslint/naming-convention
  Authorization: string;
}

export interface Usuario{
  admin: boolean
  atualizadoEm: Date
  clube?: string
  criadoEm: Date
  email: string
  endereco: Endereco
  fone: string
  id: string
  instituição?: string
  nome: string
  senha: string
  usuario: string

}

export interface Endereco{
  atualizadoEm: Date
  cidade: string
  criadoEm: Date
  estadoOuProvincia: string
  id: string
  pais: string
}
