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
    @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;

    someMethod() {
        this.trigger.openMenu();
    }

    constructor(
        private appStorageService: AppStorageService,
        private activatedRoute: ActivatedRoute,
        private router: Router
    ) {}
    ngOnInit(): void {}

    paraAdministrador() {
        this.router.navigateByUrl('/home/admin');
    }
}
