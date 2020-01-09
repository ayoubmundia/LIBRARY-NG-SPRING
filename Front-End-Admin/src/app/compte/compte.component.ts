import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../services/catalogue.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css'],
  styles: [`
  :host {
    width : 100%;
  }
  `]
})
export class CompteComponent implements OnInit {

  public size:number=5;
  public currentPage:number=0;
  public demandes:any;
  public totalPages:number;
  public pages:Array<number>;
  public allPage: boolean = true;

  constructor(private catService:CatalogueService,  private router: Router) { }

  ngOnInit() {
    this.onGetDemande();
  }
  onGetDemande(){
    this.catService.getDemandes(this.currentPage,this.size)
      .subscribe((data:any)=>{
        this.demandes = data;
        this.totalPages=data.page.totalPages;
        this.pages=new Array<number>(this.totalPages);
        console.log("Yes You made it");
      }
      ,
      err=>{
        console.log(err);
      })
  }
  onPageProduct(i){
    this.currentPage=i;
    this.onGetDemande();
  }
  touAfficher(){
    this.size = this.demandes.page.totalElements;
    this.currentPage = 0;
    this.totalPages = 0;
    this.allPage = false;
    this.onGetDemande();
  }

}
