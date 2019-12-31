import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class UserModule {
  id: string;
  first_name:string;
  last_name: string;
  mail: string;
  password: string;
 }
