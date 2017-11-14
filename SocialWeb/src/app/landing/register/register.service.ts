import { Injectable } from '@angular/core';

@Injectable()
export class RegisterService {
  nameExp:RegExp=new RegExp(/^[a-zA-Z][0-9a-zA-Z]*$/);
  emailExp:RegExp=new RegExp(/^[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$/);
  //dateExp:RegExp=new RegExp(/^\d\d-\d\d-\d\d\d\d$/);
  phoneExp:RegExp=new RegExp(/^\d\d\d-\d\d\d-\d\d\d\d$/);
  zipExp:RegExp=new RegExp(/^\d\d\d\d\d$/);
  now:Date;
  constructor() { }
  validateName(name:string):boolean|string{
    if(name.length==0)
    {
      return "please input account name";
    }
    if(!this.nameExp.test(name))
    {
      return "please input valid name";
    }
    return false;
  }
  validateEmail(email:string):boolean|string{
    if(email.length==0)
    {
      return "please input your email";
    }
    if(!this.emailExp.test(email))
    {
      return "please input valid email "
    }
    return false;
  }
  validatePhone(phone:string):boolean|string{
    if(phone.length==0)
    {
      return "please input your phone";
    }
    if(!this.phoneExp.test(phone))
    {
      return "please input valid phone "
    }
    return false;
  }
  validateZip(zipcode:string):boolean|string{
    if(zipcode.length==0)
    {
      return "please input your zipcode";
    }
    if(!this.zipExp.test(zipcode))
    {
      return "please input valid zipcode "
    }
    return false;
  }
  validateDate(dates:string):boolean|string{

    this.now=new Date();


    if(this.now.getFullYear()-parseInt(dates.split('-')[0])<18)
    {
      return "Only individuals 18 yueas of age or older can register"
    }
    if(this.now.getFullYear()-parseInt(dates.split('-')[0])==18)
    {
      if(this.now.getMonth()+1-parseInt(dates.split('-')[1])<0)
      {
        return "Only individuals 18 yueas of age or older can register"
      }
      if(this.now.getMonth()+1==parseInt(dates.split('-')[1]))
      {
        if(this.now.getDate()<parseInt(dates.split('-')[2]))
        {
          return "Only individuals 18 yueas of age or older can register"
        }
      }
    }
    return false;
  }
  validatePassword(password:string,confirmPw:string):boolean|string{
    if(password.length==0)
    {
      return "please input your password";
    }
    if(password!=confirmPw)
    {
      return 'confirm password must be the same as password';
    }
    return false;
  }

}
