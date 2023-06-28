import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppStorageService {

  // eslint-disable-next-line @typescript-eslint/naming-convention
  public static KEY = 'br.com.furbot';

  // eslint-disable-next-line @typescript-eslint/naming-convention
  public static KEY_STORAGE = {
    token: `${AppStorageService.KEY}.token`,
    logado: `${AppStorageService.KEY}.logado`,
  };

  constructor() {}

  public get(key) {
    const value = localStorage.getItem(key);
    return value ? JSON.parse(value) : null;
  }

  public set(key, value) {
    localStorage.setItem(key, JSON.stringify(value));
  }

  public setLang(lang: string) {
    localStorage.setItem(lang, lang);
  }

  public getLang(lang: string) {
    return localStorage.getItem(lang);
  }
}
