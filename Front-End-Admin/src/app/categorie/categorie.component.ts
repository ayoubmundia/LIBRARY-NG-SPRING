import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../services/catalogue.service';
import { Router } from '@angular/router';
import { Categorie } from '../categorie';

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css'],
  styles: [`
  :host {
    width : 100%;
  }
  `]
})
export class CategorieComponent implements OnInit {

    public categories:any;
    public size:number=5;
    public currentPage:number=0;
    public totalPages:number;
    public pages:Array<number>;
    public categoryUpdated:any;


    categorie: Categorie = new Categorie();
    submitted = false;

    constructor(private catService:CatalogueService,  private router: Router) { }

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

    /** doing by Tahiri=> Start i add the categories here etape2 */
    newCategorie(): void {
      this.submitted = false;
      this.categorie = new Categorie();
    }

    save() {
      this.catService.createCategorie(this.categorie)
        .subscribe(data => console.log(data), error => console.log(error));
      this.categorie = new Categorie();
      this.onGetCategories();
    }

    onSubmit() {
      this.submitted = true;
      this.save();
      this.onGetCategories();
    }

    /** i cant't delete yet i cant just get the id of this category */
    onDeleteCategorie(id: number) {
      console.log(id);
    }


    /** doing by Tahiri End of code */
}
