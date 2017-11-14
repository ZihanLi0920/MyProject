import { Component, OnInit } from '@angular/core';
import { TempAuthorService } from '../../author/temp-author.service';
import { Author } from '../../author/author';
import { RegisterService } from './register.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers:[RegisterService],
})
export class RegisterComponent implements OnInit {

  author:Author={accountName:"",displayName:"",emailAdress:"",zipcode:"",birthDate:"",password:"",phoneNumber:"",status:"have no status, please update",img:"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507572013428&di=e5d9261436c13e5b0d76df63393583fc&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201302%2F01%2F20130201193706_FyAxP.thumb.700_0.jpeg"};
  nameErr:any;
  zipErr:any;
  emailErr:any;
  phoneErr:any;
  dateErr:any;
  pwErr:any;
  confirmPw:string;
  year:number;
  month:number;
  day:number;
  message:string;
  constructor(private registerService:RegisterService,  public router:Router, private tempAuthor:TempAuthorService) { }

  ngOnInit() {
  }
  register()
  {
    //this.author.birthDate=new Date(this.year,this.month-1,this.day);
    //console.log(this.author.birthDate);
    this.message="";
    this.nameErr=this.registerService.validateName(this.author.accountName);
    this.zipErr=this.registerService.validateZip(this.author.zipcode);
    this.emailErr=this.registerService.validateEmail(this.author.emailAdress);
    this.phoneErr=this.registerService.validatePhone(this.author.phoneNumber);
    this.dateErr=this.registerService.validateDate(this.author.birthDate);
    this.pwErr=this.registerService.validatePassword(this.author.password,this.confirmPw);
    if(!this.nameErr&&!this.zipErr&&!this.emailErr&&!this.phoneErr&&!this.dateErr&&!this.pwErr)
    {
      //this.tempAuthor.setTemp(this.author);
      //this.router.navigateByUrl('main');
      this.message="you have registered successfully";
    }
  }

}
