import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CatalogueService } from '../services/catalogue.service';
import { Book } from '../book';
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
/* Variable for update Part*/
public livreUpdated:any;
public onUpdate:boolean = true;
public categories:any;
/* Constuctor */
book: Book = new Book();
submitted = false;

constructor(private catService:CatalogueService,  private router: Router) { }


  /*model:Book = {
    author:'',
    title:'',
    edition:'',
    available:''
  };*/
  /* Functions */
  ngOnInit() {
    this.onGetlivres();
    this.catService.getAllCategories()
    .subscribe((data:any)=>{
        this.categories = data;
    }
    ,
    err=>{
      console.log(err+"hhh");
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

  onGetlivreUpdate(i){
    this.catService.getLivreById(i)
    .subscribe((data:any)=>{
        this.onUpdate = true;
        this.livreUpdated = data;
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

  saveBook(){
    console.log(this.livreUpdated.available);
    this.catService.updateBook(this.livreUpdated)
    .subscribe((data:any) =>{
      this.livreUpdated = null;
      this.onGetlivres();
    },
    err=>{

    })
  }

  availabilityChange(filterVal: any) {
    if(filterVal==="0"){
      this.livreUpdated.available = 0;
    }else{
      this.livreUpdated.available = 1;
    }
  }

  categoryChange(filterVal: any) {
    this.catService.getCategoryById(filterVal)
    .subscribe((data:any) =>{
      this.livreUpdated.category = data;
      console.log(this.livreUpdated.category);
    },
    err=>{
      console.log("error");
    })
  }

    /** doing by Tahiri=> Start i add the categories here etape2 */
    newBook(): void {
      this.submitted = false;
      this.book = new Book();
    }

  save() {
    this.catService.createBook(this.book)
      .subscribe(data => console.log(data), error => console.log(error));
    this.book = new Book();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  /** doing by Tahiri End of code */

}
/*
export interface Book{
  author:string;
  title:string;
  edition:string;
  available:string;
}
*/
