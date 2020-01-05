import { NgModule } from '@angular/core';

import { Routes, RouterModule } from '@angular/router';


import { LivreComponent} from './livre/livre.component';
import { CategorieComponent} from './categorie/categorie.component';
import { ProfilComponent} from './profil/profil.component';
import { EmpruntComponent} from './emprunt/emprunt.component';
import { ListempruntComponent} from './listemprunt/listemprunt.component';
import { ProlongerComponent} from './prolonger/prolonger.component';


const routes: Routes = [
  {path: '', redirectTo: 'livres', pathMatch: 'full'},
  {path: 'livres', component:  LivreComponent},
  {path: 'categories', component:  CategorieComponent},
  {path: 'profils', component:  ProfilComponent},
  {path: 'emprunts', component:  EmpruntComponent},
  {path: 'listEmprunts', component:  ListempruntComponent},
  {path: 'prolonger', component:  ProlongerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
/** je vais creer les noms des component dans cette list, je vais utiliser ce variable dans app.module.ts */
export const routingComponents = [LivreComponent, CategorieComponent, ProfilComponent, EmpruntComponent, ListempruntComponent,ProlongerComponent]

