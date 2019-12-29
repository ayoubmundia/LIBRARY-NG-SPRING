import { Component, OnInit, NgModule } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { SendDemandeService } from '../auth/send-demande.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-sing-up',
  templateUrl: './sing-up.component.html',
  styleUrls: ['./sing-up.component.scss']
})
@NgModule({
  imports: [
    ReactiveFormsModule
  ],
})
export class SingUpComponent implements OnInit {


  signupForm: FormGroup;
  errorMessage: string;
  

  // constructor(private formBuilder: FormBuilder,
  //   private sendDemandeService: SendDemandeService,
  //   private router: Router) { }
    constructor(private formBuilder: FormBuilder,
      private sendDemandeService: SendDemandeService,
      private router: Router) { }

  ngOnInit() {
    this.signupForm = this.formBuilder.group({
      first_name: ['', [Validators.required]],
      last_name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.pattern(/[0-9a-zA-Z]{6,}/)]]
    });

  }


  

  onSubmit() {
    const email = this.signupForm.get('email').value;
    const password = this.signupForm.get('password').value;
    const last_name = this.signupForm.get('last_name').value;
    const first_name= this.signupForm.get('first_name').value;
 
    
    console.log(this.signupForm.value);
    this.sendDemandeService.SendDemnde(first_name,last_name,email,password);
    this.errorMessage = localStorage.getItem("email_exist");
    // .then(
    //   () => {
    //     this.router.navigate(['/singin']);
    //   },
    //   (error) => {
    //     this.errorMessage = error;
    //   }
    // );
  }
  emailValid(){
    if (this.errorMessage == "true"){
      return true;
    }
    else{
      return false;
    } 
  }
}