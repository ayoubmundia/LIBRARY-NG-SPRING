import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SingInComponent } from './sing-in/sing-in.component';
import { SingUpComponent } from './sing-up/sing-up.component';
import { HomeComponent } from './home/home.component';
import { SearchBarComponent } from './search-bar/search-bar.component'
import { BookListComponent } from './book-list/book-list.component';
import { ProfilComponent } from './profil/profil.component';
import { BookDetailsComponent } from './book-details/book-details.component';

const routes: Routes = [
    {path: 'singin', component: SingInComponent},
    {path: 'booklist', component: BookListComponent},
    {path: 'bookdetails/:id', component: BookDetailsComponent},
    {path: 'singup', component: SingUpComponent},
    {path: 'profil', component: ProfilComponent},
    {path: '', component: HomeComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [SingInComponent,SingUpComponent,HomeComponent,BookDetailsComponent,SearchBarComponent,BookListComponent,ProfilComponent]