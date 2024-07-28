import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyComponentZiadComponent } from './my-component-ziad.component';

describe('MyComponentZiadComponent', () => {
  let component: MyComponentZiadComponent;
  let fixture: ComponentFixture<MyComponentZiadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MyComponentZiadComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyComponentZiadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
