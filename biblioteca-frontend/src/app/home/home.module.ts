import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';
import { HomePage } from './home.page';

import { HomePageRoutingModule } from './home-routing.module';
import { HeaderModule } from './header/header.module';
import { MenuModule } from './menu/menu.module';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input'
import {MatDatepickerModule} from '@angular/material/datepicker';
import { FiltroPageModule } from './filtro/filtro.module';
import { AdminPageModule } from './admin/admin.module';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomePageRoutingModule,
    HeaderModule,
    MenuModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    FiltroPageModule,
    AdminPageModule
    
  ],
  declarations: [HomePage]
})
export class HomePageModule {}