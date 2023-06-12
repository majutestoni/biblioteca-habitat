import { Injectable } from '@angular/core';
import { Platform } from '@ionic/angular';
import * as moment from 'moment';

@Injectable({
  providedIn: 'root'
})
export class AppUtilsService {

  constructor(
    private platform: Platform
  ) { }

  public isMobile() {
    return this.platform.is('mobile');
  }

  public formataData(data) {
    return moment(data).format('DD/MM/YYYY');
  }

}
