import { Injectable } from '@angular/core';
import { ToastController } from '@ionic/angular';
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: 'root',
})
export class AppErroService {
  constructor(
    private toastController: ToastController,
    private translateService: TranslateService
  ) { }

  async exibirErros(mensagem: string) {
    const toast = await this.toastController.create({
      message: mensagem,
      position: 'top',
      color: 'danger',
      duration: 4000,
      buttons: [
        {
          text: this.translateService.instant('furbot.ok'),
          role: 'cancel',
        },
      ],
    });
    await toast.present();
  }

  async exibirMensagem(mensagem: string) {
    const toast = await this.toastController.create({
      message: mensagem,
      position: 'top',
      color: 'success',
      duration: 4000,
      buttons: [
        {
          text: this.translateService.instant('furbot.ok'),
          role: 'cancel',
        },
      ],
    });
    await toast.present();
  }
}
