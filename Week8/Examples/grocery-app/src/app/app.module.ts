import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ItemComponent } from './components/item/item.component';
import { GroceryListComponent } from './components/grocery-list/grocery-list.component';
import { NewItemComponent } from './components/new-item/new-item.component';
import { LoginPageComponent } from './components/login-page/login-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ItemComponent,
    GroceryListComponent,
    NewItemComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    //We need to add the  Forms module to be able to take in user input and use two way binding
    //in angular
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
