import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { KeynoteService } from '../../services/keynote.service';
import { Keynote } from '../../models/keynote.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-keynotes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './keynotes.component.html',
  styleUrls: ['./keynotes.component.css']
})
export class KeynotesComponent implements OnInit {
  keynotes: Keynote[] = [];

  constructor(private keynoteService: KeynoteService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.keynoteService.getAllKeynotes().subscribe({
      next: (data) => {
        console.log('Keynotes received:', data);
        this.keynotes = data;
        this.cdr.detectChanges();
      },
      error: (err) => console.error(err)
    });
  }
}
