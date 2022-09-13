import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Session } from '../session';
import { User } from '../user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit,OnChanges {
  user = new  User();
  showName!: string;

  @Input()
  session:any= Session;


  constructor(private router:Router,private toastr: ToastrService) 
  {


  }




  ngOnChanges(changes: SimpleChanges): void {
    // let u:any = window.localStorage.getItem('userDetails');
    // this.user = JSON.parse(u);
    // window.location.reload();
    // throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.session = new Session();
    let u:any = window.localStorage.getItem('userDetails');
    this.user = JSON.parse(u);
    
  }

  // ngOnChange():void
  // {
  // }

  logoutUser(){
    this.session.logout();
    console.log("localstorage is cleared")
    window.localStorage.clear();
    this.toastr.success("Successfully logged out", "Success");
    this.router.navigate(['/home'])
  }

  getCurrentName():string{
    // let u:any = window.localStorage.getItem('userDetails');
    // this.user = JSON.parse(u);
    this.user =JSON.parse(localStorage.getItem('userDetails')!);
    let myArray : string[];
    let showcase !: string ;
     if(this.user != null){
    //  console.log(this.getUserData.user_ID);
    //  console.log(this.getUserData.name);
    this.showName = this.user.name;
    myArray = this.showName.split(" ");
    showcase = myArray[0];
   }
   //myArray = text.split(" ");
   return showcase;

  }





}





