import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';
import { NgserviceService } from '../ngservice.service';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-ls.component.html',
  styleUrls: ['./account-ls.component.css']
})
export class AccountListComponent implements OnInit {
  //acc= new Account();
  accountData:any=[];
  
  constructor(private _route:Router,private _service:NgserviceService,private _activatedRoute:ActivatedRoute) 
  {
    
  }

  selectId: any;

  ngOnInit(): void {
      // this._activatedRoute.paramMap.subscribe(
      // params=>{
      //     this.selectId=parseInt(params.get('id'));
      // }  
      // )
      
      this._activatedRoute.paramMap.subscribe(
        params=>{
          this.selectId=(params.get('id'));
        }
      )
      
      this._service.fetchAccountsByUserId(this.selectId).subscribe(
        data=>{
          console.log("Data received");
          this.accountData=data;
        },
        error=>{
          console.log("exception occured");
        }
      )
      console.log(this.selectId);
  }


  goToDeleteAccountDetails(id:number){
    console.log('ID : ',id);
    this._service.deleteAccountDetails(id).subscribe(
      data=>console.log("response received"),
      error=>console.log("exception occured")
    )
    window.location.reload();
  }


  goToEditAccountDetails(id:number){
    console.log('ID : ',id);
    this._route.navigate(['/editAccount',id]);
  }

}
