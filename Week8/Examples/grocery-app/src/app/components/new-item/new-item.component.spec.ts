import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { NewItemComponent } from './new-item.component';

describe('NewItemComponent', () => {
  let component: NewItemComponent;
  let fixture: ComponentFixture<NewItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //Describe what the test does in the it function
  it('should display "Input new item" when error is false', ()=> {
    //Put the actual logic of the test inside of the callback
    //Get access to the h2 of this component
    const h2 = fixture.debugElement.query(By.css('h2')).nativeElement;
    //We expect the text/html of this h2 to say "Input an new item"
    expect(h2.innerHTML).toBe("Input a new item");
  });

  //Test an event that occurs on the component
  it('should change the valud of error when input is missing', () => {
    //To start out, the value of error should be false
    expect(component.error.valueOf()).toBeFalsy();

    //Lets cause the submit to happen
    component.submitItem();

    //Must look for changes on the component
    fixture.detectChanges();

    //Now the error value should be updated to false, because the other values on the page were empty
    expect(component.error.valueOf()).toBeTruthy();
  });

  it('should display the message "Please input both values" if error is true', () => {
    component.submitItem();
    fixture.detectChanges();
    const h2 = fixture.debugElement.query(By.css('h2')).nativeElement;
    expect(h2.innerHTML).toBe("Please input both values");
  })

});
