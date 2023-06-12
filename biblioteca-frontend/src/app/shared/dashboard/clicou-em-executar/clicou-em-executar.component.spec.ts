import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ClicouEmExecutarComponent } from './clicou-em-executar.component';

describe('ClicouEmExecutarComponent', () => {
  let component: ClicouEmExecutarComponent;
  let fixture: ComponentFixture<ClicouEmExecutarComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ClicouEmExecutarComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ClicouEmExecutarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
