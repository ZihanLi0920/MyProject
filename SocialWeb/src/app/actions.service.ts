import { Injectable } from '@angular/core';
//import { Router } from '@angular/router';
//import {  }


@Injectable()
export class ActionsService {

  constructor() { }
  updateErr(msg:string)
  {
    let message=document.querySelector("#message")
    message.className="Err";
    message.innerHTML=msg;
  }
  updateSuccess(msg:string)
  {
    let message=document.querySelector("#message")
    message.className="Success";
    message.innerHTML=msg;
  }

  navigateToMain()
  {
  //  console.log(this.router);
    //this.router.navigateByUrl('main');
    return {target:"/main"};
  }
  navigateToLanding()
  {
    //this.router.navigateByUrl('landing');
    return {target:"/landing"};
  }
  navigateToProfile()
  {
    return {target:"/profile"};
    //this.router.navigateByUrl('profile');
  }

}
export const url = 'https://webdev-dummy.herokuapp.com';
export const resource = (method, endpoint, payload) => {
  const options :RequestInit =  {
    method,
    credentials: 'include',
    headers: {
      'Content-Type': 'application/json'
    },
    body:''
  }
  if (payload) options.body = JSON.stringify(payload)

  return fetch(`${url}/${endpoint}`, options)
    .then(r => {
      if (r.status === 200) {
        //console.log(r);
        if (r.headers.get('Content-Type').indexOf('json') > 0) {
                    return r.json();
                } else {
                    return r.text();
                }
      } else {
        // useful for debugging, but remove in production
        console.error(`${method} ${endpoint} ${r.statusText}`)
        throw new Error(r.statusText)
      }
    })
}
