import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from 'src/app/core/entidades/usuario/usuario.service';
const ELEMENT_DATA = [
    { id: 1, titulo: 'Hydrogen', publicador: 1.0079, acao: 'H' },
    { id: 2, titulo: 'Helium', publicador: 4.0026, acao: 'He' },
    { id: 3, titulo: 'Lithium', publicador: 6.941, acao: 'Li' },
    { id: 4, titulo: 'Beryllium', publicador: 9.0122, acao: 'Be' },
    { id: 5, titulo: 'Boron', publicador: 10.811, acao: 'B' },
    { id: 6, titulo: 'Carbon', publicador: 12.0107, acao: 'C' },
    { id: 7, titulo: 'Nitrogen', publicador: 14.0067, acao: 'N' },
    { id: 8, titulo: 'Oxygen', publicador: 15.9994, acao: 'O' },
    { id: 9, titulo: 'Fluorine', publicador: 18.9984, acao: 'F' },
    { id: 10, titulo: 'Neon', publicador: 20.1797, acao: 'Ne' }
];
@Component({
    selector: 'app-novo',
    templateUrl: 'novo.page.html',
    styleUrls: ['novo.page.scss']
})
export class NovoAdminPage implements OnInit {
    form: FormGroup;
    formEndereco: FormGroup;

    dataSource = ELEMENT_DATA;
    displayedColumns: string[] = ['id', 'titulo', 'publicador', 'acao'];

    constructor(private fb: FormBuilder, private service: UsuarioService) {}

    ngOnInit(): void {
        this.createForm();
    }

    createForm() {
        this.form = this.fb.group({
            usuario: [null, Validators.compose([Validators.required, Validators.maxLength(50)])]
        });
    }

    salvar() {
        const formValue = this.form.value;
        this.service.buscarUsuario(formValue.usuario).subscribe(e => console.log(e))
    }
}
