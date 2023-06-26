import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';
import { FiltroPage } from './filtro.page';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { FiltroPageRoutingModule } from './filtro-routing.module';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        MatFormFieldModule,
        MatInputModule,
        MatDatepickerModule,
        FiltroPageRoutingModule
    ],
    declarations: [FiltroPage]
})
export class FiltroPageModule {}
