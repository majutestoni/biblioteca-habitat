import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavController } from '@ionic/angular';
import { TranslateService } from '@ngx-translate/core';
import { Endereco, UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';
import { EnderecoService } from 'src/app/core/entidades/endereco/endereco.service';
import { MessageService } from 'primeng/api';

@Component({
    selector: 'app-criar-conta',
    templateUrl: './criar-endereco.page.html',
    styleUrls: ['./criar-endereco.page.scss'],
    providers: [MessageService],
})
export class CriarEnderecoPage implements OnInit {
    public formEndereco: FormGroup;

    public enderecoOptions: Endereco[] = [];
    public optionsEstados = [];
    public optionsCidade = [];
    public optionsPais = [];

    constructor(
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private navController: NavController,
        private enderecoService: EnderecoService,
        private messageService: MessageService
    ) {}

    ngOnInit() {
        this.createForm();
    }

    ionViewWillEnter() {
        this.formEndereco.reset();
    }

    public salvar() {
        if (this.formEndereco.valid) {
            let formValue = this.formEndereco.value;
            delete formValue.cep;
            this.enderecoService.cadastrar(formValue).subscribe(
                (e) => { this.messageService.add({severity:'success', summary:'Sucesso', detail:'Endereço criado!'})
            this.navController.navigateRoot('/auth/criar-conta')
            },
                (err) => {
                    this.messageService.add({severity:'error', summary:'Error', detail:err.error.message})
                }
            );
        } else {
            this.formEndereco.markAllAsTouched()
        }
    }

    public back() {
        this.navController.back();
    }

    private createForm(): void {
        this.formEndereco = this.formBuilder.group({
            cep: [null, Validators.compose([Validators.maxLength(250)])],
            cidade: [null, Validators.compose([Validators.maxLength(250), Validators.required])],
            estadoOuProvincia: [null, Validators.compose([Validators.maxLength(250), Validators.required])],
            pais: [null, Validators.compose([Validators.maxLength(250), Validators.required])]
        });
    }

    consultaCep() {
        const valor = this.formEndereco.get('cep').value;
        if (valor !== null) {
            this.enderecoService.buscar(valor).subscribe(
                (dados) => {
                    this.populaForm(dados);
                },
                (err) => {}
            );
        }
    }


    populaForm(dados) {
        this.formEndereco.setValue({
            cep: dados.cep,
            cidade: dados.localidade,
            estadoOuProvincia: dados.uf,
            pais: 'Brasil'
        });
    }
}
