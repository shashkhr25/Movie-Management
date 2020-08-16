import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayScreensComponent } from './display-screens.component';

describe('DisplayScreensComponent', () => {
  let component: DisplayScreensComponent;
  let fixture: ComponentFixture<DisplayScreensComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayScreensComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayScreensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
