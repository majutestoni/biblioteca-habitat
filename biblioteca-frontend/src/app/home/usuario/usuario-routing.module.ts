import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioComponent } from './usuario.component';
import { MeuUsuarioCanActivated } from 'src/app/shared/meu-usuario/meu-usuario-routing.module';

const routes: Routes = [
  {
    path: '',
    component: UsuarioComponent,
    resolve: {
      entity: MeuUsuarioCanActivated
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioPageRoutingModule {}
