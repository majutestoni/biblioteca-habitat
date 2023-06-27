import { Component, OnInit, ViewChild } from '@angular/core';
import { MatMenuTrigger } from '@angular/material/menu';
import { Router } from '@angular/router';

@Component({
    selector: 'app-menu',
    templateUrl: 'menu.component.html',
    styleUrls: ['menu.component.scss']
})
export class MenuComponent implements OnInit {
    public menus = [];
    @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;

    someMethod() {
        this.trigger.openMenu();
    }

    constructor(private router: Router) {}

    ngOnInit(): void {
        const teste = this.router.url.split('/');

        if (teste[2] === 'admin') {
            this.menus = this.menuAdmin;
        } else {
            this.menus = this.produtosDidaticos;
        }
    }


    private produtosDidaticos = [
        { label: 'Livros', router: '' },
        { label: 'Artigos', router: '' },
        { label: 'Videos', router: '' },
        { label: 'TCC', router: '' },
        { label: 'Reportagens', router: '' },
        { label: 'Sites', router: '' },
        { label: 'Cursos', router: '' },
        { label: 'Produtos educacionais', router: '' }
    ];

    private menuAdmin = [
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
