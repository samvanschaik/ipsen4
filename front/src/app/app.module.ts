import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FollowersComponent } from './followers/followers.component';
import { FollowersService } from './shared/services/followers.service';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    FollowersComponent
  ],
  imports: [
    BrowserModule,
    MatFormFieldModule,
    MatCardModule,
    HttpClientModule
  ],
  providers: [FollowersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
