import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { Model } from 'src/app/shared/features/feature-view';
import { environment } from 'src/environments/environment';
import { EntityService, FilterType } from '../EntityService';

@Injectable({
  providedIn: 'root'
})
export class EscolaService extends EntityService<EscolaModel> {

  constructor(
    protected http: HttpClient,
    private translateService: TranslateService
  ) {
    super(http, `${environment.urlBackend}/escolas`, [
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
      }
    ],
      (obj) => { }
    );
  }

}

export interface EscolaModel extends Model {
  nome: string;
}
