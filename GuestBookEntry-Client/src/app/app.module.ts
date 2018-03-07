import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { EntryService } from './shared/entry/entry.service';
import { EntryListComponent } from './entry-list/entry-list.component';
import { MatButtonModule, MatCardModule, MatTableModule, MatGridListModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GiphyService } from './shared/giphy/giphy.service';
import { EntryEditComponent } from './entry-edit/entry-edit.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { OktaAuthModule, OktaCallbackComponent } from '@okta/okta-angular';
import { AuthInterceptor } from './shared/okta/auth.interceptor';
import { HomeComponent } from './home/home.component';
import { EntrySearchComponent } from './entry-search/entry-search.component';


const appRoutes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'entry-list',
    component: EntryListComponent
  },
  {
    path: 'entry-add',
    component: EntryEditComponent
  },
  {
    path: 'entry-edit/:id',
    component: EntryEditComponent
  },
  {
    path: 'entry-search',
    component: EntrySearchComponent
  },
  {
    path: 'implicit/callback',
    component: OktaCallbackComponent
  }
];

const config = {
  issuer: 'https://dev-607296.oktapreview.com',
  redirectUri: 'http://localhost:4200/implicit/callback',
  clientId: '0oae8kdcyrffRNTLb0h7'
};

@NgModule({
  declarations: [
    AppComponent,
    EntryListComponent,
    EntryEditComponent,
    HomeComponent,
    EntrySearchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    OktaAuthModule.initAuth(config),
    MatGridListModule,
    MatTableModule
  ],
  providers: [EntryService, GiphyService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
