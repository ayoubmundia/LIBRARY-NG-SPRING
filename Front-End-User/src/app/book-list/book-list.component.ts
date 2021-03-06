import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BookListService } from '../bookServices/book-list.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {
  public host: string = "http://localhost:8088";
  public Categories:any;
  public livres:any;
  public size:number=5;
  public currentPage:number=0;
  public totalPages:number;
  public pages:Array<number>;
  public currentCategorie:any;
  public numberOfCategories: any;
  constructor(private http : HttpClient,
    private booklist:BookListService) { }

  ngOnInit() {
    this.http.get(this.host+"/api/categories").subscribe(
      (data:any) =>{
        this.Categories = data;
        console.log(this.Categories[0])
        this.numberOfCategories=data.length
        this.currentCategorie = this.Categories[0];
        this.booklist.getLivres(this.currentPage,this.size,this.Categories[0].id_category)
      .subscribe(
        (data:any)=>{
          console.log(data)
          this.totalPages=data.totalPages;
          this.pages=new Array<number>(this.totalPages);
          this.livres = data;
      }
      ,
      err=>{
        console.log(err);
      })
        // console.log(JSON.stringify(this.Categories))
      },
      err =>{
        console.log(err);

      }
    );
    console.log(this.Categories)
      
    
  }
  
  onGetlivres(c){
    this.currentCategorie=c;
    this.booklist.getLivres(this.currentPage,this.size,c.id_category)
    .subscribe(
      (data:any)=>{
        console.log(data)
        this.totalPages=data.totalPages;
        this.pages=new Array<number>(this.totalPages);
        this.livres = data;
    }
    ,
    err=>{
      console.log(err);
    })
  }  
  // firstBookEmpty(){
  //   if(this.currentCategorie && this.livres){
  //     for(var i = 0; i < this.numberOfCategories; i++){
  //       this.currentCategorie.i


  //     }
  //   }
  // }
  onPageProduct(i){
    this.currentPage=i;
    this.onGetlivres(this.currentCategorie);
  }

}

