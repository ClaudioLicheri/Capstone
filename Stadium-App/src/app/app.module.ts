import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, NgForm } from '@angular/forms';
import { ForbiddenDirective } from './directives/forbidden.directive';
import { HeaderComponent } from './components/navbar-home/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { Page404Component } from './components/page404/page404.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { UsersComponent } from './components/users/users.component';
import { EditEventComponent } from './components/edit-event/edit-event.component';
import { TicketComponent } from './components/ticket/ticket.component';
import { InsertEventComponent } from './components/insert-event/insert-event.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FavouriteComponent } from './components/favourite/favourite.component';



@NgModule({
  declarations: [

    AppComponent,
    LoginComponent,
    HomeComponent,
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    ForbiddenDirective,
    UsersComponent,
    FooterComponent,
    Page404Component,
    ProfileComponent,
    RegisterComponent,
    EditEventComponent,
    TicketComponent,
    InsertEventComponent,
    NavbarComponent,
    FavouriteComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
