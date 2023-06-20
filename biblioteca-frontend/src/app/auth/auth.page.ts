import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, RouterEvent } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AppStorageService } from '../core/app-storage/app-storage.service';
import { Usuario, UsuarioService } from '../core/entidades/usuario/usuario.service';
import { AppErroService } from './criar-conta/app-erro.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.page.html',
  styleUrls: ['./auth.page.scss'],
})
export class AuthPage implements OnInit {

  public formGroup: FormGroup;
  public isLoading = false;

  constructor(
    private formBuilder: FormBuilder,
    private translateService: TranslateService,
    private usuarioService: UsuarioService,
    private appStorageService: AppStorageService,
    private router: Router,
    private appErroService: AppErroService,
    private route: ActivatedRoute
  ) {
    this.isLogged();
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      usuario: [null, Validators.compose([Validators.required])],
      senha: [null, Validators.compose([Validators.required])]
    });
  }

  public alterarIdioma(event) {
    const lang = event.detail.value;

    this.appStorageService.setLang(lang);
    this.translateService.use(lang);

    if (lang === 'pt') {
      localStorage.removeItem('en');
    } else {
      localStorage.removeItem('pt');
    }
    this.reload();
  }

  public async acessar() {
    this.isLoading = true;
    try {
      if (this.formGroup.valid) {
        const usuario = this.formGroup.getRawValue();
        const token = await this.usuarioService.login(usuario.usuario, usuario.senha).toPromise();
        this.appStorageService.set(AppStorageService.KEY_STORAGE.token, token);
        const usuarioLogado: Usuario = await this.usuarioService.buscarUsuarioLogado().toPromise();

        this.appStorageService.set(AppStorageService.KEY_STORAGE.logado, usuarioLogado);
        if (usuarioLogado.admin) {
          this.router.navigate(['/home']);// this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/home']);  // this.router.navigate(['/colab']);
        }
      } else {
        this.formGroup.markAllAsTouched();
      }
    } catch (err) {
      this.appErroService.exibirErros(err.error.message);
    }
    this.isLoading = false;
  }

  private async isLogged() {
    const usuario = this.appStorageService.get(AppStorageService.KEY_STORAGE.logado);

    if (!usuario) {
      this.translateService.use('pt');
      if (this.appStorageService.getLang('en')) {
        this.translateService.use('en');
      }
    }
  }

  private reload() {
    window.location.reload();
  }
}


