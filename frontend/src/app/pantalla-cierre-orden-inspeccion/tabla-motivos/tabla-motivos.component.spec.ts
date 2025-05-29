import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaMotivosComponent } from './tabla-motivos.component';

describe('TablaMotivosComponent', () => {
  let component: TablaMotivosComponent;
  let fixture: ComponentFixture<TablaMotivosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaMotivosComponent]
    });
    fixture = TestBed.createComponent(TablaMotivosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
