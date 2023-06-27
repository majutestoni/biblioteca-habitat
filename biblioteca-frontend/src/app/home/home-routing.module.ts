import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './home.page';

const routes: Routes = [
    {
        path: '',
        component: HomePage,
        children: [
            {
                path: '',
                redirectTo: 'filtro',
                pathMatch: 'full'
            },
            {
                path: 'filtro',
                loadChildren: () => import('./filtro/filtro.module').then((m) => m.FiltroPageModule)
            }
        ]
    },

    {
        path: 'admin',
        loadChildren: () => import('./admin/admin.module').then((m) => m.AdminPageModule)
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class HomePageRoutingModule {}
