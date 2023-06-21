import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {ToastModule} from 'primeng/toast';



import { IonicModule } from '@ionic/angular';


import { CriarEnderecoPage } from './criar-endereco.page';
import { SharedModule } from 'src/app/shared/shared.module';
import { TranslateModule } from '@ngx-translate/core';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { CriarEnderecoPageRoutingModule } from './criar-endereco-routing.module';

@NgModule({
  imports: [
    CriarEnderecoPageRoutingModule, 
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
    SharedModule,
    AutoCompleteModule,
    TranslateModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    ToastModule
  ],
  declarations: [CriarEnderecoPage]
})
export class CriarEnderecoPageModule {}
