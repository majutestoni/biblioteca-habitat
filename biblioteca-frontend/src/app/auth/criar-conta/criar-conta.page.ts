import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavController } from '@ionic/angular';
import { TranslateService } from '@ngx-translate/core';
import { Endereco, UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';
import { Perfil } from 'src/app/shared/enuns/perfil';
import { AppErroService } from './app-erro.service';
import { EnderecoService } from 'src/app/core/entidades/endereco/endereco.service';

@Component({
    selector: 'app-criar-conta',
    templateUrl: './criar-conta.page.html',
    styleUrls: ['./criar-conta.page.scss']
})
export class CriarContaPage implements OnInit {
    public formGroup: FormGroup;
    public formEndereco: FormGroup;
    public showSenha = false;

    public enderecoOptions: Endereco[] = [];
    public optionsEstados = [];
    public optionsCidade = [];
    public optionsPais = [];

    constructor(
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private navController: NavController,
        private usuarioService: UsuarioService,
        private appErroService: AppErroService,
        private enderecoService: EnderecoService,
    ) {}

    ngOnInit() {
        this.createForm();

        this.formGroup.get('nome').valueChanges.subscribe((nome) => {
            if (nome) {
                this.formGroup
                    .get('usuario')
                    .patchValue(
                        nome.replace(' ', '').replace(' ', '').replace(' ', '').replace(' ', '')
                    );
            }
        });
        this.enderecoService.getAll().subscribe((e) => {
            this.optionsPais = e;

            this.optionsPais = this.optionsPais.map((c) => {
                return {
                    value: c,
                    label: c
                };
            });

            this.optionsPais = this.optionsPais.filter(
                (objeto, index, array) => array.findIndex((o) => o.value === objeto.value) === index
            );
            const temp = this.optionsPais[0];
            this.optionsPais[0] = { value: '-', label: '-' };
            this.optionsPais.push(temp);
        });
    }

    ionViewWillEnter() {
        this.formGroup.reset();
        this.formEndereco.reset();
    }

    public async salvar() {
        try {
            if (this.formGroup.valid && this.formEndereco.valid) {
                this.formGroup.disable();
                this.formEndereco.disable();
                await this.usuarioService.insert(this.formGroup.getRawValue()).toPromise();
                this.back();
            } else {
                this.formGroup.markAllAsTouched();
            }
        } catch (err) {
            if (!err.error.errors) {
                this.appErroService.exibirErros(err.error.message);
            } else {
                let str = '';
                err.error.errors.forEach((e) => {
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

    private createForm(): void {
        this.formGroup = this.formBuilder.group({
            usuario: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
            nome: [null, Validators.compose([Validators.required, Validators.maxLength(150)])],
            senha: [null, Validators.compose([Validators.required, Validators.maxLength(18)])],
            email: [null, Validators.compose([Validators.maxLength(250), Validators.required])],
            intituicao: [null, Validators.compose([Validators.maxLength(250)])],
            fone: [null, Validators.compose([Validators.maxLength(250)])],
            clube: [null, Validators.compose([Validators.maxLength(250)])],
            endereco: [null, Validators.compose([Validators.maxLength(250)])]
        });

        this.formEndereco = this.formBuilder.group({
            cep: [null, Validators.compose([Validators.maxLength(250)])],
            cidade: [null, Validators.compose([Validators.maxLength(250), Validators.required])],
            estado: [null, Validators.compose([Validators.maxLength(250), Validators.required])],
            pais: [null, Validators.compose([Validators.maxLength(250), Validators.required])]
        });
    }

    // não está sendo usado
    consultaCep() {
        const valor = this.formEndereco.get('cep').value;
        if (valor !== null) {
            this.enderecoService.buscar(valor).subscribe(
                (dados) => {
                    this.populaForm(dados, this.formEndereco);
                },
                (err) => {}
            );
        }
    }

    // não está sendo usado
    populaForm(dados, form) {
        form.setValue({
            cep: dados.cep,
            cidade: dados.localidade,
            estado: dados.uf,
            pais: 'Brasil'
        });
    }

    defineEstado() {
        const pais = this.formEndereco.get('pais').value;

        this.enderecoService.findByPais(pais).subscribe((e) => {
            this.enderecoOptions = e;
            this.optionsEstados = this.enderecoOptions.map((c) => {
                return {
                    value: c.estadoOuProvincia,
                    label: c.estadoOuProvincia,
                    id: c.id
                };
            });

            this.optionsEstados = this.optionsEstados.filter(
                (objeto, index, array) => array.findIndex((o) => o.value === objeto.value) === index
            );

            const temp = this.optionsEstados[0];
            this.optionsEstados[0] = { value: '-', label: '-' };
            this.optionsEstados.push(temp);
        });
    }

    defineCidade() {
        const estado = this.formEndereco.get('estado').value;

        this.enderecoService.findByEstado(estado).subscribe((e) => {
            this.enderecoOptions = e;
            this.optionsCidade = this.enderecoOptions.map((c) => {
                return {
                    value: c.cidade,
                    label: c.cidade,
                    id: c.id
                };
            });

            this.optionsCidade = this.optionsCidade.filter(
                (objeto, index, array) => array.findIndex((o) => o.value === objeto.value) === index
            );

            const temp = this.optionsCidade[0];
            this.optionsCidade[0] = { value: '-', label: '-' };
            this.optionsCidade.push(temp);
        });
    }

    defineEndereco() {
        let cidade = '';
        this.optionsCidade.forEach((a) => {
            if (a.value == this.formEndereco.get('cidade').value) {
                cidade = a.id;
            }
        });

        this.formGroup.get('endereco').setValue(cidade);
    }

}
