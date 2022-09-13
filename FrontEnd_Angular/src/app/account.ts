import { User } from "./user";

export class Account{
    account_id!: number;
    branch_Name!: string;
    account_type!: string;
    account_balance!: number;
    user_ID!:number;
    
    //user_ID!: User;

    // constructor(userResponse:any){
    //     this.Name=userResponse.Name;
    //     this.Email_ID=userResponse.Email_ID;
    //     this.Mobile_number=userResponse.Mobile_number;
    //     this.Secondary_Mobile=userResponse.Secondary_Mobile;
    //     this.DOB=userResponse.DOB; 
    //     this.Gender=userResponse.Gender;
    // }
}