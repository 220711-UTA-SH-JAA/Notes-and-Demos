import { Component, OnInit } from '@angular/core';
import {Item} from '../../interfaces/Item';
import {ITEMS} from "../../data/MockItems";

@Component({
  selector: 'grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {

  items:Item[] = ITEMS;

  constructor() { }

  ngOnInit(): void {
  }

  addItem(item:Item):void{
    this.items.push(item);
    console.log(this.items);
  }

}
