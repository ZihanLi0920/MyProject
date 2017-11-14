import { Injectable } from '@angular/core';
import { Author } from './author';
//import { Headers, Http } from '@angular/http';
//import 'rxjs/add/operator/toPromise';
@Injectable()
export class TempAuthorService {
  temp:Author={
    accountName:"Zihan Li",
    displayName:"Zihan Li",
    emailAdress:"qq@rice.edu",
    phoneNumber:"123-123-1234",
    birthDate:"1999-9-20",
    password:"abc",
    zipcode:"77005",
    status:"have no status, please update",
    img:"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508202875&di=5ef52efdc9110cf55ff5b913de17da76&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.t-ji.net%2FtujiJDAxJDIyL1RCMXNrUF9HViQ2Y2dYRiQ1JDM.jpg"
  };
  constructor() {
    if(localStorage.getItem("tempAuthor")!=null)
    {
      this.temp=JSON.parse(localStorage.getItem("tempAuthor"));
    }
    else
    {
      localStorage.setItem("tempAuthor",JSON.stringify(this.temp));
    }
  }
  setTemp(author:Author)
  {
    this.temp=author;
    localStorage.setItem("tempAuthor",JSON.stringify(this.temp));

  }
  changeImg(img:string)
  {
    this.temp.img=img;
    localStorage.setItem("tempAuthor",JSON.stringify(this.temp));
  }
  setName(name:string)
  {
    this.temp.displayName=name;
    localStorage.setItem("tempAuthor",JSON.stringify(this.temp));


  }
  setStatus(status:string)
  {
    this.temp.status=status;
    localStorage.setItem("tempAuthor",JSON.stringify(this.temp));
  }
  setPassword(pw:string)
  {
    this.temp.password=pw;
    localStorage.setItem("tempAuthor",JSON.stringify(this.temp));

  }

}
