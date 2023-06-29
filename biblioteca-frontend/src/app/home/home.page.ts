import { Component, OnInit } from '@angular/core';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { MatDatepicker } from '@angular/material/datepicker';
import { Router } from '@angular/router';
import { Moment } from 'moment';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss']
})
export class HomePage implements OnInit {
    constructor() {}
    ngOnInit(): void {}

    setMonthAndYear(normalizedMonthAndYear: Moment, datepicker: MatDatepicker<Moment>) {}

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
