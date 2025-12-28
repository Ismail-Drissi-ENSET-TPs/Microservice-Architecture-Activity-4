import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Conference } from '../models/conference.model';

@Injectable({
  providedIn: 'root'
})
export class ConferenceService {
  private apiUrl = 'http://localhost:8082/api/conferences';

  constructor(private http: HttpClient) { }

  getAllConferences(): Observable<Conference[]> {
    return this.http.get<Conference[]>(this.apiUrl);
  }
}
