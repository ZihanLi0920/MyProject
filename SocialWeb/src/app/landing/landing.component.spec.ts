import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing.component';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { TempAuthorService } from '../author/temp-author.service';
import { ActionsService } from '../actions.service';
import { RouterModule, Routes} from '@angular/router';
import { routes } from '../app.module';
import { MainComponent } from '../main/main.component';
import { ProfileComponent } from '../profile/profile.component';
/*describe('LandingComponent', () => {
  let component: LandingComponent;
  let fixture: ComponentFixture<LandingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LandingComponent,  RegisterComponent,
        LoginComponent,MainComponent,ProfileComponent],
      imports: [FormsModule,  HttpModule,RouterModule.forRoot(routes,{useHash:true})],
      providers:[TempAuthorService,ActionsService]
    })
    .compileComponents();
  }));

  /*beforeEach(() => {
    fixture = TestBed.createComponent(LandingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});*/
