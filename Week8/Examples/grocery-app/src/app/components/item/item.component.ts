import { Component, Input, OnInit } from '@angular/core';
import { Item } from 'src/app/interfaces/Item';

@Component({
  selector: 'item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  //To make it able to take in data from a parent, we need to include the @Input decorator
  @Input() item:Item = {
    itemId: 0,
    itemName: '',
    itemPrice: 0.0
  }

  constructor() { }

  ngOnInit(): void {
  }

  remove():void {
    alert(`We want to remove the item: ${this.item.itemId}`);
  }

}
