import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './home.page';
import { CanActivateAdmin } from './canActiveAdmin';

const routes: Routes = [
    {
        path: '',
        component: HomePage,
        children: [
            {
                path: '',
                loadChildren: () => import('./filtro/filtro.module').then((m) => m.FiltroPageModule)
            },
            {
                path: 'filtro',
                loadChildren: () => import('./filtro/filtro.module').then((m) => m.FiltroPageModule)
            }
        ]
    },

    {
        path: 'admin',
        loadChildren: () => import('./admin/admin.module').then((m) => m.AdminPageModule),
        canActivate: [CanActivateAdmin]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
    providers: [CanActivateAdmin]
})
export class HomePageRoutingModule {}
