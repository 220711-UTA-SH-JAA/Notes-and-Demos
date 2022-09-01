import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, throwError, BehaviorSubject, catchError } from 'rxjs';
import {User} from '../interfaces/User';
import { GroceryList } from '../interfaces/GroceryList';

@Injectable({
  providedIn: 'root'
})
export class GrocerylistService {

  gl:GroceryList[] = [];

  subject = new BehaviorSubject(this.gl);

  constructor(private http:HttpClient) { }

  loadLists(user:User):void{
    this.subject.next(user.lists);
  }
}
