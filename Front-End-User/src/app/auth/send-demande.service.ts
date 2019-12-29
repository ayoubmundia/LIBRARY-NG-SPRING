import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SendDemandeService {
  public host: string = "http://localhost:8088";
  constructor(private httpClient : HttpClient,
    private router: Router ) { }
  

  public SendDemnde(f_Name: any, l_Name:any,email: any,passwd: any){
    var date = new Date();
    var postData ={ "date": date,"first_name" : f_Name , "last_name" : l_Name,"mail": email,"password": passwd};  
    
    console.log(JSON.stringify(postData));
    this.httpClient.post(this.host+"/api/demande",postData).toPromise()
    .then(
      ()=>{
        localStorage.setItem("email_exist", "false");
        this.router.navigate(['/singin'])
        }
    )
    .catch(this.handleError);
     }


    public SingIn(email: string,passwd: string){
    var user_data ={ "mail": email,"password": passwd};
    this.httpClient.get(this.host+"/api/users").subscribe(
      data =>{
        console.log("reponse:",data);
      }
    );
    
    // .then(
    //   ()=>{
    //     // localStorage.setItem("email_exist", "false");
    //     // this.router.navigate(['/booklist'])
    //     }
    // )
    // .catch(this.handleError);
    }
    

    private handleError(error: any): Promise<any> {
      localStorage.setItem("email_exist", "true");
      console.error('An error occurred', error);
      return Promise.reject(error.message || error);
    }

}
