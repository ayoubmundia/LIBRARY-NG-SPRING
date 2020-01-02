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
    public categoryUpdated:any;
    constructor(private catService:CatalogueService) { }
    public NotEmpty:boolean = false;

  ngOnInit() {
    this.onGetCategories();
  }

    onGetCategories(){
      this.catService.getCategories(this.currentPage,this.size)
      .subscribe((data:any)=>{
          this.totalPages=data.totalPages;
          this.pages=new Array<number>(this.totalPages);
          this.categories = data;
          if(this.categories.totalElements >0){
            this.NotEmpty=true;
          }
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

    onUpdateCategory(id){
      this.catService.getCategoryById(id)
      .subscribe((data:any)=>{
        this.categoryUpdated = data;
      }
      ,
      err=>{
        console.log("error"+err);
      })
    }

    saveCategory(){
      this.catService.updateCategory(this.categoryUpdated)
      .subscribe((data:any) =>{
        this.categoryUpdated = null;
        this.onGetCategories();
      },
      err=>{
  
      })
    }

    availabilityChange(filterVal: any) {
      if(filterVal==="0"){
        this.categoryUpdated.active = 0;
      }else{
        this.categoryUpdated.active = 1;
      }
    }


  }
