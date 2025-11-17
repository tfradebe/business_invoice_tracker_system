import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientGet } from './client-get';

describe('ClientGet', () => {
  let component: ClientGet;
  let fixture: ComponentFixture<ClientGet>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClientGet]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientGet);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
