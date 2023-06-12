import { IHeader } from './../../../core/entidades/EntityService';
import * as moment from 'moment';

/* eslint-disable @typescript-eslint/member-ordering */
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Platform, PopoverController } from '@ionic/angular';
import { finalize } from 'rxjs/operators';
import { EntityService, FilterLookupOptions, FilterSequence, FilterType } from 'src/app/core/entidades/EntityService';
import { PageModel } from 'src/app/core/entidades/PageModel';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-lista-generica',
  templateUrl: './lista-generica.component.html',
  styleUrls: ['./lista-generica.component.scss'],
})
export class ListaGenericaComponent implements OnInit{

  @Input() service: EntityService<any>;
  @Input() defaultClass = 'container-fluid';
  @Input() title: string;
  @Input() subtitle: string;
  @Input() fixedFilter: string;
  @Input() actionsLabel = 'Ações';
  @Input() editLabel = this.translateService.instant('furbot.editar');

  @Input() nativeFilter = null;

  @Input() showAddButton = false;
  @Input() addButtonLabel = '';

  @Input() seccondaryButton = false;
  @Input() seccondaryButtonLabel = '';

  @Input() canAdd = true;
  @Input() canEdit = true;
  @Input() canFilter = true;
  @Input() canHeader = true;
  @Input() canSelect = true;
  @Input() canActions = false;
  @Input() showActions = true;

  @Input() isMobile = false;
  @Input() isLookup = false;
  @Input() hiddenPagination = false;

  @Input() hideOptionsByField = null;

  @Input() disableInfinitScroll = false;

  @Input() set update(timestamp: number) {
    if (timestamp) {
      this.page = 0;
      this.size = 10;
      this.itens = null;
      this.isLoading = true;
      this.list();
    }
  }

  @Output() add = new EventEmitter();
  @Output() edit = new EventEmitter<number>();
  @Output() selected = new EventEmitter<any[]>();
  @Output() action = new EventEmitter<any>();
  @Output() conditionEvent = new EventEmitter<any>();

  @Output() totalItems = new EventEmitter<any>();

  public itens: PageModel<any>;
  public lookupSuggestion = [];

  public tableBody: IHeader[];
  public allSelect = false;
  public isLoading = true;
  public showFilter = false;
  public filterSequence = FilterSequence;
  public page = 0;
  public size = 10;

  constructor(
    private sanitizer: DomSanitizer,
    private popoverController: PopoverController,
    private platform: Platform,
    private router: Router,
    private translateService: TranslateService
  ) { }

  ngOnInit() {
    this.tableBody = this.getTableBody();
  }

  public list(event = null) {
    if (!event) {
      this.isLoading = true;
    }
    if (!event) {
      this.itens = null;
      this.showFilter = false;
      this.selected.emit([]);
    }
    this.service.list({
      filtro: this.nativeFilter || this.getFilter(),
      page: this.page,
      size: this.size,
      ordenar: this.getOrder()
    })
      .pipe(finalize(() => {
        if (event) {
          event.target.complete();
        } else {
          this.isLoading = false;
        }
      }))
      .subscribe(itens => {
        itens.conteudo.forEach(item => {
          this.tableBody.forEach(tb => {
            if (tb.process) {
              item[tb.key] = this.htmlSerialize(tb.process(item));
            }
          });
        });
        if (event) {
          this.itens.conteudo = this.itens.conteudo.concat(itens.conteudo);
        } else {
          this.itens = itens;
        }
        this.totalItems.emit(itens.totalElementos);
      });
  }

  public loadData(event) {
    if (!this.disableInfinitScroll) {
      this.page++;
      this.list(event);
    } else {
      event.target.complete();
    }
  }

  public onPage(event) {
    this.itens = null;
    this.page = event.pageIndex;
    this.size = event.pageSize;
    this.list();
  }

  public selectAll() {
    this.itens.conteudo.forEach(item => {
      item.isSelect = this.allSelect;
    });
    this.onSelectItem();
  }

  public onSelectItem() {
    setTimeout(() => {
      this.selected.emit(this.itens.conteudo.filter(item => !!item.isSelect));
    });
  }

