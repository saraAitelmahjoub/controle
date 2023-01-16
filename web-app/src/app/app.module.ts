import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProduitsComponent } from './produits/produits.component';
import {HttpClientModule} from "@angular/common/http";
import { ClientComponent } from './client/client.component';
import { FacturesComponent } from './factures/factures.component';
import { FacturesDetailsComponent } from './factures-details/factures-details.component';

@NgModule({
  declarations: [
    AppComponent,
    ProduitsComponent,
    ClientComponent,
    FacturesComponent,
    FacturesDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
