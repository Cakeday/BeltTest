import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  objects:any = []
  nester:any;
  self:any;

  constructor(
    private router:Router,
    private route: ActivatedRoute,
    private service:HttpService
  ) { }


  ngOnInit() {
    this.getObjects();
    this.self = this;
  }

  getObjects(){ 
    let o = this.service.findAll();
    o.subscribe(data => {
      console.log(data);
      this.objects = data;
    })
  }

  deleteObject(id){
    let o = this.service.deleteOne(id)
    o.subscribe(data => {
      console.log(data);
      this.getObjects();
    })
  }

  selectNester(x){
    if(this.nester) {
      this.nester = null;
      return
    }
    this.nester = x;
  }
}
