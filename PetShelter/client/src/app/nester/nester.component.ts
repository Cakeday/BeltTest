import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'Nester',
  templateUrl: './nester.component.html',
  styleUrls: ['./nester.component.css']
})
export class NesterComponent implements OnInit {

  @Input() object:any;
  @Input() parent:any;
  
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: HttpService
  ) { }

  ngOnInit() {
  }
  closeSelf(){
    this.parent.nester = null;
  }
  
  updateObject() {
    let o = this.service.updateOne(this.object);
    o.subscribe(data => {
      console.log(data)
      // validations go here
    })
  }
  
  deleteSecondaryObject(i) {
    this.object.ratings.splice(i,1)
    this.updateObject()
  }
}
