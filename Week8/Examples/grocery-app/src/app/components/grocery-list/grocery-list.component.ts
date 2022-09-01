import { Component, Input, OnInit } from '@angular/core';
import {Item} from '../../interfaces/Item';
import {ITEMS} from "../../data/MockItems";
import { GroceryList } from 'src/app/interfaces/GroceryList';
import { GrocerylistService } from 'src/app/services/grocerylist.service';

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

  constructor(private groceryListService:GrocerylistService) { }

  ngOnInit(): void {
  }

  addItem(item:Item):void{
    this.groceryListService.addItem(this.list.listName, item.itemName);
  }

}
