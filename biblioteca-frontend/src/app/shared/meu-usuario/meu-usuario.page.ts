import { TranslateService } from '@ngx-translate/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AppErroService } from 'src/app/auth/criar-conta/app-erro.service';
import { UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';
import { Platform } from '@ionic/angular';

@Component({
  selector: 'app-meu-usuario',
  templateUrl: './meu-usuario.page.html',
  styleUrls: ['./meu-usuario.page.scss'],
})
export class MeuUsuarioPage implements OnInit {

  public isMobile = false;

  formGroup: FormGroup;
  disabledValue = false;
  public generos = [
    { name: this.translateService.instant('furbot.masculino'),
      valor: 'MASCULINO'
    },
    {
      name: this.translateService.instant('furbot.feminino'),
      valor: 'FEMININO'
    },
    {
      name: this.translateService.instant('furbot.outros'),
      valor: 'OUTRO'
    }
  ];

  constructor(
    private formBuilder: FormBuilder,
    private usuarioService: UsuarioService,
    private appErroService: AppErroService,
    private activatedRoute: ActivatedRoute,
    private translateService: TranslateService,
    private platform: Platform
  ) { }

  ngOnInit() {
    if (this.platform.is('mobile')) {
      this.isMobile = true;
    }
    this.formGroup = this.formBuilder.group({
      id: [],
      usuario: [
        null,
        Validators.compose([Validators.required, Validators.maxLength(50)])
      ],
      nome: [
        null,
        Validators.compose([Validators.required, Validators.maxLength(150)])
      ],
      senha: [
        null,
        Validators.compose([Validators.maxLength(18)]),
      ],
      email: [null, Validators.compose([Validators.maxLength(250)])],
      perfil: [null, Validators.compose([Validators.required])],
      genero: [null, Validators.compose([Validators.required])],
      dataNascimento: [null, Validators.compose([Validators.required])],
    });
  }

  ionViewWillEnter() {
    if (this.activatedRoute.snapshot.data.entity) {
      const entity = this.activatedRoute.snapshot.data.entity;
      entity.senha = null;
      entity.dataNascimento = new Date(entity.dataNascimento);
      entity.generos = this.generos.find(t => t.valor === entity.generos);
      this.formGroup.patchValue(this.activatedRoute.snapshot.data.entity);
      this.formGroup.get('usuario').disable();
      this.formGroup.get('nome').disable();
      this.formGroup.get('email').disable();
    }
  }

  public async update() {
    try {
      if (this.formGroup.valid) {
        const form = this.formGroup.getRawValue();
        if (form.id === 'new') {
          delete form.id;
        }
        form.usuarioId = form.usuario.id;
        this.formGroup.disable();
        if (form.id) {
          await this.usuarioService.update(form.id, form).toPromise();
        }
        this.appErroService.exibirMensagem('Salvo com sucesso');
      } else {
        this.formGroup.markAllAsTouched();
      }
    } catch (err) {
      await this.appErroService.exibirErros(err?.error.message);
    }
    this.formGroup.enable();
  }
}
