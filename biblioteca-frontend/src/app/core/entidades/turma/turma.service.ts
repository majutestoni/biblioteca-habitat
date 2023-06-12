import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';
import { EntityService, FilterType, ListParams } from '../EntityService';
import { Model } from '../../../shared/features/feature-view';
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: 'root'
})
export class TurmaService extends EntityService<TurmaModel>{

  private alterarSenha: string = this.translateService.instant('furbot.alterarSenha');

  constructor(
    protected http: HttpClient,
    private translateService: TranslateService
  ) {
    super(http, `${environment.urlBackend}/turmas`, [
      {
        key: 'id',
        name: translateService.instant('furbot.codigo'),
        filter: false,
        hiddenInTable: true,
        filterType: FilterType.STRING,
        process: obj => `#${obj.id}`,
      },
      {
        key: 'codigo',
        name: translateService.instant('furbot.codigo'),
        filter: false,
        filterType: FilterType.STRING
      },
      {
        key: 'nome',
        name: translateService.instant('furbot.nome'),
        filter: false,
        hiddenInTable: false,
        filterType: FilterType.STRING,
      },
      {
        key: 'turno',
        name: translateService.instant('furbot.turno'),
        filter: false,
        hiddenInTable: false,
        filterType: FilterType.STRING,
      },
      {
        key: 'anoLetivo',
        name: translateService.instant('furbot.anoLetivo'),
        filter: false,
        hiddenInTable: false,
        filterType: FilterType.STRING,
      },
      {
        key: 'idButton',
        name: translateService.instant('furbot.alterarSenha'),
        filter: false,
        hiddenInTable: false,
        disableOrder: true,
        filterType: FilterType.STRING,
        align: 'center',
        goTo: (obj: any) => ['/', 'professor', 'turmas', obj.id, 'senha'],
        process: () => `<ion-button fill="clear" size="small">${this.alterarSenha}</ion-button>`
      }
    ],
      (obj) => { }
    );
  }

  public obterTurmasPorAluno(id: string) {
    return this.http
    .get<TurmaModel>(`${environment.urlBackend}/turma-alunos/turmas-por-aluno/${id}`)
    .pipe(this.defaultCatch()) as any;
  }

  public alteraSenha(alteraSenha) {
    return this.http.post(`${this.entityUrl}/altera-senha`, alteraSenha);
    console.log(this.translateService.defaultLang);

  }

}

export interface TurmaModel extends Model {
  nome: string;
}

