import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../services/catalogue.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  styles: [`
  :host {
    z-index : 9;
  }
  `]
})
export class HeaderComponent implements OnInit {

  public size:number=5;
  public currentPage:number=0;
  public demandes:any;
  public allPage: boolean = true;
  public allPage_nbr: number;

  constructor(private catService:CatalogueService) { }

  ngOnInit() {
    this.onGetDemande();
  }
  onGetDemande(){
    this.catService.getDemandesPage(this.currentPage,this.size)
      .subscribe((data:any)=>{
        this.demandes = data;
        this.allPage_nbr = this.demandes.totalElements;
      }
      ,
      err=>{
        console.log(err);
      })
  }

}
