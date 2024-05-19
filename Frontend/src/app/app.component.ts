import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EGramSevek';

  whatToShow=0;
  isLoginSuccess=0;

  show(num:number){
    this.whatToShow=num;
  }
}
