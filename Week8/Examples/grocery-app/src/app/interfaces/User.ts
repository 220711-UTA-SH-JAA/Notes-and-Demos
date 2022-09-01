import { GroceryList } from "./GroceryList";

export interface User {
    userId: number;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    lists: GroceryList[];
}