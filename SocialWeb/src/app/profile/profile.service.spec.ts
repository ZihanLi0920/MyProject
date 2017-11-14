import { TestBed, inject } from '@angular/core/testing';

import { ProfileService,fetchProfile,updateHeadline } from './profile.service';
import fetchMock from 'fetch-mock';
import { expect } from 'chai';
import { url,resource} from '../actions.service';

describe('Validate Profile actions', () => {
  const fetchMock=require('fetch-mock');
  const add = (tag, id, value) => {
      const el = document.createElement(tag)
      el.id = id
      el.value = value
      el.style = { display: 'inline' }
      document.body.appendChild(el)
      return el
  }
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProfileService]
    });
  });
  afterEach(() => {

       fetchMock.restore();
    });

    it("should fetch the user's profile information ",(done)=>{
      const Author={accountName:"Zihan",
      displayName:"",
      emailAdress:"",
      phoneNumber:"",
      birthDate:"",
      password:"",
      zipcode:"",
      status:"have no status, please update",
      img:"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507572013428&di=e5d9261436c13e5b0d76df63393583fc&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201302%2F01%2F20130201193706_FyAxP.thumb.700_0.jpeg"};

      fetchMock.mock(`${url}/profile`, {
          method: 'GET',
          headers: { 'Content-Type': 'application/json' },
          body: {
              Author
          }
       }).spy();
       fetchProfile()
       .then(r=>{expect(r.Author).to.eql(Author)})
       .then(done);

     });
     it("should update headline",(done)=>{
       const headline="this is a new headline"
       let div=add('div','message','old headline');
       fetchMock.mock(`${url}/headline`, {
           method: 'POST',
           headers: { 'Content-Type': 'application/json' },
           body: {
               status:'success'
           }
        }).spy();
        updateHeadline(headline)
        .then(r=>{expect(div.innerHTML).to.eql('your new headline is: this is a new headline');document.body.removeChild(div);})
        .then(done);

      });
});
