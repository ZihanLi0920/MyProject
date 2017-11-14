import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { url,resource} from '../actions.service';
import {Comment} from './comment';
export class Article{
  _id:number;
  text:string;
  date:string;
  img:string;
  comments:Comment[];
  author:string;
}
@Injectable()
export class ArticleService {
  //articles:Article[];
  constructor(public http:Http) {
  //this.http.get('../../assets/article.json').map(res=>console.log("here"));
  }
  getArticles()
  {
    return this.http.get('../../assets/article.json')
                 .toPromise()
                 .then(response => response.json().articles as Article[]);

    //console.log(this.articles);
  }

}
export const fetchArticles=()=>{

  return resource('GET','articles',undefined)

}
export const updateSearchKey=(key)=>
{
  return key;
}
