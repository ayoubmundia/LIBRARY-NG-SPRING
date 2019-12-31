import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {
  Auth: any;
  first_name:string
  last_name:string
  mail:string
  constructor() { }

  ngOnInit() {
  }
  isAuth(){
    this.Auth = localStorage.getItem("is_auth");
    if(this.Auth == "true"){
      var currentUser = JSON.parse(localStorage.getItem('currentUser'));
      this.first_name = currentUser.first_name;
      this.last_name = currentUser.last_name;
      this.mail = currentUser.mail;
      return true;

    }
    else{
      return false;
    }
  }
}