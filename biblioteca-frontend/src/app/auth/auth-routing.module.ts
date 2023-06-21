import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthPage } from './auth.page';
import { CriarEnderecoPage } from './cadastrar-endereco/criar-endereco.page';

const routes: Routes = [
    {
        path: '',
        component: AuthPage
    },
    {
        path: 'criar-conta',
        loadChildren: () =>
            import('./criar-conta/criar-conta.module').then((m) => m.CriarContaPageModule)
    },
    {
        path: 'criar-endereco',
        loadChildren: () =>
            import('./cadastrar-endereco/criar-endereco.module').then((m) => m.CriarEnderecoPageModule)
    }

];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AuthPageRoutingModule {}
