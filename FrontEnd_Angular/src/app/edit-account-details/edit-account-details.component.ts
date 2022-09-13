import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';
import { NgserviceService } from '../ngservice.service';
import { User } from '../user';

@Component({
  selector: 'app-edit-account-details',
  templateUrl: './edit-account-details.component.html',
  styleUrls: ['./edit-account-details.component.css']
})
export class EditAccountDetailsComponent implements OnInit {
  account = new Account();
  user = new User();
   selectId :any;

  constructor(private _route:Router,private _service:NgserviceService,private _activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {

    let u:any = window.localStorage.getItem('userDetails');
    this.user = JSON.parse(u);

    this._activatedRoute.paramMap.subscribe(
      params=>{
        this.selectId=(params.get('id'));
      }
    )
    this._service.getAccountByAccountId(this.selectId).subscribe(
      data=>{
        console.log("Data(account) received");
        this.account=data;
      },
      error=>{
        console.log("exception occured");
      }
    )
    // console.log(this.selectId);
  }

  editAccountFormSubmit()
  {
    this._service.editAccountDetails(this.account).subscribe(
      data=>console.log("data updated successfully"),
      error=>console.log("error occured")
    )

    this._route.navigate(['/viewAccounts/',this.user.user_ID]);
  }

}
