import { Component,Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {
  public host: string = "http://localhost:8088";

  public id;
  public livre;
  public livres;
  constructor( private http : HttpClient
    ,private route: ActivatedRoute) {}

  ngOnInit() {
    let id_book = this.route.snapshot.paramMap.get('id');
    console.log(id_book);
    this.http.get(this.host+"/api/livres/"+id_book).subscribe(
      (data:any) =>{
        this.livre = data;
        console.log(this.livre);
        // console.log(this.Categories[0])
        // this.numberOfCategories=data.length
        // this.currentCategorie = this.Categories[0];
        this.http.get(this.host+"/api/categories/"+this.livre.category.id_category+"/books?page="+0+"&size="+3)
      .subscribe(
        (data:any)=>{
          console.log(data)
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
  }

}
