import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from '../app/home/home.component'
import { ListComponent } from './list/list.component';
import { RoutineComponent} from '../app/routine/routine.component'
import { AuthenticateComponent } from './authenticate/authenticate/authenticate.component';
import { UploaddownloadfileComponent } from './upload/uploaddownloadfile/uploaddownloadfile.component';


const routes: Routes = [
  
  {
    path:'',
    component:HomeComponent

  },
  {
    path:'getlist',
    component:ListComponent

  },
  {
    path:'routine',
    component:RoutineComponent
  },
{
  path:'auth',
  component:AuthenticateComponent
},
{
  path:'upload',
  component:UploaddownloadfileComponent
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
