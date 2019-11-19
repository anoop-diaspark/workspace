import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScehduelComponent } from './scehduel.component';

describe('ScehduelComponent', () => {
  let component: ScehduelComponent;
  let fixture: ComponentFixture<ScehduelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScehduelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScehduelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
