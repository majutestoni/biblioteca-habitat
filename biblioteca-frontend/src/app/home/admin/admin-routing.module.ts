import { NgModule } from '@angular/core';
import {  RouterModule, Routes } from '@angular/router';
import { AdminPage } from './admin.page';
import { NovoAdminPage } from './novo/novo.page';

const routes: Routes = [
  {
    path: '',
    component: AdminPage,
  },
  {
    path:'novo',
    component: NovoAdminPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminPageRoutingModule {}
