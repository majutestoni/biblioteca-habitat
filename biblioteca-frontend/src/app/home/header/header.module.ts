import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header.component';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import { FiltroPageModule } from '../filtro/filtro.module';
import { RouterModule } from '@angular/router';
import { MenuModule } from "../menu/menu.module";
import {MatIconModule} from '@angular/material/icon';

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
        RouterModule,
        MenuModule,
        MatIconModule
    ]
})
export class HeaderModule {}
