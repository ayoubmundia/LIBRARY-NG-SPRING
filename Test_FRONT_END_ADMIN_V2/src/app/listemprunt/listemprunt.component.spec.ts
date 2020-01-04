import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListempruntComponent } from './listemprunt.component';

describe('ListempruntComponent', () => {
  let component: ListempruntComponent;
  let fixture: ComponentFixture<ListempruntComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListempruntComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListempruntComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
