import { NgModule } from '@angular/core';

import { Routes, RouterModule } from '@angular/router';


import { LivreComponent} from './livre/livre.component';
import { CategorieComponent} from './categorie/categorie.component';
import { EmpruntComponent} from './emprunt/emprunt.component';
import { ListempruntComponent} from './listemprunt/listemprunt.component';
import { ProlongerComponent} from './prolonger/prolonger.component';
import { CreateCategorieComponent } from './create-categorie/create-categorie.component';
import { CompteComponent } from './compte/compte.component';
import { ProfileComponent } from './profile/profile.component';


const routes: Routes = [
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: 'livres', component:  LivreComponent},
  {path: 'categories', component:  CategorieComponent},
  {path: 'comptes', component:  CompteComponent},
  {path: 'emprunts', component:  EmpruntComponent},
  {path: 'listEmprunts', component:  ListempruntComponent},
  {path: 'prolonger', component:  ProlongerComponent},
  {path: 'create_cat', component:  CreateCategorieComponent},
  {path: 'profiles', component:  ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
/** je vais creer les noms des component dans cette list, je vais utiliser ce variable dans app.module.ts */
export const routingComponents = [LivreComponent,ProfileComponent,CreateCategorieComponent, CategorieComponent, CompteComponent , EmpruntComponent, ListempruntComponent,ProlongerComponent]

