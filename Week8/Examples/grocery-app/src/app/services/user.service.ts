import { Injectable } from '@angular/core';
import { User } from '../interfaces/User';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user:User = {
    userId: 0,
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    lists: []
  }

  constructor(private http:HttpClient) { }

  //We want this method, to now return an observable instead of void
  loginUser(username:string, password:string):Observable<User>{
    //Lets make an http request to our server
    //Setup our headers, so the server knows what data we are sending
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    //We are ready to make our http request
    return this.http.post<User>("http://localhost:8000/users/login", JSON.stringify({username, password}),
      httpOptions
    )
    //Deal with any errors that might occur with the request
    .pipe(catchError((e) => {
      return throwError(() => new Error(e));
    }));
  }
}
