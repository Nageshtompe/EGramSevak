import { HttpClient} from '@angular/common/http';
import { Component } from '@angular/core';
import { User } from 'src/app/model/User';
import { Village } from 'src/app/model/Village';

@Component({
  selector: 'app-userregistration',
  templateUrl: './userregistration.component.html',
  styleUrls: ['./userregistration.component.css']
})
export class UserregistrationComponent {

  url='http://localhost:8080/';

  allVillageData:Village[]=[];
  constructor(private http:HttpClient){
    this.http.get('http://localhost:8080/'+'getVillageData').subscribe(
      (data:any)=>
      {
        if(data==null)
          window.alert("exception on server");
        else
        this.allVillageData=data;
        
      }
    );

  }

  
  

  // village:Village=new Village();
  registerUser:User=new User();
  //confirmPassword:string;

  selectedVillage ="";
  register(){
    console.log(this.registerUser);
    console.log(this.selectedVillage);
    
    
    
    this.http.post('http://localhost:8080/'+'register'+this.selectedVillage,this.registerUser).subscribe(
      (data:any)=>
      {
        if(data==false)
        {
          window.alert("register not successfull");
        }
        else
        window.alert("register successfull");
      this.registerUser=new User();
      }
    );
    
  }

  errorMsg="";
  isErrorShow=0;


  

}
