import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ErroDeExecucaoComponent } from './erro-de-execucao.component';

describe('ErroDeExecucaoComponent', () => {
  let component: ErroDeExecucaoComponent;
  let fixture: ComponentFixture<ErroDeExecucaoComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ErroDeExecucaoComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ErroDeExecucaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
