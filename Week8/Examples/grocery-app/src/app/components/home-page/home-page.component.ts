import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/interfaces/Item';

@Component({
  selector: 'home',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  //If we want to store some data in our component, we simply just create a variable
  username:string = 'Ethan';

  items:Item[] = [
    {
      itemId: 1,
      itemName: "Milk",
      itemPrice: 2.99
    },
    {
      itemId: 2,
      itemName: "Bread",
      itemPrice: 2.99
    },
    {
      itemId: 3,
      itemName: "Hamburger",
      itemPrice: 4.99
    },
    {
      itemId: 4,
      itemName: "Ketchup",
      itemPrice: 1.99
    },
    {
      itemId: 5,
      itemName: "Mustard",
      itemPrice: 1.99
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
