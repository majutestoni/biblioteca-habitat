import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Material } from 'src/app/core/entidades/material/material.service';

@Component({
    selector: 'app-modal',
    templateUrl: './modal.component.html',
    styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {
    public fg: FormGroup;

    constructor(
        public dialogRef: MatDialogRef<ModalComponent>,
        private fb: FormBuilder,
        @Inject(MAT_DIALOG_DATA) public data: DialogData
    ) {}
    ngOnInit(): void {
        this.fg = this.fb.group({
            id: [''],
            colaborador: [''],
            titulo: [''],
            ano: [''],
            descricao: [''],
            idioma: [''],
            tipo: [''],
            link: ['']
        });

        this.setValues();
    }
    onNoClick(): void {
        this.dialogRef.close();
    }

    private setValues() {

      const material = this.data.material

        this.fg.setValue({
          id: material.id,
          colaborador: material.colaborador,
          titulo: material.titulo,
          ano: material.ano,
          descricao: material.descricao,
          idioma: material.idioma,
          tipo: material.tipo,
          link: material.link
        });
    }
}

export interface DialogData {
    material: Material;
}
