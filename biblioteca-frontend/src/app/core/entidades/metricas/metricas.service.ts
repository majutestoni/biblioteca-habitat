/* eslint-disable max-len */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { EntityService, FilterType } from '../EntityService';

@Injectable({
  providedIn: 'root'
})
export class MetricasService extends EntityService<any> {

  constructor(
    protected http: HttpClient
  ) {
    super(http, `${environment.urlBackend}/metricas`, [],
      (obj) => { }
    );
  }

  public sumarizados() {
    return this.http.get(`${this.entityUrl}/sumarizados`);
  }

  public tempoDeJogo(params) {
    return this.http.get(`${environment.urlBackend}/eventos/tempo-jogo`, {
      params
    });
  }

  public reinicioDeJogo(params) {
    return this.http.get(`${environment.urlBackend}/eventos/reinicio-fase`, {
      params
    });
  }

  public clicouEmExecutar(params) {
    return this.http.get(`${environment.urlBackend}/eventos/clicou-em-executar`, {
      params
    });
  }

  public erroDeCompilacao(params) {
    return this.http.get(`${environment.urlBackend}/eventos/erro-de-compilacao`, {
      params
    });
  }

  public erroDeExecucao(params) {
    return this.http.get(`${environment.urlBackend}/eventos/erro-de-execucao`, {
      params
    });
  }

  public escreveuCodigo(params) {
    return this.http.get(`${environment.urlBackend}/eventos/escreveu-codigo`, {
      params
    });
  }

  public getColors(index) {
    //const colors = ['#987041', '#6ba748', '#cce96a', '#fce85f', '#7b5819', '#348735', '#bae03f', '#FFcb13', '#693004', '#216e2c', '#99ce1b', '#d09d0c', '#3a77b5', '#1a4c1d', '#87b918', '#b252a6', '#2c609e', '#fb6848', '#5c8118', '#660159', '#1a3e76', '#d03727', '#4c0071', '#051b39', '#940007'];
    const colors = ['#CD5C5C', '#808000', '#FF00FF', '#FFA07A', '#FF0000', '#DDA0DD', '#8B0000', '#FF6347', '#98FB98', '#2E8B57', '#8B4513', '#5F9EA0', '#FFD700', '#FFFF00', '#FFFFE0', '#BDB76B', '#8A2BE2', '#8B008B', '#4B0082', '#00FF00', '#32CD32', '#006400', '#696969', '#00FFFF', '#2F4F4F'];
    return colors[index];
  }
}
