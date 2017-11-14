import { Component, OnInit } from '@angular/core';
import { Follow,followers } from './following';
import { Author } from '../author/author';
import { TempAuthorService } from '../author/temp-author.service';
import { ArticleService,Article } from '../article/article.service';
import {Comment} from '../article/comment'
import { LoginService } from '../landing/login/login.service';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
  providers:[ ArticleService,LoginService ],
})
export class MainComponent implements OnInit {
  temp_follow:Follow[]=followers;
  newStatus:string;
  followName:string;
  article:string;
  articles:Article[];
  id:number=1;
  filter:string='';
  Err:any=false;
  imgSrc:string;
  editAtc:string;
  constructor(private tempAuthor:TempAuthorService, private articleService:ArticleService,private AllUsers:LoginService) {
    //localStorage.clear();
    if(localStorage.getItem('articles')!=null)
    {
      this.articles=JSON.parse(localStorage.getItem("articles"));
    }
    else{
      this.articleService.getArticles().then(articles =>{this.articles=articles;localStorage.setItem('articles',JSON.stringify(articles));});

    }
  }


  ngOnInit() {
  }
  handelImg(event)
  {

    var file = event.target.files[0];
    var reader = new FileReader();
    reader.onload = ((e:any)=>{
       this.imgSrc=e.target.result;
    })
    reader.readAsDataURL(file);
  }
  addComment(article:Article)
  {
    let result;
    result=prompt("your comment", "");
    if(result!=null)
    {
      let comment=new Comment();
      comment.text=result;
      comment.author=this.tempAuthor.temp.displayName;
      article.comments.unshift(comment);
      localStorage.setItem('articles',JSON.stringify(this.articles));
    }

  }
  editCom(com:Comment)
  {
    let result;
    result=prompt("the comment", com.text);
    if(result!=null)
    {
      com.text=result;
      localStorage.setItem('articles',JSON.stringify(this.articles));
    }

  }
  edit(article:Article)
  {
    this.editAtc=article.text;

    let edit=document.getElementById("edit"+article._id);
    edit.style.display = 'block';

  }
  save(article:Article)
  {
    
    article.text=this.editAtc;
    //console.log(txt);
    localStorage.setItem('articles',JSON.stringify(this.articles));
    let edit=document.getElementById("edit"+article._id);
    edit.style.display = 'none';
  }
  logOut(){
    localStorage.clear();

  }
  updateStatus()
  {
    this.tempAuthor.setStatus(this.newStatus);
  }
  unfollow(i:number)
  {
    this.temp_follow.splice(i, 1);
  }
  addFollow()
  {
    if(this.AllUsers.getUserByDisplayName(this.followName)!=undefined)
    {
      this.temp_follow.unshift({
        displayName:this.followName,
        status :this.AllUsers.getUserByDisplayName(this.followName).status,
        image:this.AllUsers.getUserByDisplayName(this.followName).img,
      })
      this.Err=false;
    }
    else
    {
      this.Err="the author is not exist"
    }
  }
  clearPost()
  {
    this.article="";
  }
  postArticle()
  {
    this.articles.unshift({_id:this.id,
    text:this.article,
    date:new Date().toString(),
    img:this.imgSrc,
    comments:[],
    author:this.tempAuthor.temp.displayName})
    this.id=this.id+1;
    this.article="";
    //console.log(document.getElementById("articleImg").innerHTML);
    localStorage.setItem('articles',JSON.stringify(this.articles));
  }
  isDisplayed(article:Article)
  {
    if((this.temp_follow.find(follow=>follow.displayName===article.author)!=undefined||article.author==this.tempAuthor.temp.displayName)&&article.author.indexOf(this.filter)!=-1||this.filter==''||article.text.indexOf(this.filter)!=-1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  clearSearch()
  {
    this.filter='';
  }
  showComment(article:Article)
  {

    let comment=document.getElementById("comment"+article._id);
    let button=document.getElementById("button"+article._id);
    if(comment.style.display == 'none')
    {
      button.innerHTML="hide comment";
      comment.style.display = 'block';
    }
    else
    {
      button.innerHTML="show comment";
      comment.style.display = "none";
    }
  }
  setfilter(filter:string)
  {this.filter=filter;}

}
