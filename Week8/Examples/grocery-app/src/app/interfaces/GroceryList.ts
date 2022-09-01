import { Item } from "./Item";

export interface GroceryList {
    listId:number;
    listName:string;
    items:Item[]
}