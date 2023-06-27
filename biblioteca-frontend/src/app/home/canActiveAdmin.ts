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

    const teste = this.appStorage.get('admin')
    console.log(teste)
    return this.appStorage.get('admin')
  }
}

