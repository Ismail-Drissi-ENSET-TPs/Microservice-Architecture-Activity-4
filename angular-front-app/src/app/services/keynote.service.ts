import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Keynote } from '../models/keynote.model';

@Injectable({
  providedIn: 'root'
})
export class KeynoteService {
  private apiUrl = 'http://localhost:8081/api/keynotes';

  constructor(private http: HttpClient) { }

  getAllKeynotes(): Observable<Keynote[]> {
    return this.http.get<Keynote[]>(this.apiUrl);
  }

  getKeynoteById(id: number): Observable<Keynote> {
    return this.http.get<Keynote>(`${this.apiUrl}/${id}`);
  }
}
