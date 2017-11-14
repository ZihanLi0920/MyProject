import { TestBed, inject } from '@angular/core/testing';
import { HttpModule } from '@angular/http';
import { LoginService,login,logout } from './login.service';
import { url,resource} from '../../actions.service';
import fetchMock from 'fetch-mock';
import { expect } from 'chai';
describe('Validate Authentication', () => {
  const add = (tag, id, value) => {
      const el = document.createElement(tag)
      el.id = id
      el.value = value
      el.style = { display: 'inline' }
      document.body.appendChild(el)
      return el
  }
  //const div=add('div','message','hello');
  const fetchMock=require('fetch-mock');
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoginService],
      imports:[HttpModule,]
    });
  });
  afterEach(() => {

       fetchMock.restore();
    });
    it("should log in a user",(done)=>{
      const username="zl58";
      const password="111-123-1234"
      let div=add('div','message','hello');
      fetchMock.mock(`${url}/login`, {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: {
              status:'success'
          }
       }).spy();
       login(username,password)
       .then(r=>{expect(div.innerHTML).to.eql('you have login as zl58');document.body.removeChild(div);})
       .then(done);

     });
     it("should not log in an invalid user",(done)=>{
       const username="invalidUser";
       const password="wrong"
       let div=add('div','message','hello');
       fetchMock.mock(`${url}/login`, {
           method: 'POST',
           headers: { 'Content-Type': 'application/json' },
           body: {
               status:'fail'
           }
        }).spy();
        login(username,password)
        .then(r=>{expect(div.innerHTML).to.eql("it's an invalid user");document.body.removeChild(div);})
        .then(done);
      });
      it("should log out a user",(done)=>{
        let div=add('div','message','you have login as zl58');
        fetchMock.mock(`${url}/logout`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body:{}
         }).spy();
         logout()
         .then(r=>{expect(div.innerHTML).to.eql("you have logged out");document.body.removeChild(div);})
         .then(done);

       });
})
