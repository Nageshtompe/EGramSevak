import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Scheme } from 'src/app/model/Scheme';
import { User } from 'src/app/model/User';
import { Village } from 'src/app/model/Village';

@Component({
  selector: 'app-superadmindashboard',
  templateUrl: './superadmindashboard.component.html',
  styleUrls: ['./superadmindashboard.component.css']
})
export class SuperadmindashboardComponent {

  constructor(private http:HttpClient){

  }
  allUnVerifiedUser:User[]=[];
  getDataOfUser(){

    this.http.get('http://localhost:8080/'+'getunverifiedUserData').subscribe(
      (data:any)=>
      {
        if(data==null)
        window.alert("exception on server")
        else
        this.allUnVerifiedUser=data;

      }
    );

  }
  whatToShow=0;
  show(num:number)
  {
    this.whatToShow=num;
  }

  villageData:Village[]=[];
  village:Village=new Village();

  addVillage(){
    this.http.post('http://localhost:8080/'+'addVillageData',this.village).subscribe(
      (data:any)=>
      {
        if(data==false)
        window.alert("exception on server");
      else
      {
        window.alert("added successfully");
        this.village=new Village();
      }


      }
    );
  }

  getVillageData(){

    this.http.get('http://localhost:8080/'+'getVillageData').subscribe(
      (data:any)=>
      {
        if(data==null)
        window.alert("exception in serve");
        else
        this.villageData=data;
      }

    );

  }

  scheme:Scheme=new Scheme();
  selectVillage="";
  addScheme(){


    console.log(this.scheme);
    

    this.http.post('http://localhost:8080/'+'addScheme',this.scheme+this.selectVillage).subscribe(
      (data:any)=>
      {
        if(data==false)
        {
          window.alert("scheme data is not added")
        }
        else{
          window.alert("scheme data added successfully");
          this.scheme=new Scheme();
        }
      }
    );
  }



}
