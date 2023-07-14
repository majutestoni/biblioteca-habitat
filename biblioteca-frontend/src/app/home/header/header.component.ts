import { Component, ViewChild, OnInit, Input } from '@angular/core';
import { MatMenuTrigger } from '@angular/material/menu';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { AppStorageService } from 'src/app/core/app-storage/app-storage.service';
import { AdminPage } from '../admin/admin.page';

@Component({
    selector: 'app-header',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent implements OnInit {
    @Input() public menus = [];
    public loggedUser = null;
    public isAdmin = false;
    @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;

    someMethod() {
        this.trigger.openMenu();
    }

    constructor(private appStorageService: AppStorageService, private router: Router) {}
    ngOnInit(): void {
        const user = this.appStorageService.get(AppStorageService.KEY_STORAGE.logado);
        user !== null ? (this.isAdmin = user.admin) : (this.isAdmin = false);

        this.router.events.subscribe((val) => {
            if (this.hasSession()) {
                if (val instanceof NavigationEnd) {
                    if (!this.loggedUser) {
                        this.loggedUser = this.appStorageService.get(
                            AppStorageService.KEY_STORAGE.logado
                        );
                    }
                }
            }
        });
    }

    public hasSession() {
        return this.appStorageService.get(AppStorageService.KEY_STORAGE.token);
    }

    paraAdministrador() {
        this.router.navigateByUrl('/home/admin');
    }

    paraUsuario(){
        this.router.navigateByUrl('/home/usuario');
    }

    public logout(){
        this.router.navigate(['/auth']);
        localStorage.clear();
        this.loggedUser = null;
    }

    public produtosDidaticos = [
      { label: 'Livros', router: '' },
      { label: 'Artigos', router: '' },
      { label: 'Videos', router: '' },
      { label: 'TCC', router: '' },
      { label: 'Reportagens', router: '' },
      { label: 'Sites', router: '' },
      { label: 'Cursos', router: '' },
      { label: 'Prod. educacionais', router: '' }
  ];
}
