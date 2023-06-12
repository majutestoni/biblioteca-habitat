import { Component, Input, OnInit } from '@angular/core';
import { AbstractControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-validador',
  templateUrl: './validador.component.html',
  styleUrls: ['./validador.component.scss'],
})
export class ValidadorComponent {

  @Input() control: AbstractControl;
  @Input() errorMessages: any = {};
  @Input() form: FormGroup;

  getErrorMessagesList() {
    if (!this.control || !this.control.touched) { return []; }
    return Object.keys(this.control.errors || {}).map(error => this.errorMessages[error]);
  }

}
