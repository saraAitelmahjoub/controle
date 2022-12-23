import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  produits :any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8888/PRODUIT-SERVICE/produits?projection=allfacture").subscribe(
      {
        next:(data)=>{
            this.produits=data;
        },
        error:(err)=>{}
      }
    );
  }

}
