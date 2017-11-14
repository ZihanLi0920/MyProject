import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { LandingComponent } from './landing/landing.component';
import { ProfileComponent } from './profile/profile.component';
import { RouterModule, Routes} from '@angular/router';
import { RegisterComponent } from './landing/register/register.component';
import { LoginComponent } from './landing/login/login.component';
import { TempAuthorService } from './author/temp-author.service';
import { ActionsService } from './actions.service';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';
//import { fakeBackendProvider } from './fake-backend';

/*export const landingRouts: Routes=[{path:'', redirectTo: 'login', pathMatch: "full"},
{path: 'login', component: LoginComponent},
{path: 'register', component: RegisterComponent},]*/
export const routes: Routes = [{path:'', redirectTo: 'landing', pathMatch: "full"},
//{path: 'landing', component: LandingComponent,children:landingRouts},
{path: 'landing', component: LandingComponent},
{path: 'main', component: MainComponent},
{path: 'profile', component: ProfileComponent},]
@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LandingComponent,
    ProfileComponent,
    RegisterComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes,{useHash:true}),
    FormsModule,
    HttpModule,
  ],
  providers: [TempAuthorService,ActionsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
