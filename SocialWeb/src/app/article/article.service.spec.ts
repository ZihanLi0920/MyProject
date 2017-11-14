import { TestBed, inject } from '@angular/core/testing';
import { HttpModule } from '@angular/http';
import { ArticleService,fetchArticles,updateSearchKey } from './article.service';
import fetchMock from 'fetch-mock';
import { expect } from 'chai';
import { url,resource} from '../actions.service';

describe('Validate Article actions', () => {
  const fetchMock=require('fetch-mock');
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ArticleService],
      imports:[HttpModule,]
    });
  });
  afterEach(() => {

       fetchMock.restore();
    });

  /*it('should be created', inject([ArticleService], (service: ArticleService) => {
    expect(service).toBeTruthy();
  }));*/
  it("should fetch articles ",(done)=>{
    const articles=[{_id:3898687,text:"Vivamus laoreet. Nullam tincidunt adipiscing enim. Phasellus tempus. Proin viverra, ligula sit amet ultrices semper, ligula arcu tristique sapien, a accumsan nisi mauris ac eros. Fusce neque. Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus, vitae iaculis lacus elit id tortor. Vivamus aliquet elit ac nisl. Fusce fermentum odio nec arcu. Vivamus euismod mauris. In ut quam vitae odio lacinia tincidunt. Praesent ut ligula non mi varius sagittis. Cras sagittis. Praesent ac sem eget est egestas volutpat. Vivamus consectetuer hendrerit lacus. Cras non dolor. Vivamus in erat ut urna cursus vestibulum. Fusce commodo aliquam arcu. Nam commodo suscipit quam. Quisque id odio. Praesent venenatis metus at tortor pulvinar varius.",date:"2015-07-09T09:40:02.675Z",img:"http://lorempixel.com/318/283/",comments:[],author:"Follower"}]

    fetchMock.mock(`${url}/articles`, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' },
        body: {
            articles
        }
     }).spy();
     fetchArticles()
     .then(r=>{expect(r.articles.length>0).to.eql(true);expect(r.articles[0]._id).to .eql(3898687)})
     .then(done);

   });
   it("should update the search keyword ",(done)=>{
     expect(updateSearchKey("aaa")).to.eql("aaa");
     done();
    });
});
