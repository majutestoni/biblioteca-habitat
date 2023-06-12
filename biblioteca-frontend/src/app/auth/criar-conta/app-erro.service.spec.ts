import { TestBed } from '@angular/core/testing';

import { AppErroService } from './app-erro.service';

describe('AppErroService', () => {
  let service: AppErroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppErroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
