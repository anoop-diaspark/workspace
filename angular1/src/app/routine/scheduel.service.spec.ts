import { TestBed } from '@angular/core/testing';

import { ScheduelService } from './scheduel.service';

describe('ScheduelService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ScheduelService = TestBed.get(ScheduelService);
    expect(service).toBeTruthy();
  });
});
