import { Component, ViewChild, OnInit } from '@angular/core';
import { MatMenuTrigger } from '@angular/material/menu';
import { ActivatedRoute, Router } from '@angular/router';
import { AppStorageService } from 'src/app/core/app-storage/app-storage.service';
import { AdminPage } from '../admin/admin.page';

@Component({
    selector: 'app-header',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent implements OnInit {
    public isAdmin = false;
    @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;

    someMethod() {
        this.trigger.openMenu();
    }

    constructor(private appStorageService: AppStorageService, private router: Router) {}
    ngOnInit(): void {
        const user = this.appStorageService.get(AppStorageService.KEY_STORAGE.logado);
        this.isAdmin = user.admin;
    }

    paraAdministrador() {
        this.router.navigateByUrl('/home/admin');
    }
}
