import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { NewComponent } from './new/new.component';
import { EditComponent } from './edit/edit.component';
import { ShowComponent } from './show/show.component';


const routes: Routes = [
  {path:'', pathMatch:'full', component: IndexComponent},
  {path:'new', component: NewComponent},
  {path:'edit/:id', component:EditComponent},
  {path:'read/:id', component: ShowComponent},
  {path:'**', redirectTo:"/"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
