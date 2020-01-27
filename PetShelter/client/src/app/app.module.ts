import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewComponent } from './new/new.component';
import { EditComponent } from './edit/edit.component';
import { IndexComponent } from './index/index.component';
import { HttpService } from './http.service';
import { ShowComponent } from './show/show.component';
import { NesterComponent } from './nester/nester.component';

@NgModule({
  declarations: [
    AppComponent,
    NewComponent,
    EditComponent,
    IndexComponent,
    ShowComponent,
    NesterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
