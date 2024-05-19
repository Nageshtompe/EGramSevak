import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { SuperadmindashboardComponent } from './superadmindashboard/superadmindashboard.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    UserdashboardComponent,
    AdmindashboardComponent,
    SuperadmindashboardComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports:[
    UserdashboardComponent,
    AdmindashboardComponent,
    SuperadmindashboardComponent
  ]
})
export class DashboardModule { }
