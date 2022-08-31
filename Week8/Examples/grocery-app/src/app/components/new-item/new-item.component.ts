import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { Item } from 'src/app/interfaces/Item';

@Component({
  selector: 'new-item',
  templateUrl: './new-item.component.html',
  styleUrls: ['./new-item.component.css']
})
export class NewItemComponent implements OnInit {

  //Event emitters are used to send data from a child component to a parent component
  //To create an emmitter we will use the @Output annotation and a new EventEmitter
  @Output() onAddItem: EventEmitter<Item> = new EventEmitter();

  itemName:string = '';
  itemPrice:number = 0.0;
  error:boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  //We need a method to call the event emitter when the submit button is pressed
  submitItem(): void{
    if(!this.itemName || !this.itemPrice){
      this.error = true;
      return;
    }

    const newItem:Item = {
      itemId: 0,
      itemName: this.itemName,
      itemPrice: this.itemPrice
    }

    this.onAddItem.emit(newItem);

    this.error = false;
    this.itemName='';
    this.itemPrice= 0.0;
  }

}
