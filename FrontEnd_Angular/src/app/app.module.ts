import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TextcomponentComponent } from './text-comp/text-comp.component';
import { UserRegistrationComponentComponent } from './user-regi-comp/user-regi-comp.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { HomeComponent } from './home/home.component';
import { UserListComponent } from './user-ls/user-ls.component';
import { HttpClientModule } from '@angular/common/http';
import { AddAccountComponent } from './add-account/add-account.component';
import { EditUserDetailsComponent } from './edit-user-details/edit-user-details.component';
import { AccountListComponent } from './account-ls/account-ls.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { EditAccountDetailsComponent } from './edit-account-details/edit-account-details.component';



@NgModule({
  declarations: [
    AppComponent,
    TextcomponentComponent,
    UserRegistrationComponentComponent,
    HeaderComponent,
    FooterComponent,
    SignInComponent,
    SignUpComponent,
    HomeComponent,
    UserListComponent,
    AddAccountComponent,
    EditUserDetailsComponent,
    AccountListComponent,
    EditAccountDetailsComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule 
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
