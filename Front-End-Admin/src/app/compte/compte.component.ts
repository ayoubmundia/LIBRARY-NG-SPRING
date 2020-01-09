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
  public allPage_nbr: number;
  public demandeSelected : any;

  constructor(private catService:CatalogueService,  private router: Router) { }

  ngOnInit() {
    this.onGetDemande();
  }
  onGetDemande(){
    this.catService.getDemandesPage(this.currentPage,this.size)
      .subscribe((data:any)=>{
        this.demandes = data;
        this.totalPages=data.totalPages;
        this.pages=new Array<number>(this.totalPages);
        this.allPage_nbr = this.demandes.totalElements;
        this.demandeSelected = null;
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
    this.size = this.demandes.totalElements;
    this.currentPage = 0;
    this.totalPages = 0;
    this.allPage = false;
    this.onGetDemande();
  }
  acceptDemande(d){
    this.demandeSelected = d ; 
    console.log(this.demandeSelected);
  }
  rejectDemande(d){
    this.demandeSelected = d ; 
    console.log(this.demandeSelected);
  }
  cofirmDelete(){
    this.catService.acceptUser(this.demandeSelected)
      .subscribe((data:any)=>{
        console.log(data);
        this.onGetDemande();
      }
      ,err=>{
        console.log(err);
      })
  }
  confirmRejection(){
    this.catService.deleteDemande(this.demandeSelected.id_demande)
      .subscribe((data:any)=>{
        console.log(data);
        this.onGetDemande();
      }
      ,err=>{
        console.log(err);
      })
  }

}
