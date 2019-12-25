import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CatalogueService {
  public host:string = "http://localhost:8088";

  constructor(private httpClient:HttpClient) { }

  public getLivres(page:number, size:number){
    return this.httpClient.get(this.host+"/api/livres/listPageable?page="+page+"&size="+size);
  }
  public getCategories(page:number, size:number){
    return this.httpClient.get(this.host+"/api/categories/listPageable?page="+page+"&size="+size);
  }
}
