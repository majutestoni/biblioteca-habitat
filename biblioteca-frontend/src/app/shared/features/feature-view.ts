/* eslint-disable max-len */
/* eslint-disable @typescript-eslint/member-ordering */
import { Inject, Injectable, Input, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertController, IonContent } from '@ionic/angular';
import { forkJoin } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { AppLoaderService } from 'src/app/core/app-loader/app-loader.service';
import { AppUtilsService } from 'src/app/core/app-utils/app-utils.service';
import { EntityService } from 'src/app/core/entidades/EntityService';

export interface Model {
  id?: string;
}

@Injectable()
export class FeatureView<T extends Model> {

  @ViewChild(IonContent, { read: IonContent, static: false }) ionContent: IonContent;
  @Input() set openModal(permission) {
    if (permission) {
      this.permission = permission;
      this.selectPage = true;
      this.ionViewWillEnter();
      this.ionViewDidEnter();
    }
  }

  public scrollTop = 0;

  public selecteds: T[];
  public updateTable = null;
  public filterStr = '';
  public fixedFilter = '';
  public isMobile = false;
  public isDesktop = true;
  public selectPage = false;

  public searchFocus = false;

  public permission: any;

  constructor(
    protected alertController: AlertController,
    protected router: Router,
    protected service: EntityService<T>,
    @Inject(String) protected formRouter: string,
    protected utils: AppUtilsService,
    protected activatedRoute: ActivatedRoute,
    protected appLoader: AppLoaderService
  ) { }

  ionViewWillEnter() {
    this.isMobile = this.utils.isMobile();
    this.isDesktop = !this.utils.isMobile();
    this.permission =
      this.activatedRoute.snapshot.data.permissions ||
      this.permission;
    this.updateTable = new Date().getTime();
  }

  ionViewDidEnter() {
    if (this.ionContent) {
      this.ionContent.getScrollElement().then(element => {
        element.onscroll = () => {
          this.scrollTop = element.scrollTop;
          // if (this.scrollTop > 10) {
          //   this.utils.changeNotificationBar();
          // }
        };
      });
    }
  }

  public selectedProcedures(itens: T[]) {
    this.selecteds = itens;
  }

  public async onGlobalFilter(field: string) {
    const filter = this.filterStr;
    setTimeout(() => {
      if (filter === this.filterStr) {
        this.fixedFilter = `${field} LIKE ${filter}`;
        setTimeout(() => {
          this.updateTable = new Date().getTime();
        });
      }
    }, 700);
  }

  public async audit() {
    const [item] = this.selecteds as any;
    const alert = await this.alertController.create({
      header: 'Auditoria',
      message: `Criado: ${this.utils.formataData(item.criadoEm)} <br> Por: ${item.criadoPor} <br><br> Editado: ${this.utils.formataData(item.atualizadoEm)} <br> Por: ${item.atualizadoPor}`,
      buttons: [
        {
          text: 'OK',
          role: 'cancel',
        }
      ]
    });

    await alert.present();
  }

  public async delete() {
    return new Promise(async resolve => {
      const alert = await this.alertController.create({
        header: 'Remover item(s)',
        backdropDismiss: false,
        message: `Deseja realmente remover este(s) item(s)?<br><br> Após a confirmação não será possível restaurá-los!`,
        buttons: [
          {
            text: 'Não',
            role: 'cancel',
            handler: () => resolve({})
          },
          {
            text: 'Sim',
            cssClass: 'delete-color',
            handler: async () => {
              await this.doDelete();
              resolve({});
            }
          }
        ]
      });

      await alert.present();
    });
  }

  protected async doDelete() {
    const loader = await this.appLoader.show();
    const deletes = (this.selecteds as any).map(item => this.service.delete(item.id));
    await forkJoin(deletes)
      .pipe(finalize(() => {
        this.appLoader.close(loader);
        this.updateTable = new Date().getTime();
      })).toPromise();
  }

  public duplicate() {
    const [item] = this.selecteds;
    this.router.navigate([this.formRouter, item.id], {
      queryParams: {
        duplicate: true
      }
    });
  }

  public searchbarFocus(focus: boolean) {
    this.searchFocus = focus && this.isMobile;
  }

  public onAdd() {
    this.router.navigate([this.formRouter, 'new']);
  }

  public onEdit(id: number) {
    this.router.navigate([this.formRouter, id]);
  }

}
