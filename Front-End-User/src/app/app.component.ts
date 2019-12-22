import { Component, NgModule } from '@angular/core';
import { TopMenuComponent } from './top-menu/top-menu.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
@NgModule({
  declarations: [
    TopMenuComponent,
  ]
})


export class AppComponent {
  title = 'ma-biblio';
}
