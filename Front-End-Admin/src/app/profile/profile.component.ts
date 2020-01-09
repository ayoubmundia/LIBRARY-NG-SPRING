import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  styles: [`
  :host {
    width : 100%;
  }
  `]
})
export class ProfileComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
