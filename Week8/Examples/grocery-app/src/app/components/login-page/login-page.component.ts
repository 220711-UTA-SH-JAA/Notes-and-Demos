import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  username:string = '';
  password:string='';

  //Use dependency injection in angular, we provide the service in the constructor
  constructor(private userService:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  login():void{
    this.userService.loginUser(this.username, this.password)
    .subscribe(data => {
      console.log(data);
      this.userService.user = data;
      this.router.navigateByUrl('/home');
    }, error => {
      alert('Invalid username or password')
    });
  }

}
