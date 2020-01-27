import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {
  object:any = {
    title: "",
    description: "",
    url: "",
    ratings: [{
      rating: 1,
      review: ""
    }]
  }

  secondary:any = {rating:1, review:""}

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: HttpService
  ) { }

  ngOnInit() {
    this.getObject()
  }

  getObject() {
    let id = this.route.snapshot.params.id
    let o = this.service.findOne(id);
    o.subscribe(data => {
      this.object = data;
    })
  }
  
  updateObject() {
    let o = this.service.updateOne(this.object);
    o.subscribe(data => {
      console.log(data)
      // validations go here
      this.secondary = {rating:1, review:""}
    })
  }

  addSecondaryObject() {
    this.object.ratings.push(this.secondary)
    this.updateObject()
  }

  

  deleteSecondaryObject(i) {
    this.object.ratings.splice(i,1)
    this.updateObject()
  }
}
