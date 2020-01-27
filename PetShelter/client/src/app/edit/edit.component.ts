import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  formObject: any = {
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
  errors = [];

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
      this.formObject = data;
    })
  }

  updateObject() {
    let o = this.service.updateOne(this.formObject);
    o.subscribe(data => {
      console.log(data)
      // validations go here
      if (data['errors']) {
        for (let field in data['errors']) {
          this.errors.push(data['errors'][field]['message'])
        }
        // this.errorMsg = data['error']
        return;
      }
      this.router.navigate(['/'])
    })
  }

}
