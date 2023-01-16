import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
    clients : any;
  constructor(private  http:HttpClient,private router:Router) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8888/CLIENT-SERVICE/clients?projection=allClient").subscribe(
      {
        next:(data)=>{
          this.clients=data;
        },
        error:(err)=>{}
      }
    );
  }
  getFacture(f:any){
this.router.navigateByUrl("/factures/"+f.id);
  }
}
