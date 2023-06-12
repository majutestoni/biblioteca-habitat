/* eslint-disable max-len */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import * as moment from 'moment';
import { Model } from 'src/app/shared/features/feature-view';
import { environment } from 'src/environments/environment';
import { EntityService, FilterType } from '../EntityService';


@Injectable({
  providedIn: 'root'
})
export class AlunoViewService extends EntityService<AlunoModel> {

  private alterarSenha: string = this.translateService.instant('furbot.alterarSenha');

  constructor(
    protected http: HttpClient,
    private translateService: TranslateService
  ) {
    super(http, `${environment.urlBackend}/alunos`, [
      {
        key: 'id',
        name: translateService.instant('furbot.codigo'),
        filter: false,
        hiddenInTable: true,
        filterType: FilterType.STRING,
        process: obj => `#${obj.id}`,
      },
      {
        key: 'nome',
        name: translateService.instant('furbot.nome'),
        filter: false,
        hiddenInTable: false,
        filterType: FilterType.STRING,
      },
      {
        key: 'email',
        name: translateService.instant('furbot.email'),
        filter: false,
        hiddenInTable: false,
        filterType: FilterType.STRING,
      },
      {
        key: 'dataNascimento',
        name: translateService.instant('furbot.nascimento'),
        filter: false,
        hiddenInTable: false,
        filterType: FilterType.DATETIME,
        process: (obj) => moment(obj.dataNascimento).format('DD/MM/YYYY')
      },
      {
        key: 'idButton',
        name: translateService.instant('furbot.alterarSenha'),
        filter: false,
        hiddenInTable: false,
        disableOrder: true,
        filterType: FilterType.STRING,
        goTo: (obj: any) => ['/', 'professor', 'alunos', obj.id, 'senha'],
        process: () => `<ion-button fill="clear" size="small">${this.alterarSenha}</ion-button>`
      }
    ],
      (obj) => { }
    );
  }

  public alteraSenha(aluno) {
    return this.http.post(`${this.entityUrl}/alterar-senha`, aluno);
  }
}

export interface AlunoModel extends Model {
  nome: string;
}
