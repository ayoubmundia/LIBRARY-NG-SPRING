import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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

  public getLivreById(id:number){
    return this.httpClient.get(this.host+"/api/livres/"+id);
  }
  public getCategoryById(id:number){
    return this.httpClient.get(this.host+"/api/categories/"+id);
  }


  public getAllCategories(){
    return this.httpClient.get(this.host+"/api/categories/");
  }

  /** doing by Tahiri Start ayoub you forget getAllLivres */
    public getAllLivres(){
    return this.httpClient.get(this.host+"/api/livres/");
  }
  /** tahiri end */


  public updateBook(value:any){
    return this.httpClient.post(this.host+"/api/livres/", value);
  }
  public updateCategory(value:any){
    return this.httpClient.post(this.host+"/api/categories/", value);
  }


  /** doing by Tahiri Start i add the categorie and book here  etape1 */
  createCategorie(categorie: Object): Observable<Object> {
    return this.httpClient.post(this.host+"/api/categories", categorie);
  }

  createBook(book: Object): Observable<Object> {
    return this.httpClient.post(this.host+"/api/livres", book);
  }

  deleteCategorie(id: number): Observable<any> {
    return this.httpClient.delete(this.host+"/api/categories/"+id);
  }
  /** doing by Tahiri End of code */

  // Demandes Part 
  public getDemandes(page: number , size:number){
    return this.httpClient.get(this.host+"/demandes?page="+page+"&size="+size+"&sort=date,desc");
  }
  
  public getDemandesPage(page: number , size:number){
    return this.httpClient.get(this.host+"/api/demandes/listPageable?page="+page+"&size="+size+"&sort=date,desc");
  }

  public acceptUser(demande: any){
    return this.httpClient.post(this.host+"/api/users", demande);
  }

  public deleteDemande(id: number): Observable<any> {
    return this.httpClient.delete(this.host+"/api/demandes/"+id);
  }

}
