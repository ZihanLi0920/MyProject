import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AppComponent } from '../app.component';
import { RouterModule, Routes} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { routes } from '../app.module';
import { LandingComponent } from '../landing/landing.component';
import { RegisterComponent } from '../landing/register/register.component';
import { LoginComponent } from '../landing/login/login.component';
import { MainComponent } from '../main/main.component';
import { HttpModule } from '@angular/http';
import { ActionsService } from '../actions.service';
import { TempAuthorService } from '../author/temp-author.service';
import { ProfileComponent } from './profile.component';

/*describe('ProfileComponent', () => {
  let component: ProfileComponent;
  let fixture: ComponentFixture<ProfileComponent>;

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
    fixture = TestBed.createComponent(ProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});*/
