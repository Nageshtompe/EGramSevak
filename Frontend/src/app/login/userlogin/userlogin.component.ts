import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent {

  constructor(private http:HttpClient,private app:AppComponent){

  }

  UIusername:"";
  UIpassword:"";

  login(){
    this.http.get('http://localhost:8080/'+'login'+this.UIusername+'/'+this.UIpassword).subscribe(
      (data:any)=>{
        if(data==-1)
        {
          window.alert("login not suceessfull");
        }
        else if(data==-2)
        {
          window.alert("user not verified please verify the user");
        }else if(data==-3)
        {
          window.alert("user rejected cannot login"); 
        }else{
          this.app.isLoginSuccess=data;
        }
      }
    )
  }
}
