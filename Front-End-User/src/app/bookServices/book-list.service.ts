import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookListService {
  public host:string = "http://localhost:8088";
  constructor(private httpClient:HttpClient) { }
  
  public getLivres(page:number, size:number){
    // console.log("weslt")
    return this.httpClient.get(this.host+"/api/livres/listPageable?page="+page+"&size="+size);
  }


}
