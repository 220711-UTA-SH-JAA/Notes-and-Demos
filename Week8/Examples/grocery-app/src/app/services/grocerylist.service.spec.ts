import { TestBed } from '@angular/core/testing';

import { GrocerylistService } from './grocerylist.service';

describe('GrocerylistService', () => {
  let service: GrocerylistService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GrocerylistService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
