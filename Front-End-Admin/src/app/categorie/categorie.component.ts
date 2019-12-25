import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CatalogueService } from '../services/catalogue.service';

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css']
})
export class CategorieComponent implements OnInit {

   public categories:any;
    public size:number=5;
    public currentPage:number=0;
    public totalPages:number;
    public pages:Array<number>;
    constructor(private catService:CatalogueService) { }

  ngOnInit() {
      this.catService.getCategories(this.currentPage,this.size)
        .subscribe((data:any)=>{
            this.totalPages=data.totalPages;
            this.pages=new Array<number>(this.totalPages);
            this.categories = data;
        }
        ,
        err=>{
          console.log(err);
        })
      }

    onGetCategories(){
      this.catService.getCategories(this.currentPage,this.size)
      .subscribe((data:any)=>{
          this.totalPages=data.totalPages;
          this.pages=new Array<number>(this.totalPages);
          this.categories = data;
      }
      ,
      err=>{
        console.log(err);
      })
    }

    onPageProduct(i){
      this.currentPage=i;
      this.onGetCategories();
    }


  }
