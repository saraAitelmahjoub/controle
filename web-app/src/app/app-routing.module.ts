import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProduitsComponent} from "./produits/produits.component";
import {ClientComponent} from "./client/client.component";
import {FacturesComponent} from "./factures/factures.component";
import {FacturesDetailsComponent} from "./factures-details/factures-details.component";


const routes: Routes = [
  {
    path:"produits",
    component: ProduitsComponent
  },
  {
    path:"clients",
    component: ClientComponent
  },
  {
    path:"factures/:clientId",
    component: FacturesComponent
  },
  {
    path:"allfacture/:factureId",
    component: FacturesDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
