import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AppComponent } from '../app.component';
import { RouterModule, Routes} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { routes } from '../app.module';
import { LandingComponent } from '../landing/landing.component';
//import { MainComponent } from './main.component';
import { ProfileComponent } from '../profile/profile.component';
import { RegisterComponent } from '../landing/register/register.component';
import { LoginComponent } from '../landing/login/login.component';
import { MainComponent } from './main.component';
import { HttpModule } from '@angular/http';
import { ActionsService } from '../actions.service';
import { TempAuthorService } from '../author/temp-author.service';
import { By } from '@angular/platform-browser'
import { expect } from 'chai';
//import { go, sleep, findId, findCSS, By } from './selenium'
describe('Articles View', () => {
  let component: MainComponent;
  let fixture: ComponentFixture<MainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        MainComponent,
        LandingComponent,
        ProfileComponent,
        RegisterComponent,
        LoginComponent,
      ],
      imports: [FormsModule,HttpModule,RouterModule.forRoot(routes,{useHash:true})],
      providers:[TempAuthorService,ActionsService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should filter displayed articles by the search keyword', () => {
    //expect(component).toBeTruthy();
    //driver.findElement(webdriver.By.id('searchKeyword')).sendKeys('zihan');
    //document.querySelector("#searchKeyword").sendKeys("zihan");
  //
    //console.log(component.getfilter());
    //done();
    const article={_id:3898687,text:"Vivamus laoreet. Nullam tincidunt adipiscing enim. Phasellus tempus. Proin viverra, ligula sit amet ultrices semper, ligula arcu tristique sapien, a accumsan nisi mauris ac eros. Fusce neque. Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus, vitae iaculis lacus elit id tortor. Vivamus aliquet elit ac nisl. Fusce fermentum odio nec arcu. Vivamus euismod mauris. In ut quam vitae odio lacinia tincidunt. Praesent ut ligula non mi varius sagittis. Cras sagittis. Praesent ac sem eget est egestas volutpat. Vivamus consectetuer hendrerit lacus. Cras non dolor. Vivamus in erat ut urna cursus vestibulum. Fusce commodo aliquam arcu. Nam commodo suscipit quam. Quisque id odio. Praesent venenatis metus at tortor pulvinar varius.",date:"2015-07-09T09:40:02.675Z",img:"http://lorempixel.com/318/283/",comments:["comments1","comment2"],author:"Jany"}
    component.setfilter('Jany');

    fixture.detectChanges();
    expect(component.isDisplayed(article)).to.eql(true);
    component.setfilter('Cindy');
    expect(component.isDisplayed(article)).to.eql(false);
    //component.postArticle();
  //  expect(fixture.debugElement.queryAll(By.css('#articles')).length).to.equal(2);


  });
  it('should render articles', () => {

    expect(fixture.debugElement.queryAll(By.css('#articles')).length>0).to.equal(true);

  });
  it('should dispatch actions to create a new article', () => {
    const num=fixture.debugElement.queryAll(By.css('#articles')).length
    component.postArticle();
    fixture.detectChanges();
    expect(fixture.debugElement.queryAll(By.css('#articles')).length).to.equal(num+1);

  });

});
