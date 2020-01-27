import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get('/api/findAll')
  }
  findOne(id) {
    return this.http.get(`/api/findOne/${id}`)
  }
  create(object) {
    return this.http.post('/api/create', object)
  }
  updateOne(object) {
    return this.http.put('/api/updateOne', object)
  }
  deleteOne(id) {
    return this.http.delete(`/api/deleteOne/${id}`)
  }
}
