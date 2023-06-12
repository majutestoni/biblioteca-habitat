import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ErroDeCompilacaoComponent } from './erro-de-compilacao.component';

describe('ErroDeCompilacaoComponent', () => {
  let component: ErroDeCompilacaoComponent;
  let fixture: ComponentFixture<ErroDeCompilacaoComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ErroDeCompilacaoComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ErroDeCompilacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
