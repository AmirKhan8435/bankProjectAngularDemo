import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AddAccountComponent } from './add-account/add-account.component';
import { UserListComponent } from './user-ls/user-ls.component';
import { EditUserDetailsComponent } from './edit-user-details/edit-user-details.component';
import { AccountListComponent } from './account-ls/account-ls.component';
import { EditAccountDetailsComponent } from './edit-account-details/edit-account-details.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'home', component: HomeComponent},
  {path:'login', component: SignInComponent},
  {path:'register',component: SignUpComponent},
  {path:'addAccount/:id',component: AddAccountComponent},
  {path:'getUsers',component: UserListComponent},
  // {path:'editUser',component: EditUserDetailsComponent},
  {path:'editUser/:id',component: EditUserDetailsComponent},
  {path:'viewAccounts/:id',component: AccountListComponent},
  {path:'editAccount/:id',component:EditAccountDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
