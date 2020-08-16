import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecentMovieComponent } from './recent-movie.component';

describe('RecentMovieComponent', () => {
  let component: RecentMovieComponent;
  let fixture: ComponentFixture<RecentMovieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecentMovieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecentMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
