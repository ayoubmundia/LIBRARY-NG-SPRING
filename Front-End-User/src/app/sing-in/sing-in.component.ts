import { Component, OnInit, NgModule } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { SendDemandeService } from '../auth/send-demande.service';
import { Router } from '@angular/router';
import { UserModule } from '../user/user.module';


@Component({
  selector: 'app-sing-in',
  templateUrl: './sing-in.component.html',
  styleUrls: ['./sing-in.component.scss']
})

@NgModule({
  imports: [
    ReactiveFormsModule
  ],
})

export class SingInComponent implements OnInit {
  signInForm: FormGroup;
  errorMessage: string;

  constructor(private formBuilder: FormBuilder,private sendDemandeService: SendDemandeService,private router: Router) { }

  ngOnInit() {
    this.signInForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  onSubmit() {
    const email = this.signInForm.get('email').value;
    const password = this.signInForm.get('password').value;
    
    // console.log(this.signInForm.value);
    this.sendDemandeService.SingIn(email,password);
    this.errorMessage = localStorage.getItem("email_or_password");


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
