import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';


@NgModule({
declarations: [
AppComponent,
routingComponents,
],
imports: [
BrowserModule,
AppRoutingModule, FormsModule, HttpClientModule
],
providers: [],
bootstrap: [AppComponent]
})
export class AppModule { }