  public selectItem(item: any, header) {
    if (header.goTo) {
      this.router.navigate(header.goTo(item));
    } else {
      item.isSelect = !item.isSelect;
      this.onSelectItem();
    }
  }

  public clear() {
    this.service.header.forEach(header => {
      header.filterObject = null;
      header.filterStr = null;
    });
    this.list();
  }

  public getFilter() {
    let filters = this.doFilters().join(' AND ');
    if (this.fixedFilter) {
      filters += `${filters ? ' AND ' : ''}${this.fixedFilter}`;
    }
    return filters;
  }

  public doFilters() {
    return this.service.header
      .filter(header => !!header.filterStr)
      .map(header => {
        if (header.filterType === FilterType.PRICE || header.filterType === FilterType.NUMBER) {
          if (!header.filterSequenceValue) {
            return `${header.key} ${FilterSequence.RIGHT} ${this.formatNumber(header.filterStr)}`;
          }
          return `${header.key} ${header.filterSequenceValue} ${this.formatNumber(header.filterStr)}`;
        }
        if (header.filterType === FilterType.DATETIME) {
          if (!header.filterSequenceValue) {
            return `${header.key} ${FilterSequence.EQUALS} ${moment(header.filterStr).toDate().toISOString()}`;
          }
          return `${header.key} ${header.filterSequenceValue} ${moment(header.filterStr).toDate().toISOString()}`;
        }
        if (header.filterType === FilterType.SELECT) {
          return `${header.key} EQ ${(header.filterStr as any).key}`;
        }
        if (header.filterType === FilterType.LOOKUP) {
          return `${header.filterLookupOptions.searchField} EQ ${(header.filterStr as any).id}`;
        }
        return `${header.key} LIKE ${header.filterStr}`;
      });
  }

  private formatNumber(numbero: string) {
    return numbero ? numbero : null;
  }

  public async optionsFilter(ev, item) {
    // const popover = await this.popoverController.create({
    //   component: OptionFilterComponent,
    //   translucent: true,
    //   event: ev,
    //   mode: 'md',
    // });
    // await popover.present();
    // const { data } = await popover.onWillDismiss();
    // if (data !== undefined && data !== null) {
    //   item.filterSequenceValue = data;
    // }
  }

  public onKey(event) {
    if (event.key === 'Enter') {
      this.list();
    }
  }

  public changeOrder(index: number) {
    if (!this.service.header[index].disableOrder) {
      const oldOrder = this.service.header[index].order;
      this.service.header.forEach(header => header.order = null);
      if (!oldOrder) {
        this.service.header[index].order = 'asc';
      } else if (oldOrder === 'asc') {
        this.service.header[index].order = 'desc';
      } else {
        this.service.header[index].order = null;
      }
      this.page = 0;
      this.list();
    }
  }

  public getOrder() {
    const order = this.service.header.filter(header => header.order);
    if (order && order.length) {
      return `${order[0].key} ${order[0].order}`;
    }
    return '';
  }

  public onLookupSearch(event, filterLookupOptions: FilterLookupOptions) {
    filterLookupOptions.service.list({
      filterQuery: `${filterLookupOptions.field || 'name'} LIKE ${event.query}`
    }).subscribe(value => {
      this.lookupSuggestion = value.contents;
    });
  }

  public onAdd() {
    this.add.emit();
  }

  public onEdit(id: number) {
    if (!this.canActions && this.showActions && this.canEdit) {
      this.edit.emit(id);
    }
  }

  public onActions(item) {
    this.action.emit(item);
  }

  public openAndCloseFilter() {
    this.showFilter = !this.showFilter;
  }

  public getTableFilter() {
    return this.service.header.filter(header => header.filter);
  }

  public getTableHeader() {
    return this.service.header;
  }

  public getTableBody() {
    return this.service.header.filter(header => !header.hiddenInTable);
  }

  public htmlSerialize(html) {
    return this.sanitizer.bypassSecurityTrustHtml(html);
  }

  public getFilterType() {
    return FilterType;
  }

  public hasHideAction(item) {
    console.log(!item[this.hideOptionsByField]);
    return !item[this.hideOptionsByField];
  }
}
