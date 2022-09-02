import { ComponentFixture, TestBed } from '@angular/core/testing';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import { BehaviorSubject } from 'rxjs';

import { GroceryListComponent } from './grocery-list.component';
import {GrocerylistService} from '../../services/grocerylist.service';
import {NewItemComponent} from '../new-item/new-item.component';
import {User} from '../../interfaces/User';
import { By } from '@angular/platform-browser';

//When we test, similar to Java, we do not want to actually make calls to the api, so we must mock the
//classes that make those calls, in our case the service class
class MockGroceryListService {
  //This has to have the same methods and properties as our real service
  subject = new BehaviorSubject([
    {
      listId: 0,
      listName: '',
      items: []
    }
  ]);

  //mock our loadLists method
  loadLists(user:User){
    return {
      listId: 1,
      listName: 'test-list',
      items: []
    }
  }

  //mock our addItem method
  addItem(listName:string, item:string){
    return {
      listId: 1,
      listName: 'test-list',
      items:[{
        itemId: 1, 
        itemName: item,
        itemPrice: 1.99
      }]
    }
  }
}

describe('GroceryListComponent', () => {
  let component: GroceryListComponent;
  let fixture: ComponentFixture<GroceryListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GroceryListComponent, NewItemComponent ],
      imports: [HttpClientTestingModule],
      providers: [{provide: GrocerylistService, useClass:MockGroceryListService}]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GroceryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call addItem() of the grocerylistservice when it receives a new item from the new-item component', () => {
    //We must first get an instance of our grocerylist service, so we can spy on it
    let service = fixture.debugElement.injector.get(GrocerylistService);

    //We need to setup a spy, to watch and make sure the correct method is called on the action
    let serviceSpy = spyOn(service, 'addItem').and.callThrough();

    //We need an instance of the new item component to send the event/object
    const newItem = fixture.debugElement.query(By.directive(NewItemComponent));

    //Triggers our custom event, emitting the event object with the item, which will then trigger our grocerylist
    //to call the service
    newItem.triggerEventHandler('onAddItem', {
      itemId: 1,
      itemName: 'test',
      itemPrice: 9.99
    });

    fixture.detectChanges();
    expect(serviceSpy).toHaveBeenCalled();
  })

});
