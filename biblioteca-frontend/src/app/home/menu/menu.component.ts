import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatMenuTrigger } from '@angular/material/menu';
import { Router } from '@angular/router';

@Component({
    selector: 'app-menu',
    templateUrl: 'menu.component.html',
    styleUrls: ['menu.component.scss']
})
export class MenuComponent implements OnInit {
    @Input() public menus = [];
    @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;
    @ViewChild('sidenav') sidenav;

    reason = '';

    close(reason: string) {
        this.reason = reason;
        this.sidenav.close();
    }
    someMethod() {}

    constructor(private router: Router) {}

    ngOnInit(): void {}
}
