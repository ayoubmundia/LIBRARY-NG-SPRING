import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProlongerComponent } from './prolonger.component';

describe('ProlongerComponent', () => {
  let component: ProlongerComponent;
  let fixture: ComponentFixture<ProlongerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProlongerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProlongerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
