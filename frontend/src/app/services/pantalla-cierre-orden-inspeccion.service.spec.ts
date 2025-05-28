import { TestBed } from '@angular/core/testing';

import { PantallaCierreOrdenInspeccionService } from './pantalla-cierre-orden-inspeccion.service';

describe('PantallaCierreOrdenInspeccionService', () => {
  let service: PantallaCierreOrdenInspeccionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PantallaCierreOrdenInspeccionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
