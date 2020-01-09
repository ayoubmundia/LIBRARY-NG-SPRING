import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
  styles: [`
  :host {
    z-index : 8;
  }
  `]
})
export class MenuComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
