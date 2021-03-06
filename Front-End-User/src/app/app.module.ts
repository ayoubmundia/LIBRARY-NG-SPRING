import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'; 

import { AppComponent } from './app.component';
import { TopMenuComponent } from './top-menu/top-menu.component';
import { FooterComponent } from './footer/footer.component';
import { BookDetailsComponent } from './book-details/book-details.component';



@NgModule({
  declarations: [
    AppComponent,
    TopMenuComponent,
    FooterComponent,
    routingComponents,
    BookDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
}

// import { from } from 'rxjs';
// import { HomeComponent } from './home/home.component';
// import { BookListComponent } from './book-list/book-list.component';
// import { ProfilComponent } from './profil/profil.component';
// import { SingInComponent } from './sing-in/sing-in.component';
// import { SingUpComponent } from './sing-up/sing-up.component';
// import { SearchBarComponent } from './search-bar/search-bar.component';