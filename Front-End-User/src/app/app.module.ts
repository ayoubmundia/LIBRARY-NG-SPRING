import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, routingComponents } from './app-routing.module';

import { AppComponent } from './app.component';
import { TopMenuComponent } from './top-menu/top-menu.component';
import { FooterComponent } from './footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    TopMenuComponent,
    FooterComponent,
    routingComponents
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
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