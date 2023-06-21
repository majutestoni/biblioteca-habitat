import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CriarEnderecoPage } from './criar-endereco.page';


const routes: Routes = [
  {
    path: '',
    component: CriarEnderecoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CriarEnderecoPageRoutingModule {}
