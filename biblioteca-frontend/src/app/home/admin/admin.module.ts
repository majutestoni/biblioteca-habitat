import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { AdminPageRoutingModule } from './admin-routing.module';
import { AdminPage } from './admin.page';
import { MatTableModule } from '@angular/material/table';
import { MenuModule } from '../menu/menu.module';
import { NovoAdminPage } from './novo/novo.page';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        MatFormFieldModule,
        MatInputModule,
        MatDatepickerModule,
        AdminPageRoutingModule,
        MatTableModule,
        MenuModule
    ],
    declarations: [AdminPage, NovoAdminPage]
})
export class AdminPageModule {}
