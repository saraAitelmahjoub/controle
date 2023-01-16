import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-factures',
  templateUrl: './factures.component.html',
  styleUrls: ['./factures.component.css']
})
export class FacturesComponent implements OnInit {
facture :any;
clientID!:number;
  constructor(private http:HttpClient,private router:Router,private route:ActivatedRoute) {
    this.clientID=route.snapshot.params['clientId'];
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8888/FACTURE-SERVICE/factures/search/byClientId?projection=allfacture&clientId="+this.clientID).subscribe({
      next:(data)=>{
          this.facture=data;
      },
        error:(err)=>{}
    });

  }
  getFactureDetail(fdtail:any){
    this.router.navigateByUrl("/allfacture/"+fdtail.facture);
    console.log(fdtail);

  }
}
