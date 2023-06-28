import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
const ELEMENT_DATA = [
    {id: 1, titulo: 'Hydrogen', publicador: 1.0079, acao: 'H'},
    {id: 2, titulo: 'Helium', publicador: 4.0026, acao: 'He'},
    {id: 3, titulo: 'Lithium', publicador: 6.941, acao: 'Li'},
    {id: 4, titulo: 'Beryllium', publicador: 9.0122, acao: 'Be'},
    {id: 5, titulo: 'Boron', publicador: 10.811, acao: 'B'},
    {id: 6, titulo: 'Carbon', publicador: 12.0107, acao: 'C'},
    {id: 7, titulo: 'Nitrogen', publicador: 14.0067, acao: 'N'},
    {id: 8, titulo: 'Oxygen', publicador: 15.9994, acao: 'O'},
    {id: 9, titulo: 'Fluorine', publicador: 18.9984, acao: 'F'},
    {id: 10, titulo: 'Neon', publicador: 20.1797, acao: 'Ne'},
  ];
@Component({
    selector: 'app-admin',
    templateUrl: 'admin.page.html',
    styleUrls: ['admin.page.scss']
})
export class AdminPage implements OnInit {
    constructor(private router:Router) {}

    
    dataSource = ELEMENT_DATA;
    displayedColumns: string[] = ['id', 'titulo', 'publicador', 'acao'];
    ngOnInit(): void {
    }

    public menuAdmin = [
        { label: 'Materias em triagem', action: this.gotToAdmin.bind(this) },
        { label: 'Adicionar admin', action: this.gotToNovo.bind(this) },
        { label: 'Administradores', action: this.gotToNovo.bind(this) }
    ];

    gotToAdmin() {
        this.router.navigateByUrl('/home/admin');
    }
    gotToNovo() {
        this.router.navigateByUrl('/home/admin/novo');
    }

}
