import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { InputTextModule } from 'primeng/inputtext';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { DropdownModule } from 'primeng/dropdown';
import { CalendarModule } from 'primeng/calendar';
import { ValidadorComponent } from './componentes/validador/validador.component';
import { ListaGenericaComponent } from './componentes/lista-generica/lista-generica.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';

import { MatPaginatorModule } from '@angular/material/paginator';

@NgModule({
  declarations: [
    ValidadorComponent,
    ListaGenericaComponent
  ],
  imports: [
    CommonModule,
    TranslateModule,
    InputTextModule,
    DropdownModule,
    CalendarModule,
    ReactiveFormsModule,
    FormsModule,
    IonicModule,
    MatPaginatorModule
  ],
  exports: [
    InputTextModule,
    AutoCompleteModule,
    DropdownModule,
    CalendarModule,
    ValidadorComponent,
    TranslateModule,
    ListaGenericaComponent
  ]
})
export class SharedModule { }
