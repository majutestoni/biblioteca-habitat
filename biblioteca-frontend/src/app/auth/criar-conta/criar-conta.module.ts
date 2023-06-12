import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
    TranslateModule
  ],
  declarations: [CriarContaPage]
})
export class CriarContaPageModule {}
