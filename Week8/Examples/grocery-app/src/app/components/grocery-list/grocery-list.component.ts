import { Component, Input, OnInit } from '@angular/core';
import {Item} from '../../interfaces/Item';
import {ITEMS} from "../../data/MockItems";
import { GroceryList } from 'src/app/interfaces/GroceryList';

@Component({
  selector: 'grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {

  @Input() list:GroceryList = {
    listId: 0,
    listName: '',
    items: []
  }

  constructor() { }

  ngOnInit(): void {
  }

  addItem(item:Item):void{
    this.list.items.push(item);
    console.log(this.list.items);
  }

}
