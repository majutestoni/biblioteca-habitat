import { Component, OnInit, Input } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { MetricasService } from 'src/app/core/entidades/metricas/metricas.service';

@Component({
  selector: 'app-escreveu-codigo',
  templateUrl: './escreveu-codigo.component.html',
  styleUrls: ['./escreveu-codigo.component.scss'],
})
export class EscreveuCodigoComponent implements OnInit {

  @Input() turmaSelecionada;

  @Input() alunoSelecionado;

  stackedOptions = {
    plugins: {
      tooltips: {
        mode: 'index',
        intersect: false
      },
      legend: {
        labels: {
          color: '#495057'
        }
      }
    },
    scales: {
      x: {
        stacked: true,
        ticks: {
          color: '#495057'
        },
        grid: {
          color: '#ebedef'
        }
      },
      y: {
        stacked: true,
        ticks: {
          color: '#495057'
        },
        grid: {
          color: '#ebedef'
        }
      }
    }
  };

  stackedData = {};

  isLoading = true;
  translatePhase: string;

  constructor(
    private metricasService: MetricasService,
    private translateService: TranslateService
  ) {
    this.translatePhase = translateService.instant('furbot.fase');
   }

  @Input() set timestamp(timestamp) {
    if (timestamp) {
      this.ngOnInit();
    }
  }

  ngOnInit() {
    const labels = [];
    const usuarios = [];
    const datasets = [];
    const colorCache = {};
    let colorIndex = 0;
    this.isLoading = true;
    const params = {} as any;
    if (this.turmaSelecionada) {
      params.turmaId = this.turmaSelecionada;
    }
    if (this.alunoSelecionado) {
      params.alunoId = this.alunoSelecionado;
    }
    this.metricasService.escreveuCodigo(params).subscribe((metricas: any[]) => {
      metricas.forEach(m => {
        if (!labels.some(l => l === this.translatePhase + ' ' + m.faseAtual)) {
          labels.push(this.translatePhase + ' ' + m.faseAtual);
        }
        if (!usuarios.some(u => u === m.nome)) {
          usuarios.push(m.nome);
          colorCache[m.nome] = this.metricasService.getColors(colorIndex);
          colorIndex++;
          if (colorIndex >= 24) {
            colorIndex = 0;
          }
        }
      });
      usuarios.forEach(u => {
        const values = [];
        labels.forEach(l => {
          const value = metricas.filter(m => this.translatePhase + ' ' + m.faseAtual === l && m.nome === u).map(m => m.valor);
          if (!value?.length) {
            values.push(0);
          } else {
            values.push(value[0]);
          }
        });
        datasets.push({
          type: 'bar',
          label: u,
          backgroundColor: colorCache[u],
          data: values
        });
      });
      this.stackedData = {
        labels,
        datasets
      };
      this.isLoading = false;
    });
  }

}
