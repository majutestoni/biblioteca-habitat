import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FiltroPage } from './filtro.page';

const routes: Routes = [
  {
    path: '',
    component: FiltroPage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FiltroPageRoutingModule {}
