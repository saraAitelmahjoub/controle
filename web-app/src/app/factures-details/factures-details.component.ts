import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-factures-details',
  templateUrl: './factures-details.component.html',
  styleUrls: ['./factures-details.component.css']
})
export class FacturesDetailsComponent implements OnInit {
  facturedatail :any;
  factureId!:any;
  constructor(private http:HttpClient,private router:Router,private route:ActivatedRoute) {
    this.factureId=route.snapshot.params['factureId'];
  }

  ngOnInit(): void {
    this.http.get("/FACTURE-SERVICE/allfacture/"+this.factureId).subscribe({
      next:(data)=>{
        this.facturedatail=data;
      },
      error:(err)=>{}
    });

  }

}
