import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { HomeGuard } from './guards/home.guard';

//If we want to add new pages, we simple import the component, and add them to the Routes list
const ROUTES:Routes = [
  {path: 'login', component:LoginPageComponent},
  {path:'home', component:HomePageComponent, canActivate:[HomeGuard]},
  {path: '', redirectTo:'/login', pathMatch:'full'}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(ROUTES)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
