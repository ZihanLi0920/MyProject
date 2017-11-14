import { Component, OnInit } from '@angular/core';
import { TempAuthorService } from '../author/temp-author.service';
import { ProfileService } from './profile.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  providers:[ ProfileService],
})
export class ProfileComponent implements OnInit {
  inputObj : any;
  //imgSrc:string='https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508105808&di=5f9c1f8eb5a15ea3af313dd25b224781&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.25pp.com%2Fuploadfile%2Fapp%2Ficon%2F20151211%2F1449815285233804.jpg';

  constructor(private tempAuthor:TempAuthorService, private validate:ProfileService) {
  }

  ngOnInit() {
  }
  uploadImg()
  {

  }
  changePhoto(event)
  {
    var file = event.target.files[0];
    var reader = new FileReader();
    reader.onload = ((e:any)=>{
       this.tempAuthor.changeImg(e.target.result);
    })
    reader.readAsDataURL(file);
  }
  update()
  {
    this.validate.initial();
    if(this.validate.author.displayName!=this.tempAuthor.temp.displayName&&this.validate.author.displayName!='')
    {
      this.validate.validateName();
    }
    if(this.validate.author.zipcode!=this.tempAuthor.temp.zipcode&&this.validate.author.zipcode!='')
    {
      this.validate.validateZip();
    }
    if(this.validate.author.phoneNumber!=this.tempAuthor.temp.phoneNumber&&this.validate.author.phoneNumber!='')
    {
      this.validate.validatePhone();
    }
    if(this.validate.author.emailAdress!=this.tempAuthor.temp.emailAdress&&this.validate.author.emailAdress!='')
    {
      this.validate.validateEmail();
    }
    if(this.validate.author.password!=this.tempAuthor.temp.password&&this.validate.author.password!='')
    {
      this.validate.pwErr="password will not change"
    }
    if(!this.validate.nameErr&&!this.validate.emailErr&&!this.validate.phoneErr&&!this.validate.zipErr&&!this.validate.pwErr)
    {
      if(this.validate.author.displayName!='')
        {this.tempAuthor.temp.displayName=this.validate.author.displayName;}
      if(this.validate.author.zipcode!='')
        {this.tempAuthor.temp.zipcode=this.validate.author.zipcode;}
      if(this.validate.author.phoneNumber!='')
        {this.tempAuthor.temp.phoneNumber=this.validate.author.phoneNumber;}
      if(this.validate.author.emailAdress!='')
        {this.tempAuthor.temp.emailAdress=this.validate.author.emailAdress;}
      if(this.validate.author.password!='')
        {this.tempAuthor.temp.password=this.validate.author.password;}


    }
  }



}
