import { Component, ElementRef, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { NgserviceService } from '../ngservice.service';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})



export class SignUpComponent implements OnInit, OnChanges {
  user = new User();
  Current_date: any;
  User_date: any;
  dateDiff : boolean = false; 

  // @ViewChild('name6') name6Ref: ElementRef ;

  // @ViewChild('name6', { static:false}) name6Ref: ElementRef ;
  // @ViewChild('name6')  #name6  { 
  // };


  constructor(private _service: NgserviceService, private router: Router, private toastr: ToastrService) {

  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log("Diff bool value : ", this.getDateDifference());
    this.dateDiff = this.getDateDifference();
    this.getDateDifference();
  }

  ngOnInit(): void {
    // this.Current_date = Date.now();

    // console.log("this current date : "+ this.Current_date)

    this.getCurrentDate();

  }

  addUserFormSubmit(addUserForm: any) {
    if (this.user.gender == null)
      this.user.gender = "M"
    console.log("User : ", this.user, " User entered date : " + this.user.dob);

    
    this.User_date = this.user.dob;


    this._service.addNewUser(this.user).subscribe(data => {
      console.log("data : "+data);
      if (data != null) 
      {
        this.toastr.success("Successfully added", "Success");
        this.router.navigate(['/login']);
      } 
      else 
      {
        console.log("Sign up form error ...something is wrong filled");
        this.toastr.error("Invalid information filled", "Failure");
        this.router.navigate(['/register']);
      }
    });


    console.log("Diff bool value : ", this.getDateDifference());
    this.dateDiff = this.getDateDifference();
  }

  getCurrentDate() {
    const today = new Date();
    let yyyy1 = today.getFullYear();
    let mm1: any = today.getMonth() + 1; // Months start at 0!let dd = today.getDate();
    let dd1: any = today.getDate();

    if (dd1 < 10) dd1 = '0' + dd1;
    if (mm1 < 10) mm1 = '0' + mm1;

    const formattedToday = dd1 + '/' + mm1 + '/' + yyyy1;

    console.log("Formatted date : " + formattedToday)
    // document.getElementById('DATE').value = formattedToday;
    // this.Current_date = formattedToday;
    this.Current_date = today;
  }

  getDateDifference(): boolean {

    const today = new Date();
    let yyyy1 = today.getFullYear();
    let mm1: any = today.getMonth() + 1; // Months start at 0!let dd = today.getDate();
    let dd1: any = today.getDate();

    // const User_date = this.name6Ref;
    var date = new Date(this.User_date);
    // if (!isNaN(date.getTime())) {
    //   this.User_date = date.getMonth() + 1 + '/' + date.getDate() + '/' + date.getFullYear();
    // }

    console.log('today : ', today , ' selected date :', date)

    // let selectedDate = new Date(this.User_date);

    let yyyy2 = date.getFullYear();
    let mm2: any = date.getMonth() + 1; // Months start at 0!let dd = today.getDate();
    let dd2: any = date.getDate();


    if(yyyy2 > yyyy1)
    {
      return true;
    }
    else if(yyyy2 < yyyy1 )
    {
      return false;
    }
    else if(mm2 > mm1)
      return true;

    else if(mm2 < mm1)
      return false;

    else if ( dd2 > dd1 )
      return true;

    else
      return false;

  }
  // function format(inputDate) {

  // }
}

// this._service.addNewUser(this.user).subscribe(
//   data=>console.log("Data added successfully",this.user.dob),
//   error=>console.log("error occured")
// )
// console.log(addUserForm);
// this.router.navigate(['/login']);