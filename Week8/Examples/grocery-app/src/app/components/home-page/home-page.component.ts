import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { GroceryList } from 'src/app/interfaces/GroceryList';
import { Item } from 'src/app/interfaces/Item';
import { User } from 'src/app/interfaces/User';
import { GrocerylistService } from 'src/app/services/grocerylist.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'home',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  //If we want to store some data in our component, we simply just create a variable
  user:User;
  lists:Observable<GroceryList[]> = new Observable<GroceryList[]>();

  constructor(private userService:UserService, private groceryListService:GrocerylistService) {
    this.user = this.userService.user;
    this.lists = this.groceryListService.subject;
  }

  //Whenever we intialize this component, we will load the list from the user object, and store it in the observable
  ngOnInit(): void {
    this.groceryListService.loadLists(this.user);
  }

}
