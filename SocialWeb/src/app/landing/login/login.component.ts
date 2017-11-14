import { Component, OnInit } from '@angular/core';
import { Author } from '../../author/author';
import { TempAuthorService } from '../../author/temp-author.service';
import { LoginService } from './login.service';
//import { ActionsService } from '../../actions.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService],
})
export class LoginComponent implements OnInit {

  name:string="";
  password:string='';
  //nameErr:any;
  Err:any;
  constructor(private tempAuthor:TempAuthorService,  private loginService:LoginService,public router:Router,) { }

  ngOnInit() {
  }
  login()
  {
    this.Err=this.loginService.validate(this.name,this.password);
    //this.pwErr=this.loginService.validatePassword(this.password);
    if(this.Err===false)
    {

      this.tempAuthor.setTemp(this.loginService.getUser(this.name));
      //this.tempAuthor.setPassword(this.password);
      //this.action.navigateToMain();
      this.router.navigateByUrl('main');
    }


  }

}
