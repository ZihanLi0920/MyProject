import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {  Author} from '../../author/author';
import 'rxjs/add/operator/toPromise';
import { url,resource} from '../../actions.service';
@Injectable()
export class LoginService {
  users:Author[];
  constructor(public http:Http) {
    this.http.get('../../../assets/users.json')
                 .toPromise()
                 .then(response => this.users=response.json().users );
               }
  validate(name:string,password:string):boolean|string{
    if(name.length==0)
    {
      return "name cannot be null";
    }
    if(this.users.find(user=>user.accountName===name)==undefined)
    {
      return "this is an illegal user";
    }
    if((this.users.find(user=>user.accountName===name)).password!=password)
    {
      return "please input the right password";
    }
    return false;
  }
  getUser(name:string):Author{
    return this.users.find(user=>user.accountName===name);
  }
  getUserByDisplayName(name:string):Author{
    return this.users.find(user=>user.displayName===name);
  }
}
export const login=(username,password)=>
{
  let message=document.querySelector("#message");
  return resource('POST','login',{username,password})
        .then(r=>{
          if(r.status=="success")
          {message.innerHTML="you have login as "+username;}
          else
          {message.innerHTML="it's an invalid user"}
        })
}
export const logout=()=>
{
  let message=document.querySelector("#message");
  return resource('POST','logout',undefined)
        .then(r=>{message.innerHTML="you have logged out";});
        //.catch(err=>message.innerHTML="it's an invalid user");
}
