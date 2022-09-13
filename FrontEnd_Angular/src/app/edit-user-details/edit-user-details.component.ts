import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgserviceService } from '../ngservice.service';
import { User } from '../user';

@Component({
  selector: 'app-edit-user-details',
  templateUrl: './edit-user-details.component.html',
  styleUrls: ['./edit-user-details.component.css']
})
export class EditUserDetailsComponent implements OnInit {
  user= new User();

  constructor(private _route:Router,private _service:NgserviceService,private _activatedRoute:ActivatedRoute) { }

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
      this._service.fetchUserByID(this.selectId).subscribe(
        data=>{
          console.log("Data(user) received");
          this.user=data;
        },
        error=>{
          console.log("exception occured");
        }
      )
      console.log(this.selectId);
  }

  editUserFormSubmit(){
    this._service.editUserDetails(this.user).subscribe(
      data=>console.log("data updated successfully"),
      error=>console.log("error occured")
    )

    this._route.navigate(['/getUsers']);
  }
  

}
