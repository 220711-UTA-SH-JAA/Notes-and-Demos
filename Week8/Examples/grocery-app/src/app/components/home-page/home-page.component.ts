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

  constructor() { }

  ngOnInit(): void {
  }

}
