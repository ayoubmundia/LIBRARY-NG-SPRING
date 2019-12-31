import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
// export interface user{
//   name: string;
//   password: string;
// }
export class SendDemandeService {
  public host: string = "http://localhost:8099";
  constructor(
    private httpClient : HttpClient,
    private router: Router,
    ) { }
  

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
      let parametres = new HttpParams();
      parametres = parametres.append('mail', email);
      parametres = parametres.append('password', passwd);
    // var user_data ={ "mail": email,"password": passwd};
    this.httpClient.get(this.host+"/api/users/singin", { params: parametres }).subscribe(
      data  =>{
        if(data !== null ){
        localStorage.setItem("is_auth", "true");
        localStorage.setItem('currentUser', JSON.stringify(data));
        localStorage.setItem("email_or_password","false");
        this.router.navigate(['/profil']);
        }
        else{
          localStorage.setItem("email_or_password","true");
          localStorage.setItem("is_auth", "false");
        }
      },
      error =>{
        localStorage.setItem("is_auth", "false");
        localStorage.setItem("email_or_password","true");
      }
    );
    }
    private handleError(error: any): Promise<any> {
      localStorage.setItem("email_exist", "true");
      console.error('An error occurred', error);
      return Promise.reject(error.message || error);
    }

}
