import { Injectable } from '@angular/core';
import { Author } from '../author/author';
import { url,resource} from '../actions.service';
@Injectable()
export class ProfileService {
  author:Author={accountName:"",
  displayName:"",
  emailAdress:"",
  phoneNumber:"",
  birthDate:"",
  password:"",
  zipcode:"",
  status:"have no status, please update",
  img:"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507572013428&di=e5d9261436c13e5b0d76df63393583fc&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201302%2F01%2F20130201193706_FyAxP.thumb.700_0.jpeg"};
  nameErr:any=false;
  emailErr:any=false;
  phoneErr:any=false;
  zipErr:any=false;
  pwErr:any=false;
  nameExp:RegExp=new RegExp(/^[a-zA-Z][0-9a-zA-Z]*$/);
  emailExp:RegExp=new RegExp(/^[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$/);
  phoneExp:RegExp=new RegExp(/^\d\d\d-\d\d\d-\d\d\d\d$/);
  zipExp:RegExp=new RegExp(/^\d\d\d\d\d$/);

  constructor() { }
  initial()
  {
    this.nameErr=false;
    this.emailErr=false;
    this.phoneErr=false;
    this.zipErr=false;
    this.pwErr=false;
  }
  validateName(){
    if(this.author.displayName.length==0)
    {
       this.nameErr="please input display name";
    }
    else{
      if(!this.nameExp.test(this.author.displayName))
      {
        this.nameErr="please input valid name";
      }
      else{
        this.nameErr=false;
      }
    }
  }
  validateEmail(){
    if(this.author.emailAdress.length==0)
    {
       this.emailErr= "please input your email";
    }
    else{
      if(!this.emailExp.test(this.author.emailAdress))
      {
        this.emailErr="please input valid email";
      }
      else{
        this.emailErr=false;
      }
    }
  }
  validatePhone(){
    if(this.author.phoneNumber.length==0)
    {
      this.phoneErr="please input your phone";
    }
    else{
      if(!this.phoneExp.test(this.author.phoneNumber))
      {
        this.phoneErr="please input valid phone "
      }
      else{
        this.phoneErr=false;
      }
    }
  }
  validateZip(){
    if(this.author.zipcode.length==0)
    {
      this.zipErr= "please input your zipcode";
    }
    else{
      if(!this.zipExp.test(this.author.zipcode))
      {
        this.zipErr= "please input valid zipcode "
      }
      else
      {this.zipErr= false;}
    }
  }
  validatePassword(){
    if(this.author.password.length==0)
    {
      this.pwErr="please input your password";
    }
    else{
      this.pwErr=false;
    }
  }

}
export const fetchProfile=()=>
{
  return resource('GET','profile',undefined)
}
export const updateHeadline=(headline)=>
{
  let message=document.querySelector('#message');
  return resource('POST','headline',{headline}).then(r=>message.innerHTML="your new headline is: "+headline)
}
