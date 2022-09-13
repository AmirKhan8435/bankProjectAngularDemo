import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';
import { Account } from './account';

@Injectable({
  providedIn: 'root'
})
export class NgserviceService {
   
  user_connect:string = "http://localhost:9191/user/";
  account_connect:string = "http://localhost:9191/account/";

  constructor(private _http:HttpClient) { }

/* User Service*/

  fetchUserList():Observable<any>{
    return this._http.get<any>(this.user_connect+"getAllUsers");
  }

  addNewUser(user:User):Observable<any>{
    return this._http.post<any>(this.user_connect+"addUser",user);
  }
  
  editUserDetails(user:User):Observable<any>{
    return this._http.put<any>(this.user_connect+"updateUser",user);
  }

  deletUserDetails(id:number):Observable<any>{
    return this._http.delete<any>(this.user_connect+"deleteUser/"+id);
  }

  fetchUserByID(id:number):Observable<any>{
    return this._http.get<any>(this.user_connect+"getUser/"+id);
  }

  loginCheck(user1:User):Observable<any>{
    return this._http.post<any>(this.user_connect+"loginCheck",user1);
  }

  /* Account Services*/

  getAccountByAccountId(id:number):Observable<any>{
    return this._http.get<any>(this.account_connect+"getaccount/"+id);
  }

  getAccountByUserId(id:number):Observable<any>{
    return this._http.get<any>(this.account_connect+"userid/"+id);
  }

  addNewAccount1(accoount:Account,id:number):Observable<any>{
    console.log(accoount);
    console.log("Id : " +id);
    return this._http.post<any>(this.account_connect+"addAccount/"+id,accoount);
  }

  fetchAccountList():Observable<any>{
    return this._http.get<any>(this.account_connect+"getAllAccounts");
  }

  fetchAccountsByUserId(id:number):Observable<any>{
    return this._http.get<any>(this.account_connect+ `userid/${id}`);
  }

  addNewAccount(account:Account):Observable<any>{
    return this._http.post<any>(this.account_connect+"addAccount",account);
  }

  deleteAccountDetails(id:number):Observable<any>{
    return this._http.delete<any>(this.account_connect+`deleteAccount/${id}`);
  }

  editAccountDetails(account:Account):Observable<any>{
    return this._http.put<any>(this.account_connect+"updateAccount",account);
  }

  /*editUserDetails(user:User):Observable<any>{
    return this._http.put<any>(this.user_connect+"updateUser",user);
  }*/ 
}
