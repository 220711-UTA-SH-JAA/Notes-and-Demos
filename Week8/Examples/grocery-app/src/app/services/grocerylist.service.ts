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
    this.gl = user.lists;
    this.subject.next(user.lists);
  }

  addItem(listName:string, item:string){
    let body = {
      name: listName,
      item
    }

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    this.http.put<GroceryList>('http://localhost:8000/list/add', JSON.stringify(body), httpOptions)
    .pipe(
      catchError((e) => {
        return throwError(() => new Error(e));
      })
    )
    .subscribe((data) => {
      console.log(data);
      let updated:GroceryList = data;
      this.gl.forEach((list, index) => {
        if(list.listName === listName){
          this.gl[index] = updated;
        }
      });

      console.log(this.gl);
      //Update the subject, so that all the observers know the lists were updated
      this.subject.next(this.gl);
    });
  }
}
