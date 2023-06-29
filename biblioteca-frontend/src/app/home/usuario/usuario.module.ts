import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioPageRoutingModule } from './usuario-routing.module';
import { UsuarioComponent } from './usuario.component';
import { IonicModule } from '@ionic/angular';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { SharedModule } from 'primeng/api';
import { HeaderModule } from '../header/header.module';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
    declarations: [UsuarioComponent],
    imports: [
        CommonModule,
        UsuarioPageRoutingModule,
        IonicModule,
        ReactiveFormsModule,
        FormsModule,
        TranslateModule,
        SharedModule,
        HeaderModule,
        MatFormFieldModule,
        MatInputModule,
        MatIconModule,
        MatButtonModule
        
    ]
})
export class UsuarioModule {}
