import { AlertController } from '@ionic/angular';
import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { PrimeNGConfig } from 'primeng/api';
import { AppStorageService } from './core/app-storage/app-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent implements OnInit {
  public navSelect: string;
  public appPages = [];
  public exitTitle: string;
  private loggedUser = null;

  constructor(
    public translateService: TranslateService,
    private appStorage: AppStorageService,
    private config: PrimeNGConfig,
    private router: Router,
    private appStorageService: AppStorageService,
    private alertController: AlertController
  ) {
    this.setLang();
   }

  ngOnInit(): void {
    if (this.translateService.currentLang === 'pt') {
      this.config.setTranslation({
        accept: 'Accept',
        reject: 'Cancel',
        dayNames: ['Segunda', 'Terça-feira', 'Quarta-feira', 'Quinta-feira', 'Sexta-feira', 'Sabado', 'Domingo'],
        dayNamesShort: ['Seg', 'Ter', 'Quar', 'Quin', 'Sex', 'Sab', 'Dom'],
        dayNamesMin: ['Se', 'Te', 'Qua', 'Sex', 'Sa', 'Do'],
        // eslint-disable-next-line max-len
        monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro '],
        monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
      });
    }
    this.router.events.subscribe((val) => {
      if (this.hasSession()) {
        if (val instanceof NavigationEnd) {
          if (!this.loggedUser) {
            this.loggedUser = this.appStorageService.get(AppStorageService.KEY_STORAGE.logado);
          }
          if (this.loggedUser && this.loggedUser.perfil === 'PROFESSOR') {
            this.appPages = [
              { title: this.translateService.instant('furbot.dashboard'), url: '/professor/dashboard', icon: 'stats-chart' },
              { title: this.translateService.instant('furbot.alunos'), url: '/professor/alunos', icon: 'people' },
              { title: this.translateService.instant('furbot.escolas'), url: '/professor/escolas', icon: 'storefront' },
              { title: this.translateService.instant('furbot.turmas'), url: '/professor/turmas', icon: 'file-tray-full' },
              { title: this.translateService.instant('furbot.meuperfil'), url: '/professor/meu-usuario', icon: 'person' }
            ];
          } else {
            this.appPages = [
              { title: this.translateService.instant('furbot.dashboard'), url: '/aluno/dashboard', icon: 'stats-chart' },
              { title: this.translateService.instant('furbot.meuperfil'), url: '/aluno/meu-usuario', icon: 'person' }
            ];
          }
          this.exitTitle = this.translateService.instant('furbot.sair');
        }
      }
    });
  }

  public hasSession() {
    return this.appStorage.get(AppStorageService.KEY_STORAGE.token);
  }

  public async presentAlert() {
    let msg: string;
    const alert = await this.alertController.create({
      header: this.translateService.instant('furbot.aviso.sair'),
      buttons: [
        {
          text: this.translateService.instant('furbot.nao'),
          role: 'cancel',
          handler: () => {
            msg = 'NAO';
          },
        },
        {
          text: this.translateService.instant('furbot.sim'),
          role: 'confirm',
          handler: () => {
            msg = 'SIM';
          },
        },
      ],
    });

    await alert.present();

    const { role } = await alert.onDidDismiss();
    if (msg === 'SIM') {
      this.logOut();
    }
  }

  private logOut() {
    this.router.navigate(['/auth']);
    localStorage.clear();
    this.loggedUser = null;
  }

  private setLang() {
    this.translateService.use('pt');
    if (this.appStorageService.getLang('en')) {
      this.translateService.use('en');
    }
  }
}
