import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import { NavController } from '@ionic/angular';
import { TranslateService } from '@ngx-translate/core';
import { UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';
import { Genero } from 'src/app/shared/enuns/genero';
import { Perfil } from 'src/app/shared/enuns/perfil';
import { AppErroService } from './app-erro.service';

@Component({
  selector: 'app-criar-conta',
  templateUrl: './criar-conta.page.html',
  styleUrls: ['./criar-conta.page.scss'],
})
export class CriarContaPage implements OnInit {
  public formGroup: FormGroup;

  public perfil = [
    {
      label: this.translateService.instant('furbot.jogador'),
      value: Perfil.JOGADOR,
    },
    {
      label: this.translateService.instant('furbot.professor'),
      value: Perfil.PROFESSOR,
    },
  ];

  public genero = [
    {
      label: this.translateService.instant('furbot.feminino'),
      value: Genero.FEMININO,
    },
    {
      label: this.translateService.instant('furbot.masculino'),
      value: Genero.MASCULINO,
    },
    {
      label: this.translateService.instant('furbot.outros'),
      value: Genero.OUTRO,
    },
  ];

  constructor(
    private formBuilder: FormBuilder,
    private translateService: TranslateService,
    private navController: NavController,
    private usuarioService: UsuarioService,
    private appErroService: AppErroService
  ) { }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      usuario: [
        null,
        Validators.compose([Validators.required, Validators.maxLength(50)]),
      ],
      nome: [
        null,
        Validators.compose([Validators.required, Validators.maxLength(150)])
      ],
      senha: [
        null,
        Validators.compose([Validators.required, Validators.maxLength(18)]),
      ],
      email: [null, Validators.compose([Validators.maxLength(250)])],
      perfil: [null, Validators.compose([Validators.required])],
      genero: [],
      dataNascimento: [],
    });
    this.formGroup.get('nome').valueChanges.subscribe(nome => {
      if (nome) {
        this.formGroup.get('usuario').patchValue(nome.replace(' ', '').replace(' ', '').replace(' ', '').replace(' ', ''));
      }
    });
    this.formGroup.get('perfil').valueChanges.subscribe(perfil => {
      if (perfil === Perfil.PROFESSOR) {
        this.formGroup.get('email').setValidators(Validators.required);
      } else {
        this.formGroup.get('email').setValidators(null);
      }
      this.formGroup.get('email').updateValueAndValidity();
    });
  }

  ionViewWillEnter() {
    this.formGroup.reset();
  }

  public async salvar() {
    try {
      if (this.formGroup.valid) {
        this.formGroup.disable();
        await this.usuarioService
          .insert(this.formGroup.getRawValue())
          .toPromise();
        this.back();
      } else {
        this.formGroup.markAllAsTouched();
      }
    } catch (err) {

      if (!err.error.errors) {
        this.appErroService.exibirErros(err.error.message);
      } else {
        let str = '';
        err.error.errors.forEach(e => {
          str += ' |' + e.message + '|';
        });
        this.appErroService.exibirErros(str);
      }
    }
    this.formGroup.enable();
  }

  public isJogador() {
    return this.formGroup.get('perfil').value === Perfil.JOGADOR;
  }

  public back() {
    this.navController.back();
  }

}
