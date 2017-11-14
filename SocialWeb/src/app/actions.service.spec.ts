import { TestBed, inject,async } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { url,resource,ActionsService} from './actions.service';
import { expect } from 'chai';
import { RouterModule, Routes} from '@angular/router';
import { routes } from './app.module';
import { LandingComponent } from './landing/landing.component';
import { MainComponent } from './main/main.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './landing/register/register.component';
import { LoginComponent } from './landing/login/login.component';

import fetchMock from 'fetch-mock';
import{ Router} from '@angular/router';


describe('Validate actions ', () => {
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

      declarations: [
        MainComponent,
        LandingComponent,
        ProfileComponent,
        RegisterComponent,
        LoginComponent,

      ],
      providers: [ActionsService],
      imports: [FormsModule,RouterModule.forRoot(routes,{useHash:true})]
    });

  });
   afterEach(() => {

        fetchMock.restore();
     });
  it("resource should be resource",(done)=>{
    fetchMock.mock(`${url}/user`, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' },
        body: {
            username:"Zihan"
        }
     }).spy();
     resource('GET','user',undefined).then(r=>{expect(r.username).to.eql("Zihan")}).then(done);
     //fetch(`${url}/user`).then(r=>{return r.json()}).then(r=>console.log(r)).then(done);
  })
  it("resource should give me http error",(done)=>{
    fetchMock.mock(`${url}/user`, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' },
        body: {
            username:"Zihan"
        }
     }).spy();
     resource('GET','users',undefined).catch(err=>{expect(err).to.not.be.a('null')}).then(done);
     //fetch(`${url}/user`).then(r=>{return r.json()}).then(r=>console.log(r)).then(done);
  })
  it("resource should be Postable",(done)=>{
    fetchMock.mock(`${url}/login`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: {
            username:"Zihan", password:"123-123-1234"
        }
     }).spy();
     resource('POST','login',undefined)
     .then(r=>{expect(r).to.eql({  username:"Zihan", password:"123-123-1234"})}).then(done);
     //fetch(`${url}/user`).then(r=>{return r.json()}).then(r=>console.log(r)).then(done);
  })
  it("should update error message",(done)=>{
     let div=add('div','message','hello');
     let service=new ActionsService();
     service.updateErr('This is wrong message')
     expect(div.innerHTML).to.eql('This is wrong message');
     expect(div.className).to.eql('Err');
     document.body.removeChild(div);
     done();
  })
  it("should update success message",(done)=>{
     let div=add('div','message','hello');
     let service=new ActionsService();
     service.updateSuccess('This is success message')
     expect(div.innerHTML).to.eql('This is success message');
     expect(div.className).to.eql('Success');
     document.body.removeChild(div);
     done();
  })
  it("should navigate",(done)=>{
     let service=new ActionsService();
     expect(service.navigateToMain().target).to.eql('/main');
     expect(service.navigateToLanding().target).to.eql('/landing');
     expect(service.navigateToProfile().target).to.eql('/profile');
     done();

  })




});
