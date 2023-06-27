import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header.component';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import { FiltroPageModule } from '../filtro/filtro.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [HeaderComponent],
  exports: [HeaderComponent],
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MatMenuModule,
    MatButtonModule,
    FiltroPageModule,
    RouterModule
  ]
})
export class HeaderModule {}