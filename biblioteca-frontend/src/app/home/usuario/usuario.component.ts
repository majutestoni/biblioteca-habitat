import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Platform } from '@ionic/angular';
import { UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss'],
})
export class UsuarioComponent implements OnInit {
  public isMobile = false;
  public formGroup: FormGroup;

  constructor(private platform: Platform, private formBuilder: FormBuilder, private activatedRoute: ActivatedRoute, private usuarioService: UsuarioService) { }

  ngOnInit() {
    if (this.platform.is('mobile')) {
      this.isMobile = true;
    }
    this.formGroup = this.formBuilder.group({
      id: [],
      usuario: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
      nome: [null, Validators.compose([Validators.required, Validators.maxLength(150)])],
      senha: [null, Validators.compose([Validators.required, Validators.maxLength(18)])],
      email: [null, Validators.compose([Validators.maxLength(250), Validators.required])],
      instituicao: [null, Validators.compose([Validators.maxLength(250)])],
      fone: [null, Validators.compose([Validators.maxLength(250)])],
      clube: [null, Validators.compose([Validators.maxLength(250)])],
      endereco: [null, Validators.compose([Validators.maxLength(250)])]
    });
  }

  ionViewWillEnter() {
    if (this.activatedRoute.snapshot.data.entity) {
      const entity = this.activatedRoute.snapshot.data.entity;
      
      entity.senha = null;
      console.log(entity)
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
      } else {
        this.formGroup.markAllAsTouched();
      }
    } catch (err) {
    }
    this.formGroup.enable();
  }


}
