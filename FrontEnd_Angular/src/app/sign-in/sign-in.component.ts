import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgserviceService } from '../ngservice.service';
import { User } from "../user";
import { ToastrService } from 'ngx-toastr';

@Component({

  selector: 'app-sign-in',

  templateUrl: './sign-in.component.html',

  styleUrls: ['./sign-in.component.css']

})
export class SignInComponent implements OnInit {

  user = new User();

  userData: any = [];

  // 
  constructor(private _service: NgserviceService, private router: Router, private toastr: ToastrService) {

  }



  ngOnInit(): void {
  }

  loginUserFormSubmit(verifyUserForm: any) {

    // data=>console.log("data added successfully"),
    // error=>console.log("error occured")
      console.log("User ID : "+this.user.email_ID)
      let userData = this._service.loginCheck(this.user).subscribe(data => {

      this.userData = data;

      console.log(data);

      if (data != null) {

        //localStorage.setItem('user_id',JSON.stringify(this.user.user_ID));

        window.localStorage.setItem('userDetails', JSON.stringify(data));

        this.toastr.success("Successfully logged in", "Success");

        this.router.navigate(['/getUsers']);

      } else {

        console.log("invalid credentials");

        this.toastr.error("Invalid credentials", "Failure");

        this.router.navigate(['/login']);

      }

    });

    console.log(userData);

    console.log(verifyUserForm);
  }

}
