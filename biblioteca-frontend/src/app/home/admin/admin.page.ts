import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatMenuTrigger } from '@angular/material/menu';
import { Router } from '@angular/router';
import { Material, MaterialService } from 'src/app/core/entidades/material/material.service';
import { ModalComponent } from 'src/app/shared/componentes/modal/modal.component';
@Component({
    selector: 'app-admin',
    templateUrl: 'admin.page.html',
    styleUrls: ['admin.page.scss']
})
export class AdminPage implements OnInit {
    constructor(private router: Router, private materialService: MaterialService, public dialog: MatDialog) {}

    public materiais: Material[];
    public pageSize: number;

    displayedColumns: string[] = ['id', 'titulo', 'colaborador', 'acao'];

    @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;

    someMethod() {
        this.trigger.openMenu();
    }
    ngOnInit(): void {
        this.materialService.paraAprovar().subscribe((e) => {
            this.materiais = e.conteudo;
            this.pageSize = e.totalPaginas
        });
    }

    openDialog(id: string): void {
        this.materialService.getById(id).subscribe(e => {
            const dialogRef = this.dialog.open(ModalComponent, {
                data: {material: e},
              });
        })

    
      
    }
    

    public menuAdmin = [
        { label: 'Materias em triagem', action: this.gotToAdmin.bind(this) },
        { label: 'Administradores', action: this.gotToNovo.bind(this) }
    ];

    gotToAdmin() {
        this.router.navigateByUrl('/home/admin');
    }
    gotToNovo() {
        this.router.navigateByUrl('/home/admin/novo');
    }

    aprovar(id: string){
        console.log(id)
    }

    reprovar(id: string){
        console.log(id)
    }
}
