import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacturesDetailsComponent } from './factures-details.component';

describe('FacturesDetailsComponent', () => {
  let component: FacturesDetailsComponent;
  let fixture: ComponentFixture<FacturesDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacturesDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FacturesDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
