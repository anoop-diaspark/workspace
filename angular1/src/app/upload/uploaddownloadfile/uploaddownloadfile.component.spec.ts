import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploaddownloadfileComponent } from './uploaddownloadfile.component';

describe('UploaddownloadfileComponent', () => {
  let component: UploaddownloadfileComponent;
  let fixture: ComponentFixture<UploaddownloadfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploaddownloadfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploaddownloadfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
