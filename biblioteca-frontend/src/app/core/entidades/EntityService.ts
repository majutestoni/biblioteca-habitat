/* eslint-disable @typescript-eslint/naming-convention */
import { HttpParams, HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { PageModel } from './PageModel';

export class EntityService<T> {

  constructor(
    protected http: HttpClient,
    protected entityUrl: string,
    public header?: IHeader[],
    public messageCondition?: any
  ) {
    this.http = http;
    this.entityUrl = entityUrl;
    this.header = header;

    this.defaultCatch = this.defaultCatch.bind(this);
  }

  public getListQueryParams(listParams: ListParams) {
    if (listParams) {
      // eslint-disable-next-line prefer-const
      let { page = 0, size = 10, sort = [], filtro = '', ordenar } = listParams;

      let params = new HttpParams();

      if (sort && sort.length) {
        params = params.append(
          'orderby',
          sort
            .map(s => {
              // eslint-disable-next-line @typescript-eslint/no-shadow
              let order = '';
              if (s.order === 1) { order = ' asc'; }
              else if (s.order === -1) { order = ' desc'; }
              return `${s.field}${order}`;
            })
            .join(', ')
        );
      }

      if (filtro) { params = params.append('filtro', filtro); }

      params = params.append('size', String(size));
      params = params.append('page', String(page));
      if (ordenar) {
        params = params.append('ordenar', String(ordenar));
      }

      return params;
    } else {
      const params = {} as any;
      return params;
    }
  }

  public defaultCatch() {
    return catchError((err: any) => {
      if (err) {
        this.doError(err);
      }

      return throwError(err);
    });
  }

  public doError(err) {
    const genericError =
      'Erro no servidor, tente novamente em alguns minutos.';
    let detail = genericError;
    if (err.error && err.error.errors) {
      detail = err.error.errors.map(e => e.message).join(', ');
    } else if (err.error && err.error.msg) {
      detail = err.error && err.error.msg;
    }
  }

  public list(listParams?: ListParams): Observable<PageModel<T>> {
    return this.http
      .get<PageModel<T>>(this.entityUrl, {
        params: this.getListQueryParams(listParams)
      })
      .pipe(this.defaultCatch()) as any;
  }

  public get(id: string) {
    return this.http
      .get<T>(`${this.entityUrl}/${id}`)
      .pipe(this.defaultCatch());
  }

  public insert(entity: T) {
    return this.http
      .post<T>(`${this.entityUrl}`, entity)
      .pipe(this.defaultCatch());
  }

  public update(id: number, entity: T) {
    return this.http
      .put<T>(`${this.entityUrl}/${id}`, entity)
      .pipe(this.defaultCatch());
  }

  public delete(id: number) {
    return this.http
      .delete<T>(`${this.entityUrl}/${id}`)
      .pipe(this.defaultCatch());
  }
}

export interface ListParams {
  page?: number;
  size?: number;
  sort?: any[];
  filtro?: string;
  ordenar?: string;
}

export interface BodyParams {
  offset?: number;
  size?: number;
  orderBy?: string;
  filter?: string;
}

export class IHeader {
  key: string;
  style?: any;
  disableOrder?: boolean;
  defaultFilter?: boolean;
  name: string;
  order?: string;
  hiddenInTable?: boolean;
  hasPhoto?: boolean;
  align?: string;
  filter: boolean;
  noLineClick?: boolean;
  filterStr?: string;
  filterType?: FilterType;
  filterSelectOptions?: FilterSelectOptions[];
  filterLookupOptions?: FilterLookupOptions;
  filterDatetimeSequence?: FilterSequence;
  filterSequece?: boolean;
  filterSequenceValue?: FilterSequence;
  process?: any;
  nowrap?: boolean;
  goTo?: any;
  filterObject?: any;
  mobileEmptyValue?: string;
  mobileHiddenOnUnexist?: boolean;
}

export enum FilterType {
  STRING, DATETIME, SELECT, LOOKUP, PRICE, BOOLEAN, NUMBER
}

export interface FilterSelectOptions {
  key: string;
  name: string;
}

export interface FilterLookupOptions {
  service: any;
  searchField: string;
  field?: string;
  seccondaryField?: string;
  seccondaryLabel?: string;
  filter?: string;
}

export enum FilterSequence {
  LEFT = 'IGUAL_MENOR', RIGHT = 'IGUAL_MAIOR', EQUALS = 'IGUAL'
}
