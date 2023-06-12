import { Usuario, UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';
import { Component, OnInit } from '@angular/core';
import { finalize } from 'rxjs/operators';
import { AlunoViewService } from 'src/app/core/entidades/aluno/aluno-view.service';
import { MetricasService } from 'src/app/core/entidades/metricas/metricas.service';
import { TurmaService } from 'src/app/core/entidades/turma/turma.service';
import { Platform } from '@ionic/angular';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.page.html',
  styleUrls: ['./dashboard.page.scss'],
})
export class DashboardPage implements OnInit {

  public timestamp = null;

  public metricas = [];
  public isLoading = true;

  public turmas = [];
  public alunos = [];

  public turmaSelecionada = null;
  public alunoSelecionado = null;

  public professor;
  public isMobile = false;

  private usuarioLogado: Usuario;

  constructor(
    private metricasService: MetricasService,
    private turmaService: TurmaService,
    private alunoService: AlunoViewService,
    private usuarioService: UsuarioService,
    private platform: Platform
  ) { }

  async ngOnInit() {
    this.isLoading = true;
    if (this.platform.is('mobile')) {
      this.isMobile = true;
    }
    this.usuarioLogado = await this.usuarioService.buscarUsuarioLogado().toPromise();
    if (this.usuarioLogado.admin) {
      this.professor = true;
    } else {
      this.alunoSelecionado = this.usuarioLogado.id;
      this.professor = false;
    }
    this.mostrarTurmas();
    this.metricasService.sumarizados()
      .pipe(finalize(() => this.isLoading = false))
      .subscribe((metricas: number[]) => this.metricas = metricas);
  }

  public async mostrarTurmas() {
    let turmas;
    if (!this.professor) {
      turmas = await this.turmaService.
        obterTurmasPorAluno(this.alunoSelecionado).toPromise();
        this.turmas = turmas;
    } else {
      turmas = await this.turmaService.list({
        size: 99999,
        filtro:  `professorId IGUAL ${this.usuarioLogado.id}`
      }).toPromise();
      this.turmas = turmas.conteudo;
    }
  }

  public async onSelectTurma() {
    if (this.turmaSelecionada) {
        const aluno = await this.alunoService.list({
        filtro: `turmaId IGUAL ${this.turmaSelecionada}`,
        size: 9999
      }).toPromise();
      this.alunos = aluno.conteudo;
    }
  }

  public update() {
    this.timestamp = new Date();
    this.onSelectTurma();
  }

  public doUpdate() {
    this.timestamp = new Date();
  }
}
