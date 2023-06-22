import { Injectable, NgModule } from '@angular/core';
import { Routes, RouterModule, Resolve } from '@angular/router';
import { UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';
import { MeuUsuarioPageModule } from './meu-usuario.module';

import { MeuUsuarioPage } from './meu-usuario.page';

@ Injectable({
  providedIn: 'root'
})

export class MeuUsuarioCanActivated implements Resolve<MeuUsuarioPageModule> {
  constructor(
    private service: UsuarioService
  ) { }

  resolve() {
    return this.service.buscarUsuarioLogado();
  }

}
const routes: Routes = [
  {
    path: '',
    component: MeuUsuarioPage,
    resolve: {
      entity: MeuUsuarioCanActivated
    }
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MeuUsuarioPageRoutingModule { }
