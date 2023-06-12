import { EventEmitter, Injectable } from '@angular/core';
import { LoadingController } from '@ionic/angular';

@Injectable({
  providedIn: 'root'
})
export class AppLoaderService {

  public session = new EventEmitter();

  constructor(
    public loadingController: LoadingController
  ) { }

  public async show() {
    const loading = await this.loadingController.create({
      message: '',
      mode: 'ios',
      translucent: true,
      backdropDismiss: false
    });
    setTimeout(() => {
      if (loading.isConnected) {
        loading.message = 'Aguarde...';
      }
    }, 5000);
    const timeout = setTimeout(() => {
      loading.present().then();
    }, 350);
    (loading as any).timeout = timeout;
    return loading;
  }

  public close(loader) {
    clearTimeout(loader.timeout);
    loader.dismiss();
  }

  public getSession() {
    return this.session;
  }

  public setSession() {
    this.session.emit();
  }
}
