import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { AppStorageService } from './app-storage/app-storage.service';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable()
export class HttpConfigInterceptor implements HttpInterceptor {

  constructor(
    private appStorage: AppStorageService,
    private router: Router
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let newRequest = request;
    if (request.url.includes(environment.urlBackend)) {
      const token = this.appStorage.get(AppStorageService.KEY_STORAGE.token);

      if (token) {
        newRequest = newRequest.clone({ headers: newRequest.headers.set('Authorization', token.Authorization) });
      }
    }

    return next.handle(newRequest).pipe(
      catchError(error => {
        if (error.status === 403) {
          localStorage.clear();
          this.router.navigate(['/']);
        }
        return throwError(error);
      }),
      map((event: HttpEvent<any>) => event));
  }
}
