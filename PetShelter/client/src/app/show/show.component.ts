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
    name: "",
    type: "",
    description: "",
    likes: 0,
    skills: [
      {skill: ""},
      {skill: ""},
      {skill: ""},
    ]
  }

  bool: Boolean;

  secondary:any = {rating:1, review:""}

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: HttpService
  ) { }

  ngOnInit() {
    this.getObject();
    this.bool = false;
  }

  getObject() {
    let id = this.route.snapshot.params.id
    let o = this.service.findOne(id);
    o.subscribe(data => {
      this.object = data;
    })
  }




  likePet() {
    this.bool = true;
    this.object.likes += 1;
    let o = this.service.updateOne(this.object);
    o.subscribe(data => {
      this.getObject()
    })
  }


  adopt(id) {
    let o = this.service.deleteOne(id);
    o.subscribe(data => {
      this.router.navigate(['/'])
    })
  }





}
