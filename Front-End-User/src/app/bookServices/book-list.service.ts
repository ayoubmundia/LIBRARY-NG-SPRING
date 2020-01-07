import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookListService {
  public host:string = "http://localhost:8088";
  constructor(private httpClient:HttpClient) { }
  
  public getLivres(page:number, size:number , id_cat:number){
    console.log(id_cat);
    console.log(page);
    console.log(size);
    return this.httpClient.get(this.host+"/api/categories/"+id_cat+"/books?page="+page+"&size="+size);
  }


}
