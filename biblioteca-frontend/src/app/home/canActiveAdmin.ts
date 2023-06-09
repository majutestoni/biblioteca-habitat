import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AppStorageService } from "../core/app-storage/app-storage.service";


@Injectable()
export class CanActivateAdmin implements CanActivate {
  constructor(private appStorage: AppStorageService,) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean|UrlTree>|Promise<boolean|UrlTree>|boolean|UrlTree {

    const user = this.appStorage.get(AppStorageService.KEY_STORAGE.logado)
    return user.admin
  }
}

