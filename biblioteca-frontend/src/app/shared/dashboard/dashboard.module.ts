import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { DashboardPageRoutingModule } from './dashboard-routing.module';

import { DashboardPage } from './dashboard.page';
import { SharedModule } from 'src/app/shared/shared.module';
import { GraficoTempoJogoComponent } from './grafico-tempo-jogo/grafico-tempo-jogo.component';
import { ChartModule } from 'primeng/chart';
import { ReinicioFaseComponent } from './reinicio-fase/reinicio-fase.component';
import { ClicouEmExecutarComponent } from './clicou-em-executar/clicou-em-executar.component';
import { ErroDeCompilacaoComponent } from './erro-de-compilacao/erro-de-compilacao.component';
import { ErroDeExecucaoComponent } from './erro-de-execucao/erro-de-execucao.component';
import { EscreveuCodigoComponent } from './escreveu-codigo/escreveu-codigo.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    DashboardPageRoutingModule,
    SharedModule,
    ChartModule
  ],
  declarations: [
    DashboardPage,
    GraficoTempoJogoComponent,
    ReinicioFaseComponent,
    ClicouEmExecutarComponent,
    ErroDeCompilacaoComponent,
    ErroDeExecucaoComponent,
    EscreveuCodigoComponent
  ]
})
export class DashboardPageModule {}
