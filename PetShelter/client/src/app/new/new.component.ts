import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css']
})
export class NewComponent implements OnInit {
  formObject = {
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

  errorMsg = "";
  errors = [];
  bool = true;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: HttpService
  ) { }

  ngOnInit() {
  }

  createObject() {
    console.log(this.formObject)
    let o = this.service.create(this.formObject);
    o.subscribe(data => {
      console.log(data);
      if(data['errors']) {
        for(let field in data['errors']) {
          this.errors.push(data['errors'][field]['message'])
        }
        // this.errorMsg = data['error']
        console.log(this.errors);
        return;
      }
      this.router.navigate(['/'])
    })
  }


}
