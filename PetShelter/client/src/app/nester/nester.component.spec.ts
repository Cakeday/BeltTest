import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NesterComponent } from './nester.component';

describe('NesterComponent', () => {
  let component: NesterComponent;
  let fixture: ComponentFixture<NesterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NesterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NesterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
