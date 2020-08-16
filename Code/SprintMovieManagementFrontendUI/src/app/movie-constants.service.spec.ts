import { TestBed } from '@angular/core/testing';

import { MovieConstantsService } from './movie-constants.service';

describe('MovieConstantsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MovieConstantsService = TestBed.get(MovieConstantsService);
    expect(service).toBeTruthy();
  });
});
