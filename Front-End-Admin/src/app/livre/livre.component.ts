import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CatalogueService } from '../services/catalogue.service';
@Component({
  selector: 'app-livre',
  templateUrl: './livre.component.html',
  styleUrls: ['./livre.component.css']
})
export class LivreComponent implements OnInit {

  public livres:any;
  public size:number=5;
  public currentPage:number=0;
  public totalPages:number;
  public pages:Array<number>;
  constructor(private catService:CatalogueService) { }

  ngOnInit() {
    this.catService.getLivres(this.currentPage,this.size)
      .subscribe((data:any)=>{
          this.totalPages=data.totalPages;
          this.pages=new Array<number>(this.totalPages);
          this.livres = data;
      }
      ,
      err=>{
        console.log(err);
      })
    }

  onGetlivres(){
    this.catService.getLivres(this.currentPage,this.size)
    .subscribe((data:any)=>{
        this.totalPages=data.totalPages;
        this.pages=new Array<number>(this.totalPages);
        this.livres = data;
    }
    ,
    err=>{
      console.log(err);
    })
  }

  onPageProduct(i){
    this.currentPage=i;
    this.onGetlivres();
  }


}
