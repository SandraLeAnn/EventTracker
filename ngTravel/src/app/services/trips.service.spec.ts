import { TestBed } from '@angular/core/testing';

import { TripsService } from './trips.service';

describe('TripService', () => {
  let service: TripsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TripsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
