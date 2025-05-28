import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PantallaCierreOrdenInspeccionComponent } from './pantalla-cierre-orden-inspeccion.component';

describe('PantallaCierreOrdenInspeccionComponent', () => {
  let component: PantallaCierreOrdenInspeccionComponent;
  let fixture: ComponentFixture<PantallaCierreOrdenInspeccionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PantallaCierreOrdenInspeccionComponent]
    });
    fixture = TestBed.createComponent(PantallaCierreOrdenInspeccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
