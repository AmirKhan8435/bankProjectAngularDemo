import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';
import { NgserviceService } from '../ngservice.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {
  account = new Account();
  id : any 
  constructor(private _service:NgserviceService,private get_id:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.get_id.paramMap.subscribe(
      param1 => {this.id = param1.get('id')}
    )
      this.account.user_ID = this.id;
  }

  addAccountFormSubmit(addAccountForm:any)
  {
    if(this.account.account_type==null)
    {
      this.account.account_type='S';
    }

    this.account.user_ID = this.id;
    console.log('new user id in account :'+this.account.user_ID);
    this._service.addNewAccount(this.account).subscribe(
      data=>console.log("data added successfully"),
      error=>console.log("error occured")
    )
    this.router.navigate(['viewAccounts/',this.account.user_ID])
  }

}
