import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayShowsComponent } from './display-shows.component';

describe('DisplayShowsComponent', () => {
  let component: DisplayShowsComponent;
  let fixture: ComponentFixture<DisplayShowsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayShowsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayShowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
