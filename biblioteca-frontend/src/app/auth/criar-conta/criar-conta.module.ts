import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';



import { IonicModule } from '@ionic/angular';

import { CriarContaPageRoutingModule } from './criar-conta-routing.module';

import { CriarContaPage } from './criar-conta.page';
import { SharedModule } from 'src/app/shared/shared.module';
import { TranslateModule } from '@ngx-translate/core';
import { AutoCompleteModule } from 'primeng/autocomplete';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CriarContaPageRoutingModule,
    ReactiveFormsModule,
    SharedModule,
    AutoCompleteModule,
    TranslateModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule
  ],
  declarations: [CriarContaPage]
})
export class CriarContaPageModule {}
