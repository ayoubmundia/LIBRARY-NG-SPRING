import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-top-menu',
  templateUrl: './top-menu.component.html',
  styleUrls: ['./top-menu.component.scss']
})
export class TopMenuComponent implements OnInit {
  Auth: any;
  first_name:string
  last_name:string
  mail:string
  constructor(private router: Router) { }

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
  logout(){
    localStorage.setItem("is_auth", "false");
    this.router.navigate(['/booklist']);
  }

}
